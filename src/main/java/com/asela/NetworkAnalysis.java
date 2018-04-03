package com.asela;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NetworkAnalysis {

    public static void main(String[] args) {
        
       
        Stream.of("255.255.254.0", "10.13.51.254", "10.13.60.52", "10.13.60.31", "10.13.60.32").forEach(s ->
            System.out.printf("%n %-16s = %s", s, 
                            Arrays.stream(
                                    s.split("\\.")
                            ).map(Integer::valueOf)
                            .map(Integer::toBinaryString)
                            .map(b -> String.format("%8s", b).replace(" ", "0"))
                            .collect(Collectors.joining("."))
                            
            )
        );
    }
}
