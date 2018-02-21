    package com.asela.date;

    import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

    public class LocalDateTest {
        
        
        @Test
        public void compare_local_dates() throws Exception {
            
            DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date1 = LocalDate.parse("2009-12-31", pattern);
            LocalDate date2 = LocalDate.parse("2010-01-31", pattern);
            
            System.out.println(pattern.format(date1));
            System.out.println(pattern.format(date2));
            
            
            if(date1.isAfter(date2)){
                System.out.println("Date1 is after Date2");
            }else if(date1.isBefore(date2)){
                System.out.println("Date1 is before Date2");
            }else if(date1. isEqual(date2)){
                System.out.println("Date1 is equal to Date2");
            }else{
                System.out.println("How to get here?");
            }

            
        }

    }
