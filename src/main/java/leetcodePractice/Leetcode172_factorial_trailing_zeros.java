package leetcodePractice;

/**
 * Created by 祁连山 on 2019/7/16.
 */
public class Leetcode172_factorial_trailing_zeros {
    public static int trailingZeroes1(int n) {
        int sum = n / 5;

        int num = 5 * 5;
        while(n >= num) {
            sum += n / num;
            num *= 5;
        }

        return sum;
    }

    public static int trailingZeroes(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n / 5;
            n = n / 5;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(30));
    }
}
