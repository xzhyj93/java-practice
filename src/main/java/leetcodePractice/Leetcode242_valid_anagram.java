package leetcodePractice;

import java.util.HashMap;

/**
 * Created by 祁连山 on 2019/7/16.
 */
public class Leetcode242_valid_anagram {
    public static boolean isAnagram2(String s, String t) {
        int sum = 0;

        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            sum += Math.pow((int)(s.charAt(i)), 3);
        }

        for (int j = 0; j < t.length(); j++) {
            sum -= Math.pow((int)(t.charAt(j)), 3);
        }

        if (sum == 0) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> words = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (words.containsKey(c)) {
                words.put(c, words.get(c) +1);
            } else {
                words.put(c, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (words.containsKey(c)) {
                int num = words.get(c);
                if (num == 1) {
                    words.remove(c);
                } else {
                    words.put(c, num - 1);
                }
            } else {
                return false;
            }
        }

        return true;
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] words = new int[26];

        for (int i = 0; i < s.length(); i++) {
            words[s.charAt(i) - 'a']++;
            words[t.charAt(i) - 'a']--;
        }

        for(int count : words) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram",  "nagaram"));
    }
}
