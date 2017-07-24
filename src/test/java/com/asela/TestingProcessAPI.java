package com.asela;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

import org.junit.Test;

/**
 * Motivation on <a href="https://javax0.wordpress.com/">
 * https://javax0.wordpress.com/ </a>
 * 
 * @author asela.illayapparachc
 *
 */
public class TestingProcessAPI {
    
    @Test
    public void memoryFluctuation() throws Exception {
        AtomicLong previous = new AtomicLong();
        HashMap<Integer, String> hashMap = new HashMap<>();
        IntStream.iterate(0, i -> i + 1)
                 .limit(100)
                 .forEach(i -> {
                     hashMap.put(i, "ABCDEFG");
                     long current = Runtime.getRuntime().totalMemory();
                     if(i == 0) print("Initial : %d %n",current);
                     else print("Now %d change from previous : %d %n", current, current - previous.get());
                     previous.set(current);
                     try {
                        TimeUnit.SECONDS.sleep(1L);
                    } catch (InterruptedException e) {
                        throw new IllegalStateException(e);
                    }
                 });
        
    }

    private void print(String format, Object...args) {
        System.out.printf(format, args);
    }

    @Test
    public void listingAllRunningProcessors() throws Exception {
        
        System.out.println("Runtime.getRuntime().availableProcessors() : " + Runtime.getRuntime().availableProcessors());
                
        printMemory("Free", Runtime.getRuntime().freeMemory());
        printMemory("Total", Runtime.getRuntime().totalMemory());
        printMemory("Max", Runtime.getRuntime().maxMemory());
        
        Process process = Runtime.getRuntime().exec("tasklist");
        process.getOutputStream().close();
        new BufferedReader(new InputStreamReader(process.getInputStream())).lines().forEach(System.out::println);
        
        process.getOutputStream().close();
        int result = process.waitFor();
        System.out.println("Waiting for result: " + result);
        System.out.println("Exit Value "  + process.exitValue());
       
    }
    
   private void printMemory(String text, long bytes) {
       System.out.printf("%s Memory\t:\t %d bytes\t ( %d KB)\t (%d MB)%n", text, bytes, bytes/1024 , bytes/(1024*1024));
   }

}
