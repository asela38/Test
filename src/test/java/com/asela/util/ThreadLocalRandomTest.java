package com.asela.util;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import org.junit.Test;

public class ThreadLocalRandomTest {

    @Test
    public void generate3IntegersAndSorts() throws Exception {

        IntStream.range(1, 100).forEach(i -> System.out
                .println(Arrays.toString(ThreadLocalRandom.current().ints(4, 10, 50).sorted().toArray())));

    }
}
