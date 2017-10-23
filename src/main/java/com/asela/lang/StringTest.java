package com.asela.lang;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StringTest {

    @Test
    public void split_shouldReturnArrayAlways() {
        
        // if split regex doesn't match anything in the content it will return
        // single item array
        assertArrayEquals( new String[] {"aaa"}, "aaa".split(","));
        assertArrayEquals( new String[] {""}, "".split(","));
        assertArrayEquals( new String[] {" "}, " ".split(","));
        
        assertArrayEquals( new String[] {"aaa", "bbb"}, "aaa,bbb".split(","));
        assertArrayEquals( new String[] {" ", " "}, " , ".split(","));
        
        // Split will ignore empty content between Split regex
        assertArrayEquals( new String[] {}, ",".split(",") );
        assertArrayEquals( new String[] {"aaa","bbb"}, "aaa,bbb,,".split(",") );
        
        assertTrue("".split(",").length == 1);
        assertTrue(",".split(",").length == 0);
        assertTrue(",,".split(",").length == 0);
        
    }
    
    @Test
    public void regexLengthCheck() throws Exception {
       assertTrue("123456789012".matches("[0-9]{10,}"));
       assertFalse("123456789".matches("[0-9]{10,}"));
    }
}
