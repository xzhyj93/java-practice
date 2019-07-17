import java.util.HashMap;

public class Leetcode70_climbing_stairs {
    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int pre = 1;
        int pre2 = 2;
        int steps;

        for (int i = 2; i < n; i++) {
            steps = pre + pre2;
            pre = pre2;
            pre2 = steps;
        }

        return pre2;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
}
