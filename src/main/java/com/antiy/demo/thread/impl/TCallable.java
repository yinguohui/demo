package com.antiy.demo.thread.impl;

import java.util.concurrent.*;

/**
 * @Author ygh
 * @Description
 * @Date 2020/9/23
 */
public class TCallable implements Callable {
    @Override
    public Integer call() throws Exception {
        return 1;
    }

    public static void main(String[] args) {
        TCallable callable = new TCallable();
        ExecutorService executorService =   Executors.newSingleThreadExecutor();
        Future<Integer> a = executorService.submit(callable);
        try {
            if (a.get()==1){
                System.out.println("2");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }


}
