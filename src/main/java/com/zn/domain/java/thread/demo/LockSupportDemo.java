package com.zn.domain.java.thread.demo;

import java.util.concurrent.locks.LockSupport;

/**
 * ABCDEFG
 * 1234567
 * 交替打印
 *
 * @author ning
 * @date 2020/11/28
 */
public class LockSupportDemo {

    static Thread t1,t2;

    public static void main(String[] args) {

        char[] arr1 = "ABCDEFG".toCharArray();
        char[] arr2 = "1234567".toCharArray();


        t1 = new Thread(() -> {

            for (char c : arr1) {

                System.out.println(c);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        });

        t2 = new Thread(() -> {
            for (char c : arr2) {
                LockSupport.park(); //先阻塞(等待t1唤醒)
                System.out.println(c);
                LockSupport.unpark(t1);
            }
        });

        t1.start();
        t2.start();
    }
}
