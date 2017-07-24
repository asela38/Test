package com.asela;

public class OddEven {

	public static void main(String[] args) {
		System.out.printf("%d is %s \n",10,first(10));
		System.out.printf("%d is %s \n",101,first(101));
		System.out.printf("%d is %s \n",120,first(120));
		System.out.printf("%d is %s \n",4,first(4));
		System.out.printf("%d is %s \n",5,first(5));
		System.out.printf("%d is %s \n",1235,first(1235));

	}
	
	private static String first0(int a) {
		if(a%2 == 0) {
			return "Even";
		} 
		
		return "Odd";
	}
	
	
	private static String first(int a) {
		String[] s = {"Even", "Odd"};		
		return s[a%2];
	}
}
