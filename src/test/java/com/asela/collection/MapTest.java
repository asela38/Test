package com.asela.collection;

import static java.util.concurrent.ThreadLocalRandom.current;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;

public class MapTest {

    private enum BloodGroup {
        A, B, AB, O;
    }
    
    private enum RH {
        POSITIVE, NEGATIVE;
    }
    
    private static class Sample {
        private Integer id;
        private BloodGroup group;
        private RH rh;
        
        public Sample(Integer id, BloodGroup group, RH rh) {
            super();
            this.id = id;
            this.group = group;
            this.rh = rh;
        }

        public Integer getId() {
            return id;
        }

        public BloodGroup getGroup() {
            return group;
        }

        public RH getRh() {
            return rh;
        }
    
        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
        }
        
        
    }
    
    
    @Test
    public void wowByGroupBy() throws Exception {
        
        List<Sample> samples = IntStream.range(100, 120)
                                        .mapToObj(i -> new Sample(current().nextInt(1), 
                                                BloodGroup.values()[current().nextInt(0,4)],
                                                RH.values()[current().nextInt(0,2)]))
                                        .collect(Collectors.toList());
        
        
        Map<BloodGroup, List<Sample>> collect2 = samples.stream().collect(Collectors.groupingBy(Sample::getGroup));
        
        Map<RH, Map<BloodGroup, Sample>> collect = samples.stream().collect(Collectors.groupingBy(Sample::getRh, Collectors.toMap(Sample::getGroup, Function.identity(), (a,b) -> b)));
        
        Map<Integer, List<Sample>> collect3 = samples.stream().collect(Collectors.groupingBy(Sample::getId));
        
        System.out.println(collect);
    }
}
