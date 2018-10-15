package test.java.lang.concurrent;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ForkJoinThreadPoolTest {

    private Stream<String> stringStream;

    @Before
    public void initialize() {
        stringStream = Stream.of("a", "b", "c", "d", "e", "f", "g", "h", "i");
    }

    private String printThreadInfo(String string) {
        System.out.printf("%50s - %-20s (%s) %n", Thread.currentThread().getName(),
                Thread.currentThread().getThreadGroup().getName(), string);
        return string;
    }

    @Test
    public void test1_serialStream() throws Exception {
        System.out.println("test1_serialStream");
        stringStream.map(this::printThreadInfo).collect(Collectors.toList());
    }

    @Test
    public void test2_parallelStream() throws Exception {
        System.out.println("test2_parallelStream");
        stringStream.parallel().map(this::printThreadInfo).collect(Collectors.toList());
    }

    @Test
    public void test3_fromNewForkJoinPool_serialStream() throws Exception {
        System.out.println("test3_fromNewForkJoinPool_serialStream");
        ForkJoinPool forkJoinPool = new ForkJoinPool(2);
        forkJoinPool.execute(() -> {
            printThreadInfo("Original");
            stringStream.map(this::printThreadInfo).collect(Collectors.toList());
        });
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.MINUTES);
    }

    @Test
    public void test4_fromNewForkJoinPool_parallelStream() throws Exception {
        System.out.println("test4_fromNewForkJoinPool_parallelStream");
        ForkJoinPool forkJoinPool = new ForkJoinPool(2);
        forkJoinPool.execute(() -> {
            printThreadInfo("Original");
            stringStream.parallel().map(this::printThreadInfo).collect(Collectors.toList());
        });
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.MINUTES);
    }
}
