package com.asela;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * my project to build a calculator
 *
 */

public class Calculator {

    public static void main(String[] args) {

        List<String> numbers = new ArrayList<String>();
        System.out.println("enter the numbers you want to add press enter after every number:");
        
        try (Scanner input = new Scanner(System.in)) {
            
            while (input.hasNextLine()) {
                String s = input.nextLine();

                if (s.equals(""))
                    break;

                System.out.println("\nadding element in arraylist");
                numbers.add(s);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        int sum = numbers.stream().mapToInt(Integer::parseInt).sum();
        System.out.println("Sum of numbers : " + sum);

    }

}