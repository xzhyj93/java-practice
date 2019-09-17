import java.util.*;

public class Leetcode395_Longest_Substring_with_At_Least_K_Repeating_Characters {

    public int longestSubstring(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        Set<Character> noSet = new HashSet<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() < k) {
                noSet.add(entry.getKey());
            }
        }

        if (noSet.isEmpty()) {
            return s.length();
        }

        ArrayList<Integer> seperate = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (noSet.contains(s.charAt(i))) {
                seperate.add(i);
            }
        }

        int result = 0;

        for (int i = 0, j = 0; j <= seperate.size(); j++) {
            int sep;
            if (j < seperate.size()) {
                sep = seperate.get(j);
            } else {
                sep = s.length();
            }

            if (sep - i >= k && sep - i > result) {
                result = Math.max(result, longestSubstring(s.substring(i, sep), k));
            }
            i = sep + 1;
        }

        return result;
    }

    public static void main(String[] args) {
        Leetcode395_Longest_Substring_with_At_Least_K_Repeating_Characters test = new Leetcode395_Longest_Substring_with_At_Least_K_Repeating_Characters();
        System.out.println(test.longestSubstring("bbaaacbd", 3));
    }
}
