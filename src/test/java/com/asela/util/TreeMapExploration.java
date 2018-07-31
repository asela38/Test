package com.asela.util;

import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class TreeMapExploration {

    @Test
    public void trival() throws Exception {

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        add(treeMap, 1);
        System.out.printf("FirstKey %s %n", treeMap.firstKey());
        add(treeMap, 5);
        System.out.printf("FirstKey %s %n", treeMap.firstKey());
        add(treeMap, 3);
        System.out.printf("FirstKey %s %n", treeMap.firstKey());
        add(treeMap, 4);
        System.out.printf("FirstKey %s %n", treeMap.firstKey());
        add(treeMap, 2);
        System.out.printf("FirstKey %s %n", treeMap.firstKey());
        add(treeMap, 6);
        System.out.printf("FirstKey %s %n", treeMap.firstKey());
        add(treeMap, 7);

        System.out.println(treeMap);
        int i = 5;
        System.out.printf("Ceiling of %s is %s %n", i = 1, treeMap.ceilingKey(i));
        System.out.printf("Ceiling of %s is %s %n", i = 2, treeMap.ceilingKey(i));
        System.out.printf("Ceiling of %s is %s %n", i = 3, treeMap.ceilingKey(i));
        System.out.printf("Ceiling of %s is %s %n", i = 4, treeMap.ceilingKey(i));
        System.out.printf("Ceiling of %s is %s %n", i = 5, treeMap.ceilingKey(i));

        System.out.printf("FirstKey %s %n", treeMap.firstKey());
        add(treeMap, 8);
        add(treeMap, 9);
        add(treeMap, 10);
        add(treeMap, 11);
        System.out.printf("FirstKey %s %n", treeMap.firstKey());

        System.out.printf("Higher of %s is %s %n", i = 1, treeMap.higherKey(i));
        System.out.printf("Higher of %s is %s %n", i = 2, treeMap.higherKey(i));
        System.out.printf("Higher of %s is %s %n", i = 3, treeMap.higherKey(i));
        System.out.printf("Higher of %s is %s %n", i = 4, treeMap.higherKey(i));
        System.out.printf("Higher of %s is %s %n", i = 5, treeMap.higherKey(i));

        System.out.println(treeMap.pollFirstEntry());
        System.out.println(treeMap.pollFirstEntry());
        System.out.println(treeMap.pollFirstEntry());
        System.out.println(treeMap.pollLastEntry());
        System.out.println(treeMap.pollLastEntry());
        System.out.println(treeMap.pollLastEntry());
    }

    public void add(TreeMap<Integer, Integer> map, Integer i) {
        map.put(i, i);
    }

    @Test
    public void findHighestFrequency() throws Exception {

        Stream.of(1,2,2,1,2,1,2,2,1,2,1,2,2,1,2,1,2,2,1,2,1,2,2,1,2)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max((a,b) -> a.getValue().compareTo(b.getValue()))
                .ifPresent(System.out::println);

    }

}
