import java.lang.reflect.Array;

public class Leetcode_718_Maximum_Length_of_Repeated_Subarray {
    public int findLength(int[] A, int[] B) {
        int row = A.length;
        int col = B.length;

        int[][] dp = new int[2][col];
        int max = 0;
        int curr = 1;
        int prev = 0;


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (A[i] == B[j]) {
                    if (i == 0) {
                        dp[curr][j] = 1;
                    } else if (j == 0) {
                        dp[curr][j] = 1;
                    } else {
                        dp[curr][j] = 1 + Math.max(dp[prev][j-1], 0);
                    }

                    max = Math.max(max, dp[curr][j]);
                } else {
                    dp[curr][j] = 0;
                }


            }
            curr = prev;
            prev = prev == 0 ? 1 : 0;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] A = {1, 0, 0, 0, 1};
        int[] B = {1, 0, 0, 1, 1};

        Leetcode_718_Maximum_Length_of_Repeated_Subarray test = new Leetcode_718_Maximum_Length_of_Repeated_Subarray();

        System.out.println(test.findLength(A, B));
    }
}
