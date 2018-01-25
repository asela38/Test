package com.asela;

import java.time.LocalDate;

import org.junit.Test;

public class CountSundays {

    @Test
    public void countSundays_test() throws Exception {
       
        System.out.println(LocalDate.of(2017, 01, 10).withDayOfMonth(1));
    }
}
