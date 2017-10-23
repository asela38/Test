package com.asela;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PrimeFactors {

    @Test
    public void primeFactors() throws Exception {
        assertPrimeFactorsOf(1);
        assertPrimeFactorsOf(2, 2);
        assertPrimeFactorsOf(3, 3);
        assertPrimeFactorsOf(4, 2, 2);
        assertPrimeFactorsOf(5, 5);
        assertPrimeFactorsOf(6, 2, 3);
        assertPrimeFactorsOf(7, 7);
        assertPrimeFactorsOf(8, 2, 2, 2);
        assertPrimeFactorsOf(9, 3, 3);
        assertPrimeFactorsOf(10, 2, 5);
        assertPrimeFactorsOf(2*2*3*3*5*7*7, 2,2,3,3,5,7,7);

    }

    private void assertPrimeFactorsOf(int number, int... factors) {
        List<Integer> primeFactorsOf = primeFactorsOf(number);
        Integer[] array = primeFactorsOf.toArray(new Integer[0]);
        assertThat("Factors  of " + number + " are " + primeFactorsOf, array, is(factors));
    }

    private List<Integer> primeFactorsOf(int n) {
        ArrayList<Integer> factors = new ArrayList<>();

        for (int div = 2; div <= n; div++)
            for ( ;n % div == 0; n /= div) 
                factors.add(div);


        return factors;
    }

}
