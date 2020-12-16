package com.zn.domain.java.thread.demo;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/03/25
 */
public class TestDeadLock {

    private static String file1 = "文件1";
    private static String filed2 = "文件2";

    public static void main(String[] args) {



        new Thread(() -> {
            while (true) {
                synchronized (file1) {
                    synchronized (filed2) {
                    }
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                synchronized (filed2) {
                    synchronized (file1) {
                    }
                }
            }
        }).start();
    }
}
