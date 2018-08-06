package com.asela;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;

public class ComparisonOperatorVsArrayAccess {
    
    @Test
    public void testPerformanceOf() throws Exception {

        int[] array = ThreadLocalRandom.current().ints(0,1000).limit(10_000).toArray();
        
        AtomicInteger count = new AtomicInteger();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        IntStream.range(0, 1000)
            .forEach(i -> {
                if(i % 2 == 0) count.incrementAndGet(); 
            
        });
        stopWatch.stop();
        int f = count.get();
        count.set(0);
        int[] an = new int[] {0,1};
        stopWatch.reset();
        stopWatch.start();
        IntStream.range(0, 1000)
            .forEach(i -> {
                 count.addAndGet(an[i%2]); 
            
        });
        System.out.println(stopWatch);
        assertThat(count.get(), is(f));
    }

}
