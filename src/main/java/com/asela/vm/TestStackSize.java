package com.asela.vm;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class TestStackSize {

    public static void main(String[] args) {
        System.out.println(IntStream.generate(() -> {
            AtomicInteger i  = new AtomicInteger(0);
            try {
                new TestStackSize().call(i);
            } catch (Throwable e) {
                return i.get();
            }
            return 0;
        }).limit(15).skip(5).peek(System.out::println).average());
    }

    private void call(AtomicInteger i) {
        i.incrementAndGet();
        call(i);
    }
}
