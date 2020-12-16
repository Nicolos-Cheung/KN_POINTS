package zn.leave.domain.java.aop.util;

import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @author zhangning
 * @date  13/4/20
 */
public class ClassUtil {
    /**
     * 获取类加载器
     *
     * @return
     */
    public static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    /**
     * 加载类
     * 需要提供类名是否初始化标志
     * 初始化是指知否执行静态代码块
     *
     * @param className
     * @param isInitialized
     * @return
     */
    public static Class<?> loadClass(String className, boolean isInitialized) {
        Class<?> cls;
        try {
            cls = Class.forName(className, isInitialized, getClassLoader());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return cls;
    }

    /**
     * 加载类(默认将初始化类)
     *
     * @param className
     * @return
     */
    public static Class<?> loadClass(String className) {
        return loadClass(className, true);
    }

    public static Set<Class<?>> getClassSet(String packageName) throws IOException {
        Set<Class<?>> classSet = new HashSet<>();
        try {
            Enumeration<URL> urls = getClassLoader().getResources(packageName.replace(".", "/"));
            //Enumeration相当于老板迭代器
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                if (url != null) {
                    //获得URL的协议
                    String protocol = url.getProtocol();
                    if (protocol.equals("file")) {
                        //转码
                        //转码为utf-8的格式
                        String packagePath = URLDecoder.decode(url.getFile(), "UTF-8");
                        addClass(classSet, packagePath, packageName);
                    } else if (protocol.equals("jar")) {
                        //解析Jar文件
                        JarURLConnection jarURLConnection = (JarURLConnection) url.openConnection();
                        if (jarURLConnection != null) {
                            JarFile jarFile = jarURLConnection.getJarFile();
                            if (jarFile != null) {
                                Enumeration<JarEntry> jarEntries = jarFile.entries();
                                while (jarEntries.hasMoreElements()) {
                                    JarEntry jarEntry = jarEntries.nextElement();
                                    String jarEntryName = jarEntry.getName();
                                    if (jarEntryName.endsWith(".class")) {
                                        String className = jarEntryName.substring(0, jarEntryName.lastIndexOf(".")).replaceAll("/", ".");
                                        doAddClass(classSet, className);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw e;
        }
        return classSet;
    }
    private static void addClass(Set<Class<?>> classSet,String packagePath,String packageName){

        File[] files = new File(packagePath).listFiles(file -> (file.isFile() && file.getName().endsWith(".class") || file.isDirectory()));

        for(File file : files){
            String fileName = file.getName();
            if(file.isFile()){
                String className = fileName.substring(0,fileName.lastIndexOf("."));

                if(StringUtils.isNotBlank(packageName)){
                    className = packageName + "." + className;
                }
                //添加
                doAddClass(classSet,className);
            }else{
                //子目录
                String subPackagePath = fileName;
                if(StringUtils.isNotBlank(packagePath)){
                    subPackagePath = subPackagePath + "/" + subPackagePath;
                }
                String subPackageName = fileName;
                if(StringUtils.isNotBlank(packageName)){
                    subPackageName = packageName + "." + subPackageName;
                }
                addClass(classSet,subPackagePath,subPackageName);
            }
        }
    }
    private static void doAddClass(Set<Class<?>> classSet,String className){
        Class<?> cls = loadClass(className,false);
        classSet.add(cls);
    }
}
