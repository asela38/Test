package com.asela.basic;

import org.junit.Test;

public class BitOperations {

    @Test
    public void testBits() throws Exception {
        test(12, 15);
    }

    private void test(int i, int j) {
        printBinary(i);
        printBinary(j);
        printBinary(i&j);
        printBinary(i|j);
        printBinary(i^j);
    }

    private void printBinary(int i) {
        System.out.println(String.format("%32s", Integer.toBinaryString(i)).replace(" ", "0"));
    }
    
    

}
