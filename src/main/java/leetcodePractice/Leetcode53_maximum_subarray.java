public class Leetcode53_maximum_subarray {
    public static int maxSubArray(int[] nums) {
        int max = 0;
        int pre = 0;

        if (nums.length > 0) {
            max = pre = nums[0];
        }

        for (int i = 1; i < nums.length; i++) {
            if (pre < 0) {
                pre = nums[i];
            } else {
                pre += nums[i];
            }

            if (pre > max) {
                max = pre;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
