package com.asela;

import java.util.ArrayList;
import java.util.List;

public class Main3 {

	
	public static void main(String[] args) {
		Object object = new Object() {
			
			public void sayHello() {
				System.out.println("Hello");				
			}
		};
	
		
		List<String> list = new ArrayList<>();
		ArrayList<Object> arrayList = new ArrayList<>();
		
		ArrayList<String> list2 = (ArrayList<String>) list;
		

		
	}
}
