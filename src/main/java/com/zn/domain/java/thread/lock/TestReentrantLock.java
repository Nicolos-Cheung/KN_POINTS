package com.zn.domain.java.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * AQS & ReentrantLock 解析
 *
 * @author ning
 * @date 2021/01/27
 */
public class TestReentrantLock {




    public static void main(String[] args) {


        ReentrantLock lock = new ReentrantLock();

        /**
         * 会调用Sync的acquire()方法
         *
         * NonfairSync-> Sync-> AQS（锁核心）
         *
         * NonfairSync 重写了 AQS tryAcquire
         *
         * AQS核心:
         * 1) volatile state 0->1 加了锁  1->2 重入一次
         * 2) 维护了一个队列  Node<->Node<—>Node 双向链表
         * Node中包含了Thread
         *
         */
        lock.lock();



    }
}
