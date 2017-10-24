package com.asela;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class WrapperTest {

    private void assertWrapped(String text, int length, String expected) {
        String wrappedText = wrap(text, length);
        assertThat(wrappedText, is(expected));
    }

    @Test
    public void wrapperTest() throws Exception {
        assertWrapped("Hello, World!", 20, "Hello, World!");
        assertWrapped("xx", 1, "x\nx");
        assertWrapped("xxx", 1, "x\nx\nx");
        assertWrapped("ab cd", 2, "ab\ncd");
    }

    private String wrap(String text, int i) {
        if (text.length() <= i)
            return text;
        else
            return text.substring(0, i).trim() + "\n" + wrap(text.substring(i).trim(), i);
    }
}
