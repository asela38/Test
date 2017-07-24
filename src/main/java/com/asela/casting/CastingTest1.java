package com.asela.casting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CastingTest1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		List<String> list = (List<String>)createObject(ArrayList.class);
		
		list.add("A");
		list.add("B");
		list.add("C");
		
		
		for (String string : list) {
			System.out.println(string);
		}
		
		Queue<String> queue = (Queue<String>) list;
		
		System.out.println(queue.poll());
		
		
	}
	
	
	public static Object createObject(Class c) {
		try {
			return c.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

}
