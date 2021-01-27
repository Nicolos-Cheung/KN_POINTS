package com.zn.domain.java.thread.lock;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 手写ReentrantLock
 *
 * @author ning
 * @date 2021/01/27
 */
public class CustomReentrantLock implements Lock {


    private final NonfairSync sync;

    public CustomReentrantLock() {
        sync = new NonfairSync();
    }

    static final class NonfairSync extends AbstractQueuedSynchronizer {

        @Override
        protected boolean tryAcquire(int acquires) {
            final Thread current = Thread.currentThread();
            int c = getState();
            if (c == 0) {
                if (compareAndSetState(0, acquires)) {
                    setExclusiveOwnerThread(current);
                    return true;
                }
            } else if (current == getExclusiveOwnerThread()) {

                //重入次数
                int nextc = c + acquires;
                setState(nextc);
                return true;
            }
            return false;
        }

        final void lock() {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
            } else {
                acquire(1);
            }
        }
    }


    @Override
    public void lock() {
        sync.lock();
    }

    @Override
    public void unlock() {
        sync.release(1);
    }


    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, @NotNull TimeUnit unit) throws InterruptedException {
        return false;
    }


    @NotNull
    @Override
    public Condition newCondition() {
        return null;
    }
}
