package nodone;

import java.util.Arrays;

public class Leetcode279_perfect_squares {
    public int numSquares(int n) {
        int[] nums = new int[n + 1];
        Arrays.fill(nums, Integer.MAX_VALUE);

        for (int i = 1; i < nums.length; i++) {
            int sqr = (int)Math.sqrt(i);
            if (sqr * sqr == i) {
                nums[i] = 1;
            } else {
                for (int j = 1; i - j >= j; j++) {
                    nums[i] = Math.min(nums[i], nums[j] + nums[i - j]);
                }
            }
        }

        return nums[n];
    }

    public static void main(String[] args) {
        Leetcode279_perfect_squares test = new Leetcode279_perfect_squares();
        System.out.println(test.numSquares(11));
    }
}
