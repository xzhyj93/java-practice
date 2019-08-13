public class Leetcode152_maximum_product_subarray {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int max = nums[0];
        int currMax = nums[0];
        int currMin = nums[0];

       for (int i = 1; i < nums.length; i++) {
           int tmpCurrMax = currMax;
           currMax = Math.max(currMax * nums[i], Math.max(currMin * nums[i], nums[i]));
           currMin = Math.min(currMin * nums[i], Math.min(tmpCurrMax * nums[i], nums[i]));
           max = Math.max(currMax, max);
       }
       return max;
    }

    public int maxProduct_no_matrix(int[] nums) {
        int pre = 1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            pre = nums[i];
            max = Math.max(max, pre);

            if (nums[i] == 0) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == 0) {
                    break;
                }
                pre = pre * nums[j];

                if (pre > max) {
                    max = pre;
                }
            }
        }

        return max;
    }

    public int maxProduct_Memory_Limit_Exceeded(int[] nums) {
        int[][] matrix = new int[nums.length][nums.length];

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            matrix[i][i] = nums[i];
            max = Math.max(max, matrix[i][i]);

            if (nums[i] == 0) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == 0) {
                    break;
                }
                matrix[i][j] = matrix[i][j - 1] * nums[j];

                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Leetcode152_maximum_product_subarray test = new Leetcode152_maximum_product_subarray();
        int[] nums = {-4, -3, 2, 2, -5, 0, 2, 1};

        System.out.println(test.maxProduct(nums));
    }
}
