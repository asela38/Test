package com.asela.annotation;

public class Main {

	public static void main(String[] args) {
		
		Person person = new Person("Asela", 28);
		
	//	Main main = new Main();
	//	main.test(person);
	//	main.test(new Person(null,0));
		
		System.out.println(DefaultUtil.defaultNulls(Person.class, new Person(null, 12)));
		System.out.println(DefaultUtil.defaultNulls(Address.class, new Address(null, "a", null)));
		
	}
	
	
	public void test(Person person) {
		
		System.out.println(person);
		
		DefaultUtil.defaultNulls(Person.class, person);
		
		System.out.println(person);
		if(person.getName().startsWith("a")) {
			System.out.println(person);
		}
		
		System.out.println(person);
	}
	
	
}
