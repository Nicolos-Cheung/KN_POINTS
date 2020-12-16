package com.zn.domain.designpattern.proxy.jdk;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/01/26
 */
public class Simulator {

    public static void main(String[] args) {

        // jdk动态代理测试
        Subject subject = new JDKDynamicProxy(new RealSubject()).getProxy();
        subject.doSomething();
    }
}
