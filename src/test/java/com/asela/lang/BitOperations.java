package com.asela.lang;

import org.junit.Test;

public class BitOperations {

	@Test
	public void test() throws Exception {
		printAsBinary(1);
		printAsBinary(1 << 1);
		printAsBinary(1 << 31);
		printAsBinary(1 << 32);

		divideBy2RoundUp(11);
		divideBy2RoundUp(105);
		System.out.println(Math.round(105 / 2f));
	}

	private void divideBy2RoundUp(int i) {
		int j = i >> 1;
		j = j - (j << 1) + i;
		System.out.println(j);
		printAsBinary(j);
	}

	private void printAsBinary(int i) {
		System.out.println(Integer.toBinaryString(i));
	}
}
