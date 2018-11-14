package com.asela.concurrency;

import java.util.concurrent.RecursiveTask;

import org.junit.Test;

public class RecursiveTaskTest {

    @Test
    public void basic() throws Exception {
        System.out.println("Test");
        Fibonacci fibonacci = new Fibonacci(10);
        System.out.println(fibonacci.compute());
    }

    @SuppressWarnings("serial")
    static class Fibonacci extends RecursiveTask<Integer> {
        final int n;

        Fibonacci(int n) {
            this.n = n;
        }

        protected Integer compute() {
            System.out.printf("%5d = [%s]%n", n, Thread.currentThread().getName());
            if (n <= 1)
                return n;
            Fibonacci f1 = new Fibonacci(n - 1);
            f1.fork();
            Fibonacci f2 = new Fibonacci(n - 2);
            return f2.compute() + f1.join();
        }
    }

}
