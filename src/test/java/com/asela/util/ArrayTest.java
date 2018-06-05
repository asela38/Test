package com.asela.util;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;

public class ArrayTest {
    
    @Test
    public void testArray() throws Exception {
      
        StopWatch stopWatch = new StopWatch();
        int[] a = new int[1<<19];
        int[] b = new int[1<<19];
        stopWatch.start();
        for(int i = 0; i < a.length; i++)
            a[i] = b[i];
        stopWatch.stop();
        System.out.println(stopWatch);
            
            
    }

}
