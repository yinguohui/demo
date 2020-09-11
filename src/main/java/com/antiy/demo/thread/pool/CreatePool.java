package com.antiy.demo.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author ygh
 * @Description 线程池得创建
 * 单任务线程池
 * 固定大小线程池
 * 定时任务线程池
 * 无线缓存线程池
 * corePoolSize 核心线程
 * maximumPoolSize 最大线程
 * keepAliveTime 线程池除核心线程外的其他线程的最长空闲时间，超过该时间的空闲线程会被销毁
 *
 * 使用无界队列可能会抛出OOM
 *
 * 等待对列
 * SynchronousQueue  插入和删除操作总是成对出现且同时发生。因此队列实际上从不包含任何内容
 *  没有容量，不能缓存数据；每个put必须等待一个take; offer()的时候如果没有另一个线程在poll()或者take()的话返回false
 *
 * ArrayBlockingQueue： 这是一个由数组实现的容量固定的有界阻塞队列
 *
 * LinkedBlockingQueue： 这是一个由单链表实现的默认×××的阻塞队列。LinkedBlockingQueue提供了一个可选有界的构造函数，
 * 而在未指明容量时，容量默认为Integer.MAX_VALUE
 *
 * 拒绝策略
 *  AbortPolicy 丢弃任务并抛出RejectedExecutionException异常；也是默认的处理方式
 *  DisCardPolicy 多来的线程直接丢弃 丢弃任务，但是不抛出异常。
 *  DisCardOldSetPolicy 抛弃最老的任务 抛弃等待时间最长得任务 丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
 *  CallerRunsPolicy 线程池未关闭，则会在调用者线程中直接执行新任务 由调用线程处理该任务
 *
 *  shutdown() 不接收新任务,会处理已添加任务
 *  shutdownNow() 不接受新任务,不处理已添加任务,中断正在处理的任务
 * @Date 2020/9/9
 */
public class CreatePool {
    public static void main(String[] args) {
        //createFixedThreadPool();
        //createSingleThreadExecutor();
        //createCachedThreadPool();
        //createScheduledThreadPool();
//        ThreadLocal

        System.out.println("fdd27420-1c6a-42a0-aaa2-cc8e6519b681".length());
    }



    /**
     * 功能描述 : 创建只能一个得线程池
     * 核心数 = 最大线程数 = 1
     * 创建固定大小的线程池，使用无界队列会发生OOM
     *
     * 阻塞队列 LinkedBlockingQueue
     * @author ygh
     * @date 19:34
     */
    private static void createSingleThreadExecutor(){
        ExecutorService s = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 1000000; i++) {
            s.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
    }


    /**
     * 功能描述 : 创建固定大小的线程池
     *
     * 核心大小 = 最大大小 = 传入大小（大于0小于 int得最大值 ）
     *
     * 阻塞队列 LinkedBlockingQueue
     * @author ygh
     * @date 19:38
     */
    private static void createFixedThreadPool(){
        ExecutorService s = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000000; i++) {
            s.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }

            });
        }
    }


    /**
     * 功能描述 : 创建无线缓存得线程池
     *
     * 核心大小 = 0
     *  最大大小 = int 最大值
     *   任务存活 60s 60s会回收部分空闲的线程
     *     阻塞队列  采用直接交付的队列 SynchronousQueue ，队列容量为0，来一个创建一个线程
     * @author ygh
     * @date 19:38
     */
    private static void createCachedThreadPool(){
        ExecutorService s = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000000; i++) {
            s.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
    }

    private static void createScheduledThreadPool(){
        ExecutorService s = Executors.newScheduledThreadPool(100);
        for (int i = 0; i < 1000000; i++) {
            s.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
    }
}
