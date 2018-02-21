package com.asela.collection;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.junit.Test;

public class RemoveDuplicates {

    @Test
    public void testName() throws Exception {

        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("One");
        list.add("Two");

        System.out.println(list);
        Executors.newSingleThreadExecutor().execute(() -> {
            IntStream.range(1, 1100).forEach(i ->  {
               try {
                   list.add("Two");
                   TimeUnit.MILLISECONDS.sleep(1L);
               } catch (Exception e) {
                   e.printStackTrace();
               }
            });
            // list.add("Three");
        });
        TimeUnit.SECONDS.sleep(1L);
        removeDuplicates(list);
   //     System.out.printf("size at %s : %s%n", LocalDateTime.now(), list.size());
        TimeUnit.SECONDS.sleep(1L);
        System.out.printf("size at %s : %s%n", LocalDateTime.now(), list.size());
    }

    public static <C extends Collection<E>, E> void removeDuplicates(C c) {

        Set<E> set = new LinkedHashSet<E>(c);
        c.clear();
        c.addAll(set);
    }
}
