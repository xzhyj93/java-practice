public class Leetcode213_house_robber_2 {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(rob1(nums, 0, nums.length - 2), rob1(nums, 1, nums.length - 1));
    }

    public int rob1(int[] nums, int left, int right) {
        int ppPrev = 0;
        int pPrev = 0;
        int prev = nums[left];

        for (int i = left + 1; i <= right; i++) {
            int curr = Math.max(ppPrev + nums[i], pPrev + nums[i]);
            ppPrev = pPrev;
            pPrev = prev;
            prev = curr;
        }

        return Math.max(prev, pPrev);
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 2};
        System.out.println(new Leetcode213_house_robber_2().rob(nums));
    }
}
