import java.lang.reflect.Array;
import java.util.Stack;

public class No7_reverse_integer {
    public static int reverse2(int x) {
        Boolean isNegative = x < 0;
        if (isNegative) {
            x = -x;
        }

        String xs = Integer.toString(x);
        String reverse = new StringBuffer(xs).reverse().toString();

        try {
            int re = Integer.parseInt(reverse);
            if (isNegative) {
                re = -re;
            }
            return re;
        } catch(Exception e) {
            return 0;
        }
    }

    public static int reverse(int x) {
        int result = 0;

        int pop;
        while (x != 0) {
            pop = x % 10;
            x /= 10;

            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE && pop > 7)) {
                return 0;
            } else if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE && pop < -8)) {
                return 0;
            } else {
                result = result * 10 + pop;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }
}
