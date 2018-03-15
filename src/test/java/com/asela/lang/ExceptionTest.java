package com.asela.lang;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ExceptionTest {

    @Test
    public void testNonAssignedFieldInMethod() throws Exception {
        List<Integer> list = getListOfIntegers();
        list.stream().forEach(System.out::println);
    }

    private List<Integer> getListOfIntegers() {
        try {
            return new ArrayList<>();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    
    @Test
    public void exceptionPropagation() throws Exception {
        try {
            caller1();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    private void caller1() {
        try {
            caller2();
        } catch (Exception e) {
           throw e; 
        }
    }

    private void caller2() {
        try {
            caller3();
        } catch (Exception e) {
           throw e; 
        }
    }

    private void caller3() {
       throw new RuntimeException(); 
    }
}
