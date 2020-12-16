package zn.leave.domain.java.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/11/30
 */

public class LockTest {

    public static void main(String[] args) {

        SaleTicket s = new SaleTicket();

        new Thread(s).start();
        new Thread(s).start();

    }


}

class SaleTicket implements Runnable {

    private Lock lock = new ReentrantLock();
    private int surplus = 100;

    @Override
    public void run() {
        while (surplus > 0) {

            try {
                lock.lock();
                System.out.println("成功出票,剩余" + surplus);
                surplus--;
            } finally {
                lock.unlock();
            }
        }

    }
}
