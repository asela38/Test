package com.asela.time;

import java.time.LocalDate;

import org.junit.Test;

public class LocalDateTest {

    @Test
    public void localDate_test() throws Exception {

        LocalDate now = LocalDate.now();
        System.out.println("Now : " + now);
        LocalDate endOfTheMonth = now.withDayOfMonth(now.lengthOfMonth()).minusDays(2);
        System.out.println("End of the month : " + endOfTheMonth);

        LocalDate minusDays = endOfTheMonth.minusDays(2);
        System.out.println("Two days before end of month " + minusDays);
    }


}
