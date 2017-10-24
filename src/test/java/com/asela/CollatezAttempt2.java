package com.asela;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.junit.Test;

public class CollatezAttempt2 {

    @Test
    public void findNextCollatez() throws Exception {
        assertThat(nextCollatez(1), is(1));
        assertThat(nextCollatez(2), is(1));
        assertThat(nextCollatez(3), is(10));
        assertThat(nextCollatez(32), is(16));
        assertThat(nextCollatez(32), is(16));
    }

    private long nextCollatez(long i) {
        if (i == 1)
            return 1;
        return i % 2 == 0 ? i >> 1 : 3 * i + 1;
    }

    @Test
    public void collatezLengthTest() throws Exception {
        assertThat(collatzLength(1), is(0));
        assertThat(collatzLength(2), is(1));
        assertThat(collatzLength(4), is(2));
        assertThat(collatzLength(3), is(7));
        assertThat(collatzLength(9), is(19));
        assertThat(collatzLength(113382), is(66));
        assertThat(collatzLength(113383), is(247));
        // System.out.prlongln(Arrays.toString(cache));
    }

    private void test() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        in.lines().map(Integer::valueOf).mapToInt(Integer::intValue).map(this::maxCollatezLengthBelow)
                .forEach(System.out::println);

    }

    private int[] cache = new int[5_000_000];

    private int collatzLength(int n) {

        if (n < cache.length && cache[n - 1] != 0) {
            return cache[n - 1];
        }
        int j = 0;
        for (long i = n; i != 1; i = i % 2 == 0 ? i >> 1 : 3 * i + 1) {
            ++j;
         //   System.out.println(i + "  =  "  + j);
        }
        return n < cache.length ? cache[n - 1] = j : j;

    }

    @Test
    public void maxCollatezLengthBelowTest() throws Exception {
        assertThat(maxCollatezLengthBelow(10), is(9));
        assertThat(maxCollatezLengthBelow(15), is(9));
        assertThat(maxCollatezLengthBelow(20), is(19));
    }

    private int maxCollatezLengthBelow(int i) {
        int  maxAt = 1;
        long max = 0;
        for (int j = i; j > 0; j--) {
            long c = collatzLength(j);
            if (max < c) {
                max = c;
                maxAt = j;
            }
        }
        return maxAt;
    }

    @Test
    public void maxCollatezLengthBelow_Pre_Test() throws Exception {
        maxCollatezLengthBelowPreCalUpto(5000_000);
        assertThat(maxCollatezLengthBelow_pre(10), is(9));
        assertThat(maxCollatezLengthBelow_pre(15), is(9));
        assertThat(maxCollatezLengthBelow_pre(20), is(19));
        // System.out.prlongln(Arrays.toString(cache2));
    }

    private Object maxCollatezLengthBelow_pre(int i) {
        return cache2[i - 1];
    }

    private int[] cache2 = new int[5_000_000];

    private int maxCollatezLengthBelowPreCalUpto(long i) {
        long max = 0;
        int maxAt = 1;
        for (int j = 1; j <= i; j++) {
            int c = collatzLength(j);
            if (max <= c) {
                max = c;
                maxAt = j;
            }
            cache2[j - 1] = maxAt;
       //     System.out.println(j);
        }
        return maxAt;
    }

//    @Test
//    public void maxCollatezLengthBelow_R_Test() throws Exception {
//        assertThat(maxCollatezLengthBelow_R(10)[0], is(9));
//        assertThat(maxCollatezLengthBelow_R(15)[0], is(9));
//        assertThat(maxCollatezLengthBelow_R(20)[0], is(19));
//    }

//    private int[] maxCollatezLengthBelow_R(long i) {
//        if (i == 1)
//            return new int[] { 1, 0 };
//        int[] max = new int[] { i, collatzLength(i) };
//        int[] pMax = maxCollatezLengthBelow_R(--i);
//        if (max[1] < pMax[1]) {
//            max[0] = pMax[0];
//            max[1] = pMax[1];
//        }
//
//        return max;
//    }

}
