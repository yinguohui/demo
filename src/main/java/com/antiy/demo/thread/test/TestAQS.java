package com.antiy.demo.thread.test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author ygh
 * @Description
 * @Date 2020/11/25
 */
public class TestAQS {
    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
//        lock.writeLock().lock();
//        lock.readLock().lock();
//        lock.readLock().unlock();
//        lock.readLock().unlock();

        ConcurrentHashMap hashMap = new ConcurrentHashMap(16);
        hashMap.put("key","value");
        hashMap.get("key");
    }
}
