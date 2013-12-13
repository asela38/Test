package com.asela;

public class SwitchNumbers {

	public static void main(String[] args) {
		int i = 1112;
		int j = 13;
		

		System.out.printf("before swap : i=%d, j= %d\n", i, j);
		
		/*
		int temp = i;
		i = j;
		j = temp; */
		
		i ^= j;
		j ^= i;
		i ^= j;
		
		
		System.out.printf("after swap : i=%d, j= %d\n", i, j);
	}
}
