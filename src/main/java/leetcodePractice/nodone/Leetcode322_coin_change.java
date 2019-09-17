package nodone;

import java.util.Arrays;

public class Leetcode322_coin_change {
    public int coinChange(int[] coins, int amount) {
        return coinChange(coins, amount, new int[amount]);
    }

    public int coinChange(int[] coins, int rem, int[] counts) {
        if (rem < 0) {
            return -1;
        }

        if (rem == 0) {
            return 0;
        }

        if (counts[rem - 1] != 0) {
            return counts[rem - 1];
        }

        int min = Integer.MIN_VALUE;
        for (int coin : coins) {

        }

        return 0;
    }

    public int coinChange_time_limit(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int[] nums = new int[amount + 1];

        Arrays.fill(nums, -1);
        for (int i = 0; i < coins.length; i++) {
            if(coins[i] <= amount){
                nums[coins[i]] = 1;
            }
        }

        for (int i = 1; i <= amount; i++) {
            if (nums[i] == 1) {
                continue;
            } else {
                for (int j = 1; j <= i - j; j++) {
                    if (nums[j] > 0 && nums[i - j] > 0) {
                        nums[i] = Math.min(nums[i] > 0 ? nums[i] : Integer.MAX_VALUE,nums[j] + nums[i - j]);
                    }
                }
            }
        }

        return nums[amount];
    }

    public static void main(String[] args) {
        Leetcode322_coin_change test = new Leetcode322_coin_change();

        int[] coins = {474,83,404,3};
        System.out.println(test.coinChange(coins, 264));
    }
}
