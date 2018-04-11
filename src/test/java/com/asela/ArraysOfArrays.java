package com.asela;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.Test;

public class ArraysOfArrays {
    
    @Test
    public void test() throws Exception {
        int[][] x = new int[2][2];
        
        int[] y = new int[]{6, 7};
        x[0] = y;
        x[1] = y;
        
        printArray(x);
        
        x[0][0] = 10;
        
        printArray(x);
    }

    private void printArray(int[][] x) {
        System.out.println(Arrays.stream(x).map(Arrays::toString).collect(Collectors.joining("\n ", "[\n ", "\n]")));
    }

}
