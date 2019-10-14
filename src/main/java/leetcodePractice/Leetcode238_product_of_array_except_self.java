import java.lang.reflect.Array;

public class Leetcode238_product_of_array_except_self {
    public int[] productExceptSelf_with_2_array(int[] nums) {
        int len = nums.length;
        int[] sums = new int[len];
        int[] leftSum = new int[len];
        int[] rightSum = new int[len];

        for (int i = 0; i < len; i++) {
            if (i == 0) {
                leftSum[i] = 1;
                rightSum[len - 1] = 1;
            } else {
                leftSum[i] = leftSum[i - 1] * nums[i - 1];
                rightSum[len - 1 - i] = rightSum[len - i] * nums[len - i];
            }
        }

        for (int i = 0; i < len; i++) {
            sums[i] = leftSum[i] * rightSum[i];
        }

        return sums;
    }

    public int[] productExceptSelf(int[] nums) {
        int[] sums = new int[nums.length];

        sums[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            sums[i] = nums[i - 1] * sums[i - 1];
        }

        int right = 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            right *= nums[i + 1];
            sums[i] *= right;
        }

        return sums;
    }

    public static void main(String[] args) {
        Leetcode238_product_of_array_except_self test = new Leetcode238_product_of_array_except_self();
        int[] nums = {1,2,3,4};

        for(int i : test.productExceptSelf(nums)) {
            System.out.println(i);
        }
    }
}
