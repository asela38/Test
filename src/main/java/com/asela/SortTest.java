package com.asela;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

public class SortTest {

    @Test
    public void testName() throws Exception {

        String[] countries =  new String[] {"Sri Lanka", "United States", "India", "Singapore" };
        Comparator<String> comp = (a,b) -> b.compareTo(a);
        
        Arrays.sort(countries, comp);
        
        System.out.println(Arrays.binarySearch(countries, "India", comp));
        
    }
}
