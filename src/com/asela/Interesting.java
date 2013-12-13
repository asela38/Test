package com.asela;

public class Interesting {
	
	public static void main(String[] args) {
		
		int i = 0;
		
		while( i < 3) {
			i += i++;
			System.out.println(i);			
		}		
	}
}
