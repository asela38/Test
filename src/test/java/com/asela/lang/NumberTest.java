package com.asela.lang;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

public class NumberTest {

    @Test
    public void testName() throws Exception {

        Object x = 10L;
        Object y = 10;

        int i = ((Number) x).intValue() + ((Number) y).intValue();
        System.out.println(i);
    }

    @Test
    public void squareRootWithInteger() throws Exception {
        int x = 5, y = 1, limit = 5;
        System.out.println(Math.sqrt(x));
        double a = 0;
        int[] _10 = new int[] { 1, 10, 100, 1000, 10_000, 100_000, 1_000_000, 10_000_000, 100_000_000, 1_000_000_000 };
        for (int i = 1; i < limit; i++) {
            x *= 100;
            y *= 10;
            while (y * y < x) {
                y++;
            }
            y--;
            a = ((double) y) / _10[i];
        }

        System.out.println(a);

    }

    @Test
    public void squareRootWithDouble() throws Exception {
        double x = 5, y = 0;
        for (double i = 1 ; i > 0.000000000000000001D; i /= 10) {
            while (y * y < x) {
                y += i;
            }
            y -= i;
        }
        System.out.println(y);
        System.out.println(Math.sqrt(x));
    }
    
    @Test
    public void squareRootWithBigDecimal() throws Exception {
        BigDecimal x = new BigDecimal(5), y = BigDecimal.ZERO;
        int scale = 300;
        for (BigDecimal i = BigDecimal.ONE ; i.compareTo(BigDecimal.ONE.divide(BigDecimal.TEN.pow(scale))) > 0; i = i.divide(BigDecimal.TEN)) {
            while (y.pow(2).compareTo(x) < 0) {
                y = y.add(i);
            }
            y = y.subtract(i);
        }
        System.out.println(y);
        System.out.println(squareRootOther(x,scale));
    }
    
    private static BigDecimal TWO = new BigDecimal(2);
    public static BigDecimal squareRootOther(BigDecimal A, final int SCALE) {
        BigDecimal x0 = new BigDecimal("0");
        BigDecimal x1 = new BigDecimal(Math.sqrt(A.doubleValue()));
        while (!x0.equals(x1)) {
            x0 = x1;
            x1 = A.divide(x0, SCALE, RoundingMode.HALF_UP);
            x1 = x1.add(x0);
            x1 = x1.divide(TWO, SCALE, RoundingMode.HALF_UP);

        }
        return x1;
    }

    @Test
    public void floatToBigDecimal() throws Exception {
        System.out.println(new BigDecimal(1.5f));
        System.out.println(new BigDecimal("1.5"));
        
    }
    
    
    @Test
    public void or() throws Exception {
        System.out.println(100 | 222);
    }
}
