package com.asela;

public class RemoveConditionals {

	public static void main(String[] args) {
		first(9);
		first(1341);
	}
	
	public static void first(int a) {
		String[] s = {"Even", "Odd"};
		System.out.println(a + " is " + s[a%2]);
	}
	
	public static void second(int b) {
		
	}
}
