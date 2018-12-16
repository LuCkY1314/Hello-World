package com.example.chansiqing.databindingstudy.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 子线程无序线程池
 *
 * @author: chansiqing
 * @date: 2018-11-10 20:41
 */
public class JDHomeNoUIThreadPool {

    private static final int CORE_THREAD_NUM = 1;
    private static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(CORE_THREAD_NUM);

    /**
     * 添加新的子线程任务
     * @param runnable
     */
    public static void addTask(Runnable runnable) {
        fixedThreadPool.submit(runnable);
    }

    /**
     * 获取当前线程池中线程数
     *
     * @return
     */
    public static int getThreadNum() {
        return ((ThreadPoolExecutor) fixedThreadPool).getPoolSize();
    }

    /**
     * 获取当前线程池中正在执行的线程数
     *
     * @return
     */
    public static int getCurrentRunThreadNum() {
        return ((ThreadPoolExecutor) fixedThreadPool).getActiveCount();
    }

    /**
     * （不精确的）已经执行过的线程数
     *
     * @return
     */
    public static long getExecutedThreadNum() {
        return ((ThreadPoolExecutor) fixedThreadPool).getTaskCount();
    }

    /**
     * 销毁线程池
     */
    public static void destroy() {
        fixedThreadPool.shutdown();
    }
}
