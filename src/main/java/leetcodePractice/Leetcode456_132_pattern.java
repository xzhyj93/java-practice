package leetcodePractice;

import java.util.Stack;

/**
 * Created by 祁连山 on 2019/7/18.
 */
public class Leetcode456_132_pattern {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        int len = nums.length;

        int min[] = new int[len];
        min[0] = nums[0];

        for (int i = 1; i < len; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }

        Stack<Integer> stack = new Stack<>();

        for (int j = len - 1; j > 0; j--) {
            int num = nums[j];
            int peek;

            if (!stack.isEmpty()) {
                peek = stack.peek();

                while (peek <= min[j] && !stack.isEmpty()) {
                    stack.pop();
                    if (!stack.isEmpty()) {
                        peek = stack.peek();
                    } else {
                        break;
                    }
                }
            } else {
                if (num > min[j]) {
                    stack.push(num);
                }
                continue;
            }

            if (peek > min[j] && peek < num) {
                return true;
            }

            if (num < peek && num > min[j]) {
                stack.push(num);
            }
        }

        return false;
    }

    public boolean find132pattern_brute_force(int[] nums) {
        if (nums.length <= 2) {
            return false;
        }

        int num1 = nums[0];

        for (int i = 1; i < nums.length; i++) {
            num1 = Math.min(num1, nums[i]);
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > num1 && nums[j] < nums[i]) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean find132pattern_time_limit(int[] nums) {
        if (nums.length <= 2) {
            return false;
        }

        int num1, num2, num3;

        for (int i = 0; i < nums.length; i++) {
            num1 = nums[i];
            int j = i + 1;

            while (j < nums.length) {
                num2 = nums[j];

                if (num2 > num1) {
                    int k = j + 1;

                    while (k < nums.length) {
                        num3 = nums[k];
                        if (num3 > num1 && num3 < num2) {
                            return true;
                        } else {
                            k++;
                        }
                    }
                }

                j++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, -4, -3};

        Leetcode456_132_pattern ques = new Leetcode456_132_pattern();
        System.out.println(ques.find132pattern(nums));
    }
}
