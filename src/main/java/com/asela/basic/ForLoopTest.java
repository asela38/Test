package com.asela.basic;

import static org.junit.Assert.*;

import org.junit.Test;

public class ForLoopTest {

	@Test
	public void test1() {
		for(int i = 0; forCondition(i) ; System.out.println("Opp: " + i++)) {
			System.out.println("  " + i);
		}
	}
	
	private boolean forCondition(int i) {
		System.out.printf(" Con: %d<10: %b \n", i, (i < 10));
		return i < 10;
	}

}
