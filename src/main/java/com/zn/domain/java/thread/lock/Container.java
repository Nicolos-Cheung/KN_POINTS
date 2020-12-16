package com.zn.domain.java.thread.lock;

import java.util.Vector;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者 & 等待通知机制
 *
 * @author ning
 * @date 2020/11/30
 */
public class Container<T> {
    private final Vector<T> countNum;
    private int max;
    private Lock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();

    public Container(int max) {
        this.max = max;
        countNum = new Vector<>(max);
    }

    // 生产者
    public void put(T t) {
        try {
            lock.lock();
            while (countNum.size() == max) {
                System.err.println("队列已满");
                producer.await();
            }
            countNum.add(t);
            System.out.println("produce success");
            // 通知消费者线程进行消费
            consumer.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    // 消费者
    public T get() {
        T t = null;
        try {
            lock.lock();
            while (countNum.size() == 0) {
                System.err.println("队列空");
                consumer.await();
            }

            t = countNum.remove(0);
            System.out.println("consume success");
            // 通知生产者进行生产
            producer.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return t;
    }

}
