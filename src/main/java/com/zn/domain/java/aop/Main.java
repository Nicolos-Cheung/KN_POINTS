package com.zn.domain.java.aop;

import com.zn.domain.java.aop.bean.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/04/13
 */
public class Main {
    public static void main(String[] args) {
        //模拟容器初始化
        ApplicationContext applicationContext = new ApplicationContext();

        ConcurrentHashMap<String, Object> proxyBeanMap = ApplicationContext.proxyBeanMap;

        //生成代理对象，默认为该类名的小写
        Test test = (Test) proxyBeanMap.get("test");
        test.doSomeThing();


        System.out.println("------------------");
        test.doWtihNotProxy();
    }

}
