package com.asela.lang;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MathTest {

    @Test
    public void boundedIntegers() throws Exception {
        verifyBoundedBy10and20(15, 15);
        verifyBoundedBy10and20(10, 10);
        verifyBoundedBy10and20(20, 20);
        verifyBoundedBy10and20(25, 20);
        verifyBoundedBy10and20(5, 10);
    }

    @Test
    public void test() {
        verifyBoundedBy20and10(15, 15);
        verifyBoundedBy20and10(10, 10);
        verifyBoundedBy20and10(20, 20);
        verifyBoundedBy20and10(25, 20);
        verifyBoundedBy20and10(5, 10);
    }

    public void verifyBoundedBy10and20(int value, int expected) {
        int MAX = 20, MIN = 10;
        assertThat(Math.min(Math.max(value, MIN), MAX), is(expected));
        ;
    }

    public void verifyBoundedBy20and10(int value, int expected) {
        int MAX = 20, MIN = 10;
        assertThat(Math.max(Math.min(value, MAX), MIN), is(expected));
        ;
    }
}
