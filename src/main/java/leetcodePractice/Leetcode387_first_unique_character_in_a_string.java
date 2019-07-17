package leetcodePractice;

import java.util.HashMap;

/**
 * Created by 祁连山 on 2019/7/1.
 */
public class Leetcode387_first_unique_character_in_a_string     {
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        int i = 0;
        char c;

        while (i < s.length()) {
            c = s.charAt(i++);

            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        i = 0;
        int result = -1;
        while(i < s.length()) {
            c = s.charAt(i);
            if (map.get(c) == 1) {
                result = i;
                break;
            }
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";

        System.out.println(firstUniqChar(s));
    }
}
