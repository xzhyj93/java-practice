public class Leetcode14_longest_common_prefix {
    public static String longestCommonPrefix(String[] strs) {
        String pre = "";
        int len = strs.length == 0 ? 0 : Integer.MAX_VALUE;

        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < len) {
                len = strs[i].length();
            }
        }

        for(int i = 0; i < len; i++) {
            char ch = strs[0].charAt(i);

            boolean same = true;

            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) == ch) {
                    continue;
                } else {
                    same = false;
                    break;
                }
            }

            if (same) {
                pre += ch;
            } else {
                break;
            }
        }

        return pre;
    }

    public static void main(String[] args) {
        String[] list = { };

        System.out.println(longestCommonPrefix(list));

    }
}
