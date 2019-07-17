package leetcodePractice;

import java.util.Arrays;

public class Leetcode5_longest_palindromic_substring {
    public static String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

       int max = 3;

       StringBuilder sb = new StringBuilder(s);

        for(int i = s.length(); i >= 0; i--) {
            sb.insert(i, '#');
        }
       String result = sb.substring(0, 3);


        for (int i = 2; i < sb.length(); i++) {
            int num = 1;
            int left = i - (max - 1) / 2 - 1;
            int right = i + (max - 1) / 2 + 1;

            if (left < 0 || right >= sb.length()) {
                continue;
            } else {
                left = i - 1;
                right = i + 1;
                while(left >= 0 && right < sb.length() && sb.charAt(left) == sb.charAt(right)) {
                    num += 2;
                    left--;
                    right++;
                }
                if (num > max) {
                    max = num;
                    result = sb.substring(left + 1, right);
                }
            }
        }

        return result.replace("#", "");
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("bb"));
    }
}
