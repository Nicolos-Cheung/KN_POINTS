package zn.leave.domain.java.aop.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 通过反射机制创建实例调用方法和设置成员变量的值
 * @author zhangning
 * @date  13/4/20
 */
public class ReflectionUtil {
    /**
     * 创建实例
     */
    public static Object newInstance(Class<?> cls){
        Object instance;

        try{
            instance = cls.newInstance();
        }catch (Exception e){
            throw new RuntimeException();
        }
        return instance;
    }

    /**
     * 创建实例 根据类名
     */
    public static Object newInstance(String className){
        Class<?> cls = ClassUtil.loadClass(className);
        return newInstance(cls);
    }

    /**
     * 调用方法
     */
    public static Object invokeMethod(Object obj, Method method,Object... args){
        Object result;
        try{
            method.setAccessible(true);
            result = method.invoke(obj,args);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return result;
    }

    /**
     * 设置成员变量的值
     */
    public static void setField(Object obj, Field field,Object value){
        try{
            field.setAccessible(true);
            field.set(obj,value);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
