package com.zn.domain.java.thread.pool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Stack;
import java.util.concurrent.*;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/06/17
 */
public class ThreadPoolTest1 {


    /**
     * 从任务的优先级，任务的执行时间长短，任务的性质(CPU密集/ IO密集)，任务的依赖关系这四个角度来分析。并且近可能地使用有界的工作队列。
     * 性质不同的任务可用使用不同规模的线程池分开处理:
     * CPU密集型: 尽可能少的线程，Ncpu+1
     * IO密集型: 尽可能多的线程, Ncpu*2，比如数据库连接池
     * 混合型: CPU密集型的任务与IO密集型任务的执行时间差别较小，拆分为两个线程池；否则没有必要拆分。
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {


        Executors.newSingleThreadExecutor();


        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();


        /**
         *  推荐使用ThreadPoolExecutor创建线程池
         */
        ExecutorService pool = new ThreadPoolExecutor(5, 200,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());


        pool.execute(() -> System.out.println(Thread.currentThread().getName()));


        Future<Integer> result = pool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return null;
            }
        });
        Integer integer = result.get();

        //gracefully shutdown
        pool.shutdown();

        Stack s= new Stack();




    }
}
