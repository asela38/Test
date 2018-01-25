package com.asela.sort;

import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.lang3.RandomStringUtils;

public class FineGrainSorting {

    private static Consumer<String> print = string -> System.out.println(string); 
    
    public static void main(String[] args) {
        
        IntStream.iterate(1, i -> i + 1)
                    .limit(100000)
                    .mapToObj(i -> FineGrainSorting.randomBook())
                    .peek(book -> print.accept("created : " + book))
                    .collect(Collectors.toList())
                    .stream()
                    .sorted(Comparator.comparingInt(Book::getYear).thenComparing(Book::getName))
                    .peek(book -> print.accept("sorted : " + book))
                    .collect(Collectors.toList())
                    ;
                
    }

    public static Book randomBook() {
        return Book.builder().author(RandomStringUtils.randomAlphabetic(10)).name(RandomStringUtils.randomAlphabetic(2))
                .publisher(RandomStringUtils.randomAlphabetic(6)).year(ThreadLocalRandom.current().nextInt(1900, 2000))
                .build();
    }
}
