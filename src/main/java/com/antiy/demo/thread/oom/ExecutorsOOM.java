package com.antiy.demo.thread.oom;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @Author ygh
 * @Description 使用Executors创建线程导致的内存溢出
 * Executors为什么存在缺陷
 * @Date 2020/1/8
 */
public class ExecutorsOOM {
    private static ExecutorService executor = Executors.newFixedThreadPool(15);
    //相当于
//    return new ThreadPoolExecutor(nThreads, nThreads,
//                                      0L,TimeUnit.MILLISECONDS,
//                                      new LinkedBlockingQueue<Runnable>());
//  由于没有指定LinkedBlockingQueue的长度，所以就会用默认的大小Integer.MAX_VALUE，导致后面会OOM
    public static void main(String[] args) {
//        for (int i = 0; i < Integer.MAX_VALUE; i++) {
//            // 导致GC overhead limit exceeded
//            executor.execute(new SubThread());
//        }

        // 正确创建线程池
        // 参数一：核心线程，参数二 最大线程，参数三 存活时间， 参数四 时间单位 ，参数五 等待队列

//        这种情况下，一旦提交的线程数超过当前可用线程数时，就会抛出java.util.concurrent.RejectedExecutionException，
//        这是因为当前线程池使用的队列是有边界队列，队列已经满了便无法继续处理新的请求。但是异常（Exception）总比发生错误（Error）要好。
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        ExecutorService executorService = new ThreadPoolExecutor(5,200,0L,TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(1000),namedThreadFactory,new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 1024; i++) {
            // 导致GC overhead limit exceeded
            executorService.execute(new SubThread());
        }
    }
}

class SubThread implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            //do nothing
        }
    }
}