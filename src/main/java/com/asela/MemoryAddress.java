package com.asela;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;

public class MemoryAddress {

    private static int i         = 0;

    StopWatch          stopWatch = new StopWatch();
    {
        stopWatch.start();
    }

    @Test
    public void testName() throws Exception {
        stopWatch.split();
        int[] a1 = new int[100];
        int[] a2 = new int[100];
        int[] a3 = new int[100];
        int[] a4 = new int[100];
        int[] a5 = new int[100];
        System.out.println(
                i++ + "--" + stopWatch.toSplitString() + "--" + Arrays.stream(a1).boxed().filter(i -> i == 0).count()
                        + "---" + Arrays.stream(a2).boxed().filter(i -> i == 0).count() + "---"
                        + Arrays.stream(a3).boxed().filter(i -> i == 0).count() + "---"
                        + Arrays.stream(a4).boxed().filter(i -> i == 0).count() + "---"
                        + Arrays.stream(a5).boxed().filter(i -> i == 0).count());

        testName();

    }

    @Test
    public void testWithThread() throws Exception {
        Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getStackTrace().length);
                e.printStackTrace(System.out);
            }
        });
        MemoryAddress memoryAddress = new MemoryAddress();
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                try {
                    memoryAddress.testName();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };

        Thread a1 = new Thread(runnable);
        Thread a2 = new Thread(runnable);
        Thread a3 = new Thread(runnable);
        Thread a4 = new Thread(runnable);
        Thread a5 = new Thread(runnable);
        Thread a6 = new Thread(runnable);

        a1.start();
        a2.start();
        a3.start();
        a4.start();
        a5.start();
        a6.start();

        a1.join();
        a2.join();
        a3.join();
        a4.join();
        a5.join();
        a6.join();
    }

    @Test
    public void testWithThread2() throws Exception {
        Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getStackTrace().length);
                e.printStackTrace(System.out);
            }
        });
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                try {
                    
                    System.out.println(Thread.currentThread().getName() + " is Waiting");
                    TimeUnit.HOURS.sleep(1);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };

        Thread a1 = new Thread(runnable);
        Thread a2 = new Thread(runnable);
        Thread a3 = new Thread(runnable);
        Thread a4 = new Thread(runnable);
        Thread a5 = new Thread(runnable);
        Thread a6 = new Thread(runnable);

        a1.start();
        a2.start();
        a3.start();
        a4.start();
        a5.start();
        a6.start();

        a1.join();
        a2.join();
        a3.join();
        a4.join();
        a5.join();
        a6.join();
    }

}
