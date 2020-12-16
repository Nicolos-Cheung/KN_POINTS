package com.zn.domain.java.thread.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/03/20
 */
public class MulitiThreadCompete extends Thread {


    private static Integer counter = 0;
    private static Lock lock = new ReentrantLock();
    static final int LOOP = 100000;


    public static void main(String[] args) throws InterruptedException {
        List<MulitiThreadCompete> tlist = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            tlist.add(new MulitiThreadCompete());
            tlist.get(i).start();
        }
        while (true) {
            if (!tlist.stream().anyMatch(MulitiThreadCompete::isAlive)) {
                System.out.println(counter);
                break;
            }
            Thread.sleep(100);
        }
    }

    @Override
    public void run() {

//        lock.lock();
        try {
            for (int i = 0; i < LOOP; i++) {

                synchronized (MulitiThreadCompete.class){
                    counter++;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        finally {
//            lock.unlock();
//        }
    }
}


