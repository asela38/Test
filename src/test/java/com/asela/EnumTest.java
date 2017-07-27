package com.asela;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EnumTest {
    
    enum Shape {
        CIRCLE, TRIANGLE, SQUARE;
    }

    @Test
    public void test() {
        Shape shape = Shape.TRIANGLE;
        assertFalse(shape == Shape.CIRCLE);
        assertTrue(shape == Shape.TRIANGLE);
    }

}
