package com.asela;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main5 {
	
	public static void main(String[] args) {
		
		first();
		second();
		
		List<String> birds = new ArrayList<String>();
		birds.add("Penguine");
		birds.add("Crow");
		
		for (String string : birds) {
			System.out.println(string);
		}
		
		Iterator<String> iterator = birds.iterator();
		while(iterator.hasNext()) {
			String next = iterator.next();
			System.out.println(next);
		}
		
		for(String string = iterator.next(); iterator.hasNext();) {
			System.out.println(string);
		}
		
		 
	}

	private static void second() {
		int i = 0, j = 0;
		while(i-- < j++);
		System.out.println("Wild World");
		
	}

	private static void first() {
		int i = 0, j = 0;
		while(i-- < j++) { }
		System.out.println("Wild World");
		
	}

}
