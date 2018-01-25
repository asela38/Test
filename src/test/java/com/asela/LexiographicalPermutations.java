package com.asela;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class LexiographicalPermutations {

    
    private static final String ABCDEFGHIJKLM = "abcdefghijklm";

    @Test
    public void testName() throws Exception {
       assertThat(permutationOf(1), is(ABCDEFGHIJKLM)); 
    }

    private Object permutationOf(int i) {
        return ABCDEFGHIJKLM;
    }
}
