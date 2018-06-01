package com.asela.monad;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;

public class StreamTest {

    
    @Test
    public void testStreams() throws Exception {
        
        System.out.println(Stream.of(1,2,3,4,5).map(i -> i + 2).collect(Collectors.toList())) ;
        System.out.println(Optional.of("Test").map(s -> s.concat(" ").concat(" One")).get());
    }
    
    @Test
    public void testStreamTwo() throws Exception {
    //    new BufferedReader(new FileReader("input.txt")).lines();
        List<String> list = new ArrayList<>();
        ThreadLocalRandom.current().ints();
        IntStream.iterate(1, i -> i++).limit(100);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        long sampleSize = 1_000_000_000L;
        long count =  ThreadLocalRandom.current().doubles(0,1)
            .limit(sampleSize)
            .parallel()
            .map(d -> Math.pow(d, 2D))
            .map(d -> d + Math.pow(ThreadLocalRandom.current().nextDouble(0D,1D), 2D))
            .map(Math::sqrt)
            .filter(d -> d < 1D)
            .count();
        stopWatch.stop();
        System.out.printf("Original: %s Computed: %s , Time: %s %n",
                Math.PI,
                4D * count / sampleSize,
                stopWatch);
        System.out.println(Math.PI);
       
    }
    

    @Test
    public void test1() throws Exception {
        
    }
}




