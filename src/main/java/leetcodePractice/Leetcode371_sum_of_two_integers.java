package leetcodePractice;

import java.awt.*;

/**
 * Created by 祁连山 on 2019/7/4.
 */
public class Leetcode371_sum_of_two_integers {
    public static int getSum(int a, int b) {
        String as = Integer.toBinaryString(a);
        String bs = Integer.toBinaryString(b);

        int aLen = as.length();
        int bLen = bs.length();

        if (bLen > aLen) {
            int swap = a;
            a = b;
            b = swap;
        }

         as = Integer.toBinaryString(a);
         bs = Integer.toBinaryString(b);

         aLen = as.length();
         bLen = bs.length();
         int len = aLen;
        char[] result = new char[len + 1];
        boolean carryOn = false;
        int i;

        for(i = 0; i < len; i++) {
            char ac = as.charAt(aLen-i-1);
            char bc;
            char re;

            if (i >= bLen) {
                bc = '0';
            } else {
                bc = bs.charAt(bLen - i - 1);
            }

            if (ac == '1' && bc == '1') {
                re = carryOn ? '1' : '0';
                carryOn = true;
            } else if (ac == '0' && bc == '0') {
                re = carryOn ? '1' : '0';
                carryOn = false;
            } else {
                if (carryOn) {
                    re = '0';
                    carryOn = true;
                } else {
                    re = '1';
                    carryOn = false;
                }
            }

            result[len - i] = re;
        }

        String reStr;
        if (carryOn) {
            result[0] = '1';
            reStr = String.valueOf(result);
        } else {
            result[0] = '0';
            reStr = String.valueOf(result);
        }

        return Integer.parseInt(reStr, 2);
    }

    public static void main(String[] args) {
        System.out.println(getSum(-2, 3));
    }
}
