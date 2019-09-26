import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Leetcode560_subarray_sum_equals_k {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int count = 0;

        map.put(0, 1);

        for (int num : nums) {
            sum += num;

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public int subarraySum_with_exception(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        for (int num : nums) {
            Set<Integer> sums = map.keySet();
            for (int sum : sums) {
                map.put(num + sum, map.getOrDefault(num + sum, 0) + 1);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return map.getOrDefault(k, 0);

    }

    public int subarraySum_without_space(int[] nums, int k) {
        int count = 0;

        for (int start = 0; start < nums.length; start++) {
            int sum = nums[start];

            if (sum == k) {
                count++;
            }

            for (int end = start + 1; end < nums.length; end++) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    public int subarraySum_store_sum(int[] nums, int k) {
        int count = 0;
        int[] sums = new int[nums.length];
        if (nums.length < 1) {
            return 0;
        }

        sums[0] = nums[0];

        if (nums[0] == k) {
            count++;
        }

        for (int i = 1; i < nums.length; i++) {
            sums[i] = nums[i] + sums[i - 1];
            if (sums[i] == k) {
                count++;
            }

            int j = i - 1;
            while(j >= 0) {
                if (sums[i] - sums[j] == k) {
                    count++;
                }
                j--;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Leetcode560_subarray_sum_equals_k test = new Leetcode560_subarray_sum_equals_k();
        int[] nums = {1,2,3};
        int key = 3;
        System.out.println(test.subarraySum(nums, key));
    }
}
