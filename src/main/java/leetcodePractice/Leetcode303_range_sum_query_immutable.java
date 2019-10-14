public class Leetcode303_range_sum_query_immutable {
//    private int[] nums;
//    public Leetcode303_range_sum_query_immutable(int[] nums) {
//        this.nums = nums;
//    }
//
//    public int sumRange(int i, int j) {
//        int sum = 0;
//        for (int k = i; k <= j; k++) {
//            sum += nums[k];
//        }
//
//        return sum;
//    }

    private int[] sums;

    public Leetcode303_range_sum_query_immutable(int[] nums) {

        if (nums.length > 0) {
            // 计算累积和
            sums = new int[nums.length];
            sums[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sums[i] = sums[i - 1] + nums[i];
            }
        } else {
            sums = null;
        }

    }

    public int sumRange(int i, int j) {
        if (sums == null) {
            return 0;
        } else {
            return i > 0 ? sums[j] - sums[i - 1] : sums[j];
        }
    }

//    private int[] sum;
//
//    public Leetcode303_range_sum_query_immutable(int[] nums) {
//        sum = new int[nums.length + 1];
//        for (int i = 0; i < nums.length; i++) {
//            sum[i + 1] = sum[i] + nums[i];
//        }
//    }
//
//    public int sumRange(int i, int j) {
//        return sum[j + 1] - sum[i];
//    }
}
