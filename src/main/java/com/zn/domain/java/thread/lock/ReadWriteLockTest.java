package com.zn.domain.java.thread.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/11/30
 */
public class ReadWriteLockTest {

    /**
     * 写写&读写 ->互斥
     * <p>
     * 读读 ->不互斥
     */
    private static final ReadWriteLock rwl = new ReentrantReadWriteLock();


    public static void main(String[] args) {

        //多线程并发持有
        rwl.readLock();

        rwl.writeLock();

    }


}
