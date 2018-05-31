package com.asela;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

class OneBillionIntegerFileGenerator {
    
    public static void main(String[] args) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream("numbers_1B.in")))) {
            IntStream.generate(() -> 1000).map(ThreadLocalRandom.current()::nextInt).limit(1_000_000_000).forEach(i -> {
                try {
                    writer.write(i + "\n");
                } catch (IOException e) {
                   throw new IllegalStateException(); 
                }
            });
        }
    }

}

class OneBillionIntegerStatistics {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("numbers_1B.in")))) {
            System.out.print(reader.lines().mapToLong(Long::valueOf).summaryStatistics());
        }
    }

}
