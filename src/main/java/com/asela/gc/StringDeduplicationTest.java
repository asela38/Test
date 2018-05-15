package com.asela.gc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class StringDeduplicationTest {

    /**
     * The following flags are needed to enable String Deduplication on JDK 8:
     * -XX:+UseG1GC    Enables the G1 garbage collector.
     * -XX:+UseStringDeduplication Enables the String Deduplication feature within G1.
     * -XX:+PrintStringDeduplicationStatistics Optional flag to analyze what is happening through the command-line.
     * -XX:StringDeduplicationAgeThreshold=3   Optional flag to change when Strings become eligible for deduplication.
     * 
     * -XX:+UseG1GC -XX:+UseStringDeduplication -XX:+PrintStringDeduplicationStatistics
     * @throws InterruptedException 
     */
    
    public static void main(String[] args) throws InterruptedException {
        
        List<String> list = new ArrayList<>();
        for(int i = 0; i < 2_000_000; i++) {
            list.add("This is a simple string " + i % 1_000);
            TimeUnit.MILLISECONDS.sleep(1);
        }
    }
}
