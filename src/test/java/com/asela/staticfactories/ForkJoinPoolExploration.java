package com.asela.staticfactories;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

public class ForkJoinPoolExploration {

    
    public String testName(ReentrantLock lock1, ReentrantLock lock2) {
        lock1.lock();
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock2.lock();
        lock1.unlock();
        lock2.unlock();
        return String.format("test : %20s", Thread.currentThread().getName());
    }

    @Test
    public void basic() throws Exception {

        ReentrantLock lock1 = new ReentrantLock(), lock2 = new ReentrantLock(); 
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        System.out.println(testName(lock1, lock2));
        ForkJoinTask<String> task1 = commonPool.submit(() -> this.testName(lock2, lock1));
        System.out.println(task1.join());
    }
}
    