package com.asela.functional;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class StreamExploration {
    
    @Test
    public void testName() throws Exception {
        
        List<Integer> list = Arrays.asList(1,2,3,4);
        
        System.out.println(list.stream().mapToInt(i -> i).sum());
        
    }

}
