package com.asela.util;

import java.util.Arrays;
import java.util.Base64;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

public class Base64Test {

    @Test
    public void encode() throws Exception {
        String original = "test121";
        byte[] encode = Base64.getEncoder().encode(original.getBytes());
        String encodeToString = Base64.getEncoder().encodeToString(original.getBytes());
        System.out.printf("%n original : %s , encode : %s , encodeToString : %s", original, Arrays.toString(encode), encodeToString);
        
        System.out.printf("%nOriginal as Binary : %s", original.chars()
                                                              .mapToObj(Integer::toBinaryString)
                                                              .collect(Collectors.joining(", ","[","]")));
        System.out.printf("%nEncode as Binary : %s", IntStream.range(0, encode.length)
                                                                .mapToObj(i -> String.format("%8s", Integer.toBinaryString(encode[i] & 0xFF)).replace(' ', '0'))
                                                                .collect(Collectors.joining(", ","[","]")));
        byte[] decode = Base64.getDecoder().decode(encodeToString);
        System.out.printf("%n original : %s , decode : %s , encodeToString : %s", original, Arrays.toString(decode), new String(decode ,"UTF-8"));
        
    }
    
    
    @Test
    public void base64Test() throws Exception {
        
        String test = "abcde";
        print(test.getBytes());
        print(  Base64.getEncoder().encodeToString(test.getBytes()).getBytes());
      
    }
    
    @Test
    public void decodeFewTest() throws Exception {
        
        printd("TWFuIGlzIGRpc3Rpbmd1aXNoZWQsIG5vdCBvbmx5IGJ5IGhpcyByZWFzb24sIGJ1dCBieSB0aGlz" + 
                "IHNpbmd1bGFyIHBhc3Npb24gZnJvbSBvdGhlciBhbmltYWxzLCB3aGljaCBpcyBhIGx1c3Qgb2Yg" + 
                "dGhlIG1pbmQsIHRoYXQgYnkgYSBwZXJzZXZlcmFuY2Ugb2YgZGVsaWdodCBpbiB0aGUgY29udGlu" + 
                "dWVkIGFuZCBpbmRlZmF0aWdhYmxlIGdlbmVyYXRpb24gb2Yga25vd2xlZGdlLCBleGNlZWRzIHRo" + 
                "ZSBzaG9ydCB2ZWhlbWVuY2Ugb2YgYW55IGNhcm5hbCBwbGVhc3VyZS4=");
        
        printd("ckvi");
        
    }


    private void printd(String s) {
        System.out.println(new String(Base64.getDecoder().decode(s.getBytes())));
    }


    private void print(byte[] bytes) {
        System.out.println(
                IntStream.range(0, bytes.length)
                    .map(i ->  bytes[i])
                    .mapToObj(Integer::toBinaryString)
                    .collect(Collectors.joining(" "))
                
        );
    }
}
