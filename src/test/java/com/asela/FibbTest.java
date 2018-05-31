package com.asela;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class FibbTest {

    private void verifyTarget(int[] original, int target) {
        int[] result = findTargetIndex(original, target);
        assertThat(original[result[0]] + original[result[1]], is(target));
    }
    
    // array is always has an answer
    // { 1 . 2. 4. 5. 7} , 8 = 0,4
    
    @Test
    public void testOne() throws Exception {
       verifyTarget(new int[] {1,9}, 10);
      // verifyTarget(new int[] {1,8}, 10);
       verifyTarget(new int[] {1,8,9}, 10);
       verifyTarget(new int[] {1,9,8}, 10);
       verifyTarget(new int[] {9,8,1}, 10);
       verifyTarget(new int[] {8,9,1}, 10);
    }

    private int[] findTargetIndex(int[] in, int target) {
        if(in[0] + in[1] == target) {
            return new int[] {0,1};
        }
        if(in[1] + in[2] == target) {
            return new int[] {1,2};
        }
        
        return new int[] {0,2};
        
    }
}
