package com.zn.domain.java.thread.threadlocal;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/11/16
 */
public class Demo1 {

    public static void main(String[] args) {

        //ThreadLocal造成的内存泄露
        ThreadLocal l = new ThreadLocal();

        new Thread(() -> {
            l.set("date");
            while (true) {
                //线程一直运行
            }

        }).start();

        //销毁l, thread中的date永远无法销毁和获取，因为theadlocalmap中的key是l。

    }
}
