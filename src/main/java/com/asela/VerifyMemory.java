package com.asela;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class VerifyMemory {

    public static void main(String[] args) throws Exception {

        Map<String, Consumer<Integer>> numericalArrayCreationMap = new LinkedHashMap<>();
        numericalArrayCreationMap.put("Byte", b -> {
            byte[] a = new byte[1_000_000];
            for (int i = 0; i < a.length; i++)
                a[i] = 1;
        });
        numericalArrayCreationMap.put("Short", b -> {
            short[] a = new short[1_000_000];
            for (int i = 0; i < a.length; i++)
                a[i] = 1;
        });
        numericalArrayCreationMap.put("Integer", b -> {
            int[] a = new int[1_000_000];
            for (int i = 0; i < a.length; i++)
                a[i] = 1;
        });
        numericalArrayCreationMap.put("Long", b -> {
            long[] a = new long[1_000_000];
            for (int i = 0; i < a.length; i++)
                a[i] = 1;
        });

        TimeUnit.SECONDS.sleep(2L);

        for (Entry<String, Consumer<Integer>> entry : numericalArrayCreationMap.entrySet()) {
            TimeUnit.SECONDS.sleep(1L);
            long fmBefore = Runtime.getRuntime().freeMemory();
            entry.getValue().accept(1);
            long fmAfter = Runtime.getRuntime().freeMemory();
            System.out.printf("%n%7s : %015d", entry.getKey(), fmBefore - fmAfter);
            Runtime.getRuntime().gc();
        }

    }

}
