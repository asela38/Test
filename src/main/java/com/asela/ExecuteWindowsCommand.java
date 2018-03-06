package com.asela;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class ExecuteWindowsCommand {

    public static void main(String[] args) throws Exception {
        Process exec = Runtime.getRuntime().exec("tasklist ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
        List<String> lines = reader.lines().collect(Collectors.toList());
      
        analysAsHexInSysOut(lines);

    }

    private static void analysAsHexInSysOut(List<String> lines) {
        lines.stream()
            .peek(line -> System.out.println(
                        line.chars()
                            .mapToObj(c -> Character.toString((char)c))
                            .collect(Collectors.joining(" ", " ", ""))
                    ))
            .map(line -> 
                line.chars()
                    .mapToObj(Integer::toHexString)
                    .collect(Collectors.joining(" "))
             )
            .forEach(System.out::println);
    }
}
