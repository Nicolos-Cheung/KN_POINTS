package com.zn.domain.java.thread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/06/17
 */
public class ThreadPoolTest2 {


    public static void main(String[] args) throws Exception {


        //可定时 延迟执行任务
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);

//        pool.schedule()
        pool.shutdown();


    }
}
