package com.zn.domain.java.thread.demo;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/07/05
 */
public class DeadLockDetect implements  Runnable {

    private ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();

    @Override
    public void run() {

        while(true) {

            long[] threadIds = mxBean.findDeadlockedThreads();

            if (threadIds != null) {

                ThreadInfo[] threadInfo = mxBean.getThreadInfo(threadIds);

                for (ThreadInfo thread : threadInfo) {

                    StringBuilder sb = new StringBuilder();
                    sb.append("threadName:").append(thread.getThreadName()).append("\n");

                    StackTraceElement[] stackTrace = thread.getStackTrace();
                    for (StackTraceElement ste : stackTrace) {
                       sb.append("线程堆栈信息:"+ste.getClassName() + ste.getMethodName() + ste.getFileName()
                                + ste.getLineNumber());
                    }

                    System.out.println(sb.toString());
                }
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
