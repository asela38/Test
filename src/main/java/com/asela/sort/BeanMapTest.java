package com.asela.sort;

import org.apache.commons.beanutils.BeanMap;

public class BeanMapTest {
    
    public static void main(String[] args) {
        Book randomBook = FineGrainSorting.randomBook();
        BeanMap beanMap = new BeanMap(randomBook);
        beanMap.forEach((k,v) -> System.out.println(k + ":" + v));
    }

}
