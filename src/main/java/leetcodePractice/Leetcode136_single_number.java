import java.util.HashMap;
import java.util.HashSet;

public class Leetcode136_single_number {
    public static int singleNumber1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }

        return set.iterator().next();
    }

    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,2,1,2};
        System.out.println(singleNumber(nums));
    }
}
