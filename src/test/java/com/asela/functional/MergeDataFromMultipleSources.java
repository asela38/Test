package com.asela.functional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

import org.junit.Test;

public class MergeDataFromMultipleSources {

    @Test
    public void consumerToFunction() {
        
        Function<Consumer<Map<String,String>>, Function<Map<String, String>, Map<String, String>>> 
            mapConsumerToMapFunction = consumer -> map -> { consumer.accept(map); return map; } ;
            
        Map<String, String> map = new HashMap<>();
        map.put("First", "Superman");
        
        Consumer<Map<String, String>> setFirstNameToBatMap = m ->  { 
            m.computeIfPresent("First", (k,v) -> "Batman");
        };
        
        System.out.println("Before: ");
        System.out.println("\tOrigianl : " + map);
        
        System.out.println("After: ");
        Map<String, String> map2 = mapConsumerToMapFunction.apply(setFirstNameToBatMap).apply(map);
        System.out.println("\tOriginal: " + map);
        System.out.println("\tResult: "  + map2);
        assertThat(map, is(map2));
        
    }
    
    @Test
    public void consumerChaining() {
        
       Function<String, Consumer<Map<Integer, String>>> appendToFirst = postFix -> map -> map.computeIfPresent(1, (k,v) -> v + postFix);
      
       Map<Integer, String> map = new HashMap<>();
       map.put(1, "AA");
       
       System.out.println("Before: ");
       System.out.println("\tOrigianl : " + map);
      
       appendToFirst.apply("X").andThen(appendToFirst.apply("Y")).andThen(appendToFirst.apply("Z")).accept(map);
       
       System.out.println("After: ");
       System.out.println("\tOriginal: " + map);
      
       
       
    }

}
