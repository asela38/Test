package com.asela.util;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RegexTest {

    @Test
    public void removeExcessiveSpaces() {

        assertThat("      A        ".replaceAll("\\s+", " "), is(" A "));
        assertThat("      A    A        ".replaceAll("\\s+", " "), is(" A A "));
        assertThat(
                ( "      A                                               " +
                  "      B       D                                       " ).replaceAll("\\s+", " "), is(" A B D "));
    }
}
