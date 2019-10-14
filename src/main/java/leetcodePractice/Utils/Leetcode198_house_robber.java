package Utils;

public class Leetcode198_house_robber {
    public int rob(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }

        int ppPrev = 0;
        int pPrev = 0;
        int prev = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = Math.max(ppPrev + nums[i], pPrev + nums[i]);
            ppPrev = pPrev;
            pPrev = prev;
            prev = curr;
        }

        return Math.max(prev, pPrev);
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};

        System.out.println(new Leetcode198_house_robber().rob(nums));
    }
}
