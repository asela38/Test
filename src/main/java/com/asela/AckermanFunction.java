package com.asela;

import java.util.function.BiFunction;

public class AckermanFunction {

    public static BiFunction<Integer, Integer, Integer> ackerman;
    static {
        ackerman = (m, n) -> {
            System.out.printf("(%5s,%5s)->", m, n );
            if(m == 0) return n+1;
            if(m > 0 && n == 0 ) return ackerman.apply(m-1, 1);
            return ackerman.apply(m-1, ackerman.apply(m, n-1));
        };
    }
    
    public static void main(String[] args) {
        System.out.println(ackerman.apply(0, 1));
        System.out.println(ackerman.apply(1, 1));
        System.out.println(ackerman.apply(2, 1));
    }
}
