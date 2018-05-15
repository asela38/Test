package com.asela.util;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.internal.runners.statements.FailOnTimeout;
import org.junit.rules.Timeout;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class BlockingQueueTest {
    

    private static final int MIN_TIMEOUT = 2000;

  //  @Rule
    public Timeout timeout = new Timeout(MIN_TIMEOUT) {
        public Statement apply(Statement base, Description description) {
            return new FailOnTimeout(base, MIN_TIMEOUT) {
                @Override
                public void evaluate() throws Throwable {
                    try {
                        super.evaluate();
                        throw new Exception();
                    } catch (Exception e) {}
                }
            };
        }
    };
    @Test( expected=Exception.class)
    public void waitingUntilDataAvailable() throws Exception {
        BlockingQueue<Long> blockingQueue = new ArrayBlockingQueue<>(10);
        
        blockingQueue.take();
    }
    
    @Test
    public void waitSpecifiedTime() throws Exception {
        BlockingQueue<Long> blockingQueue = new ArrayBlockingQueue<>(10);
        
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(3L);
                blockingQueue.offer(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        Long poll = blockingQueue.poll(5, TimeUnit.SECONDS);
        System.out.println(poll);
    }
    
    

}
