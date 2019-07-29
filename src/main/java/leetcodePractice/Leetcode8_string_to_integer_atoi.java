package leetcodePractice;

public class Leetcode8_string_to_integer_atoi {
    public static int myAtoi(String str) {
        int result = 0;
        int flag = 1;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == ' ') {
                continue;
            } else if (Character.isDigit(ch) || ch == '-' || ch == '+') {
                if (ch == '-') {
                    flag = -1;
                } else if (Character.isDigit(ch)) {
                    result = ch - '0';
                }

                i++;
                while(i < str.length()) {
                    ch = str.charAt(i);

                    if (Character.isDigit(ch)) {
                        if (flag > 0 && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 <= (ch - '0')))) {
                            return flag * Integer.MAX_VALUE;
                        } else if (flag < 0 && (result * flag < Integer.MIN_VALUE / 10 || (result * flag == Integer.MIN_VALUE / 10 && flag * (Integer.MIN_VALUE % 10) <= (ch - '0') ))) {
                            return Integer.MIN_VALUE;
                        } else {
                            result = result * 10 + (ch - '0');
                            i++;
                        }
                    } else {
                        return result * flag;
                    }
                }
            } else {
                break;
            }
        }

        return result * flag;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("2147483648"));
    }
}
