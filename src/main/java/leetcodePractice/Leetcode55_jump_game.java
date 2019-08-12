public class Leetcode55_jump_game {
    public boolean canJump(int[] nums) {
        int currentMaxIndex = 0;

        for (int i = 0; i < nums.length && i <= currentMaxIndex; i++) {
            currentMaxIndex = Math.max(currentMaxIndex, i + nums[i]);
        }

        return currentMaxIndex >= nums.length - 1;
    }

    public boolean canJump_2(int[] nums) {
        boolean[] jumpArr = new boolean[nums.length];

        jumpArr[nums.length - 1] = true;

        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = 1; j <= nums[i]; j++) {
                if (jumpArr[i + j]) {
                    jumpArr[i] = true;
                    break;
                }
            }
        }

        return jumpArr[0];
    }

    public static void main(String[] args) {
        Leetcode55_jump_game test = new Leetcode55_jump_game();
        int[] nums = {0};

        System.out.println(test.canJump(nums));
    }
}
