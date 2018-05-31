package com.asela;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class EfficientOfficeGenerator {
    static {
        try {
            System.setOut(new PrintStream(String.format("efficient-office-input-%s.in", ThreadLocalRandom.current().nextInt(0, 1))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        int m = 100, n = 1000, r = 10;
        System.out.printf("%s %s%n", n, m);
        for(int i = 0; i < n ; i++) {
            List<String> list = new ArrayList<>();
            for(int j = 0; j < m ; j++) {
               list.add(ThreadLocalRandom.current().nextInt() % r == 0 ? "1" : "0");
            }
            System.out.println(list.stream().collect(Collectors.joining(" ")));
        }
    }
}
