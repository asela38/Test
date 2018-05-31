package com.asela;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            int index = scanner.nextInt();
            int a = 1, b = 1;
            for(int i = 2; i < index; i++) {
                int t = b;
                b += a;
                a = t;
            }
            
            System.out.println(b);
        }
    }
}
