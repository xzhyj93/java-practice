import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class No1_two_sum {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int i;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (map.containsKey(diff)) {

                result[0] = map.get(diff);
                result[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
