package com.asela;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Collatez {

    private void assertCollatzLength(int number, int length) {
        assertThat(collatezLength(number), is(length));
    }

    @Test
    public void collatez() throws Exception {
        assertCollatzLength(1, 0);
        assertCollatzLength(2, 1);
        assertCollatzLength(9, 19);

    }

    @Test
    public void maxCollatezLengthBelowTest() {
//        assertThat(maxCollatezLengthBelow(10), is(9));
  //      assertThat(maxCollatezLengthBelow(15), is(9));
        assertThat(maxCollatezLengthBelow(20), is(20));
        cache.forEach((k, v) -> {
            System.out.println(k + " = " + Arrays.toString(v));
        });
    }

    private Map<Integer, Integer[]> cache = new HashMap<>();

    private Integer maxCollatezLengthBelow(Integer bound) {
        int max = 1, maxAt = 1;
        for (int j = bound; j > 1; j--) {
            int length = 0;
            Integer[] maxPair = cache.get(j);
            if (maxPair == null) {
                for (int i = j; i != 1; i = i % 2 == 0 ? i / 2 : 3 * i + 1)
                    length++;
                if (length > max) {
                    max = length;
                    maxAt = j;
                }
                cache.put(j, new Integer[] { maxAt, max });
            } else
                break;
        }

        return cache.get(bound)[0];
    }

    private Integer collatezLength(Integer i) {
        int length = 0;
        for (; i != 1; i = i % 2 == 0 ? i / 2 : 3 * i + 1)
            length++;
        return length;
    }

}
