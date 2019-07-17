public class Leetcode28_implement_strStr {
    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        for(int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            while(j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
                if (j == needle.length() - 1) {
                    return i;
                } else {
                    j++;
                    continue;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
    }
}
