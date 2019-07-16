package leetcodePractice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by 祁连山 on 2019/6/30.
 */
public class Leetcode66PlusOne {
    public static int[] plusOne(int[] digits) {
        int len = digits.length;

        if (digits[len - 1] < 9) {
            digits[len - 1] += 1;
            return digits;
        } else {
            return carryOne(digits, len - 1);
        }
    }

    public static int[] carryOne(int[] digits, int i) {
        digits[i] = 0;
        if (i == 0) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int j = 0; j < digits.length; j++) {
                result[j + 1] = digits[j];
            }
            return result;
        } else {
            if (digits[i - 1] < 9) {
                digits[i - 1] += 1;
                return digits;
            } else {
                return carryOne(digits, i - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] in = {9};
        System.out.println("result:");
        System.out.println((Arrays.toString(plusOne(in))));
    }
}
