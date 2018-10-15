package com.asela.casting;

public class CastingExample1 {

    /** @param args
     */
    public static void main(String[] args) {
        Object a = new StringBuilder("abcd");
        CharSequence a1 = (CharSequence) a;
        StringBuilder a2 = (StringBuilder) a1;

        System.out.println(a1.charAt(1));
        System.out.println(a2.indexOf("b"));
    }
}
