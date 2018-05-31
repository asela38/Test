package com.asela;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class StringDeDuplicationTest {
    
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
        List<String> sList = new ArrayList<>();
        sList.add(new String("One Two Three"));
        sList.add(new String("One Two Three"));
        List<BigDecimal> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            list.add(new BigDecimal("1").divide(new BigDecimal("3") , new MathContext(10000)));
            sList.add(new String("One Two Three"));
            System.out.println("ONE" == "One".toUpperCase());
            TimeUnit.MILLISECONDS.sleep(10);
        }
    }

}
