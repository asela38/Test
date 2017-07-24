package com.asela;

import java.util.Scanner;

public class SearchForExistText {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Scanner br = new Scanner(System.in);
        boolean result = false;
        String searchText = "a";

        result = seperateCalls(br, result, searchText);
        System.out.println(result);
        
        result = chainCalls(br, result, searchText);
        System.out.println(result);
    }

    private static boolean chainCalls(Scanner br, boolean result, String searchText) {
        while (br.hasNextLine() && !result) {
            result = br.nextLine().indexOf(searchText) >= 0;
        }
        return result;
    }

    private static boolean seperateCalls(Scanner br, boolean result, String searchText) {
        while (br.hasNextLine() && !result) {
            String line = br.nextLine();
            result = line.indexOf(searchText) >= 0;
        }
        return result;
    }

}
