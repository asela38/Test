package com.asela.casting;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CastingTest1 {

    /** @param args
     */
    public static void main(String[] args) {

        @SuppressWarnings("unchecked")
        List<String> list = (List<String>) createObject(ArrayList.class);

        list.add("A");
        list.add("B");
        list.add("C");

        for (String string : list) {
            System.out.println(string);
        }

        @SuppressWarnings("unchecked")
        Queue<String> queue = (Queue<String>) list;

        System.out.println(queue.poll());

    }

    public static Object createObject(@SuppressWarnings("rawtypes") Class c) {
        try {
            return c.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
