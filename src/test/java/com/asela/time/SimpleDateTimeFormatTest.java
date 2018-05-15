package com.asela.time;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class SimpleDateTimeFormatTest {
    
    
    @Test
    public void testName() throws Exception {
        Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").parse("2018-04-19T13:17:31.413+08:00");
        System.out.println(date);
        
         date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").parse("2018-04-19T13:17:31+08:00");
        System.out.println(date);
         
        // @formatter:on
        
        

    }

}
