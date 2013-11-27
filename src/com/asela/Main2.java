package com.asela;

import java.util.Scanner;

public class Main2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner br = new Scanner(System.in);
		boolean result = false;
		String searchText = "a";
		
		result = method1(br, result, searchText);

	    result = method2(br, result, searchText);

	}

	private static boolean method2(Scanner br, boolean result, String searchText) {
		while (br.hasNextLine() && !result) {
		result = br.nextLine().indexOf(searchText) >= 0;
		}
		return result;
	}

	private static boolean method1(Scanner br, boolean result, String searchText) {
		while (br.hasNextLine() && !result) {
			String line = br.nextLine();
			result = line.indexOf(searchText) >= 0;
			}
		return result;
	}

}
