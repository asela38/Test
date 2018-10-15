package com.asela;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

public class StreamExplore {

    @Test
    public void testListOfString() throws Exception {

        List<Long> asList = Arrays.asList(10L, 5L, 6L);

        System.out.println(asList.stream().map(id -> " id: " + id).collect(Collectors.joining(" OR ")));
    }

    @Test
    public void testIfRefactor() throws Exception {
        assertThat(query(null, null), is(query2(null, null)));
        assertThat(query(10L, null), is(query2(10L, null)));
        assertThat(query(null, 10L), is(query2(null, 10L)));
        assertThat(query(10L, 10L), is(query2(10L, 10L)));
    }

    private String query(Long priceFrom, Long priceTo) {
        StringBuilder query = new StringBuilder();
        Long RANGE_MAX_VALUE = 9999L;
        if (null != priceFrom)
            query.append(" AND item_price:[" + priceFrom + ";");

        if (null != priceTo) {
            if (null == priceFrom) {
                query.append(" AND item_price:[0;");
            }
            query.append(priceTo + "]");
        } else {
            if (null != priceFrom) {
                query.append(RANGE_MAX_VALUE + "]");
            }
        }

        return query.toString();
    }

    private String query2(Long priceFrom, Long priceTo) {
        StringBuilder query = new StringBuilder();
        Long RANGE_MAX_VALUE = 9999L;
        String itemPriceFormat = " AND item_price:[%s;%s]";
        if (priceFrom != null || priceTo != null) {
            query.append(String.format(itemPriceFormat, Optional.ofNullable(priceFrom).orElse(0L),
                    Optional.ofNullable(priceTo).orElse(RANGE_MAX_VALUE)));
        }

        return query.toString();
    }

    @Test
    public void printAlphabet() throws Exception {
        IntStream.iterate(0, i -> i + 1).limit(26).mapToObj(i ->  String.valueOf((char) ('a' + i)))
                .forEach(System.out::println);
    }

}
