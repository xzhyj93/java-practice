package leetcodePractice;

public class Leetcode3_longest_substring_without_repeating_charaters {
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int pre = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int num = 1;

            for (int j = 1; j <= pre; j++) {
                if (s.charAt(i - j) != ch) {
                    num++;
                } else {
                    break;
                }
            }

            pre = num;
            if (num > max) {
                max = num;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
