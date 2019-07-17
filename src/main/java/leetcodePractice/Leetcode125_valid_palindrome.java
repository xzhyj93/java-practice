public class Leetcode125_valid_palindrome {
    public static boolean isPalindrome(String s) {
        boolean result = true;

        for (int i = 0, j = s.length() - 1; i < j;) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
                continue;
            } else  if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                continue;
            } else if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            } else {
                i++;
                j--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
