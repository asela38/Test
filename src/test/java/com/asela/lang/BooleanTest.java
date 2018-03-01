package com.asela.lang;

import org.junit.Test;

public class BooleanTest {

    @Test
    public void testName() throws Exception {

        System.out.println("-- Is True --");
        System.out.println("Boolean.TRUE.equals(Boolean.TRUE) = " + Boolean.TRUE.equals(Boolean.TRUE));
        System.out.println("Boolean.TRUE.equals(Boolean.FALSE) = " + Boolean.TRUE.equals(Boolean.FALSE));
        System.out.println("Boolean.TRUE.equals(null) = " + Boolean.TRUE.equals(null));
        
        System.out.println("-- Is Not True --");
        System.out.println("!Boolean.TRUE.equals(Boolean.TRUE) = " + !Boolean.TRUE.equals(Boolean.TRUE));
        System.out.println("!Boolean.TRUE.equals(Boolean.FALSE) = " + !Boolean.TRUE.equals(Boolean.FALSE));
        System.out.println("!Boolean.TRUE.equals(null) = " + !Boolean.TRUE.equals(null));
        
        System.out.println("-- Is False -- ");
        System.out.println("Boolean.FALSE.equals(Boolean.TRUE) = " + Boolean.FALSE.equals(Boolean.TRUE));
        System.out.println("Boolean.FALSE.equals(Boolean.FALSE) = " + Boolean.FALSE.equals(Boolean.FALSE));
        System.out.println("Boolean.FALSE.equals(null) = " + Boolean.FALSE.equals(null));
        
        
        System.out.println("-- Is Not False -- ");
        System.out.println("!Boolean.FALSE.equals(Boolean.TRUE) = " + !Boolean.FALSE.equals(Boolean.TRUE));
        System.out.println("!Boolean.FALSE.equals(Boolean.FALSE) = " + !Boolean.FALSE.equals(Boolean.FALSE));
        System.out.println("!Boolean.FALSE.equals(null) = " + !Boolean.FALSE.equals(null));
    }
}
