package com.asela.functional;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.junit.Test;


public class FunctionalInterfaceTest {
    
    @Test
    public void test() throws Exception {
        Function<Map<Integer,Integer>, Function<Integer, Integer>> funny = a -> b -> a.get(1) + a.get(2) + b;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 10);
    //    map.put(2, 20);
        
        Function<Integer, Integer> funnyClosure = funny.apply(map);
        
        System.out.println(funnyClosure.apply(11));
        
        map.put(1, 12);

        System.out.println(funnyClosure.apply(11));
        
        map = null;
        
        System.out.println(funnyClosure.apply(11));
        
        System.gc();
        
        System.out.println(funnyClosure.apply(11));
    }
    
    @Test
    public void test2() throws Exception {
        Function<Map<Integer,Integer>, Function<Integer, Integer>> funny = a -> b ->  a.put(b, a.getOrDefault(1, b) + a.getOrDefault(2, b));
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 10);
        map.put(2, 20);
        
        Function<Integer, Integer> funnyClosure = funny.apply(map);
        
        System.out.println(funnyClosure.apply(11));
        
        map.put(1, 12);

        System.out.println(funnyClosure.apply(11));
        
//        map = null;
        
        System.out.println(funnyClosure.apply(11));
        
        System.gc();
        
        System.out.println(funnyClosure.apply(11) + " " + map);
        System.out.println(funnyClosure.apply(21) + " " + map);
        System.out.println(funnyClosure.apply(31) + " " + map);
        
    }
    
    
    
    

}
