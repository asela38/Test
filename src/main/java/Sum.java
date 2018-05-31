import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Sum {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(twoSum(new int[] { 2, 7, 11, 15, 8, 1 }, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        int[] sorted = Arrays.copyOf(nums, length);
        Arrays.sort(sorted);
      //  System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(sorted));
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sorted.length; i++) {
            Integer value = map.get(sorted[i]);
            if (value != null) {
                System.out.println(value + " " + sorted[value]);
                System.out.println(i + " " + sorted[i]);
                int[] result = new int[] { -1, -1 };
                for (int k = 0; result[0] == -1 || result[1] == -1; k++) {
                    if (nums[k] == sorted[value] || nums[k] == sorted[i]) {
                        if (result[0] == -1) {
                            result[0] = k;
                        } else {
                            result[1] = k;
                        }
                    }
                }
                return result;
            }
            map.put(target - sorted[i], i);
            System.out.println(map);
        }

        return null;
    }
}
