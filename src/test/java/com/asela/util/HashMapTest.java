package com.asela.util;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;

public class HashMapTest {

    @Test
    public void test_hash_display() throws Exception {
        System.out.println("Hash On basic integers 1 - 3");
        IntStream.range(0, 4)
            .peek(i -> System.out.print(i + "-> hash -> "))
            .map(HashMapTest::hash)
            .forEach(System.out::println);
   
        System.out.println("Hash On basic Long 1 - 3");
        LongStream.of(1, 3, 5, 
                1<<10 ,1<<10 ,1<<10 , 
                1 << 16, ( 1 << 16) + 1, (1 << 16) + 2, 
                1 << 17, (1 << 17 ) + 1, (1 << 17) + 2, 
                1 << 18, ( 1 << 18) + 1, (1 << 18) + 2,
                1 << 19, ( 1 << 19) + 1, (1 << 19) + 2,
                1 << 16, ( 1 << 16) + 1, (1 << 16) + 2, 
                1L << 32, ( 1L << 32) + 1, (1L << 32) + 2, 
                1L << 33, ( 1L << 33) + 1, (1L << 33) + 2,
                1L << 34, ( 1L << 34) + 1, (1L << 34) + 2)
            .peek(i -> System.out.print(i + "-> hash -> "))
            .map(HashMapTest::hash).forEach(System.out::println);
        
        
        printXOR((1L << 29) + 13);
        printXOR((1L << 30) + 13);
        printXOR((1L << 31) + 13);
        printXOR((1L << 32) + 13);
       
        LongStream.iterate(1, i -> i << 1)
        .limit(50)
        .peek(i -> System.out.print(i + "-> hash -> "))
        .mapToInt(Long::hashCode)
        .forEach(System.out::println);
        
        System.out.println(Integer.MAX_VALUE + "->" +hash(Integer.MAX_VALUE));
   
    }
    
    @Test
    public void capacityTest() {
        HashMap<Integer, Object> hashMap = new HashMap<>(2<<25);
        System.out.println("Test");
        IntStream.range(0, Integer.MAX_VALUE)
            .peek(key-> {
               if(key % 1_000_000 != 0) return;
               else System.out.println(key);
//               try {
//                Field field = HashMap.class.getDeclaredField("table");
//                field.setAccessible(true);
//                Object object = field.get(hashMap); 
//                int l;
//                System.out.println((l = Array.getLength(object)) + " -> " + Math.log(l)/ Math.log(2));
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            })
            .forEach(key -> hashMap.put(key, key));
        
          try {
             Field field = HashMap.class.getDeclaredField("table");
             field.setAccessible(true);
             Object object = field.get(hashMap); 
             int l;
             System.out.println((l = Array.getLength(object)) + " -> " + Math.log(l)/ Math.log(2));
         } catch (Exception e) {
             e.printStackTrace();
         }
          

         
        System.out.println(hashMap.size() + "x");
    }
    
    
    public static class DummyKey {
        
        Object value;
        
        public DummyKey(Object value) {
            this.value = value;
        }
        
        @Override
        public int hashCode() {
            return value != null ? value.hashCode(): 0;
        }
    }
    @Test
    public void hashMapEntryPerformance() throws Exception {
        HashMap<Integer, Integer> hashMap = new HashMap<>(1<<4, 1f);
        StopWatch stopWatch = new StopWatch();
        for(int i = 0; i < 1<<30; i++) {
            stopWatch.start();
            hashMap.put(ThreadLocalRandom.current().nextInt(), ThreadLocalRandom.current().nextInt());
            stopWatch.stop();
            if(stopWatch.getTime() != 0)
            System.out.println(i + " " + stopWatch.toString());
            stopWatch.reset();
        }
        
        
    }
    
    @Test
    public void analysisOfDistribution() throws Exception {
        HashMap<Object, Object> hashMap = new HashMap<>();
        for(int i = 0; i < 1<<25; i++) {
            hashMap.put(i, ThreadLocalRandom.current().nextInt());
            Field field = HashMap.class.getDeclaredField("table");
            field.setAccessible(true);
            Object array = field.get(hashMap); 
            int l =  Array.getLength(array);
            System.out.println(i + "," +  l);
        }   
        
        System.out.println("size " + hashMap.size());
        
   //     printHashMapInternals(hashMap);
        
        
    }

    private void printHashMapInternals(HashMap<Object, Object> hashMap) {
        try {
            Field field = HashMap.class.getDeclaredField("table");
            field.setAccessible(true);
            Object array = field.get(hashMap);
            int l = Array.getLength(array);
            System.out.println(l);
            for (int i = 0; i < l; i++) {
                Object node = Array.get(array, i);
                if (node == null) {
                    System.out.println(i + " has elements no elements");
                    continue;
                }
                Field fieldValue = node.getClass().getDeclaredField("value");
                fieldValue.setAccessible(true);

                Field fieldNext = node.getClass().getDeclaredField("next");
                fieldNext.setAccessible(true);

                System.out.printf("%s", i);
                do {
                    Object object = fieldValue.get(node);
                    System.out.printf(" -> %s ", object);

                    node = fieldNext.get(node);
                } while (node != null);
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testOne() throws Exception {
        System.out.println(Math.log(1<<20)/Math.log(2));
    }
    
    private void printXOR(long l) {
        System.out.println(Long.toBinaryString(l));
        System.out.println(Long.toBinaryString(l>>16));
        System.out.println(Long.toBinaryString(l ^ (l>>16)));
    }
    
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    
    @Test
    public void testNullAsKeyOnHashMap() throws Exception {
        
        HashMap<Object, Object> hashMap = new HashMap<>();
        assertThat(hashMap.size(), is(0));
        
        hashMap.put(null, "Hello");
        assertThat(hashMap.size(), is(1));
        assertThat(hashMap.get(null), is("Hello"));
        hashMap.put("f5a5a608", "Test");
        
        System.out.println(hashMap.get("f5a5a608"));
        
        printHashMapInternals(hashMap);
        
    }
    
    @Test
    public void testLocalFactor() throws Exception {
        String object = "I ";
        HashMap<Object, Object> hashMap = new HashMap<>(1<<4, 4f);
        IntStream.range(0, 50).forEach(i -> hashMap.put(i, object + i));
        printHashMapInternals(hashMap);
        
    }
    
    @Test
    public void testLocalFactor2() throws Exception {
        String object = "I ";
        HashMap<Object, Object> hashMap = new HashMap<>();
        IntStream.range(0, 16).forEach(i -> {
            hashMap.put(i, object + i);
            System.out.println();
            printHashMapInternals(hashMap);
        });
    }
}
