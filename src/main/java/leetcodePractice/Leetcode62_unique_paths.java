import java.util.Arrays;

public class Leetcode62_unique_paths {
    public int uniquePaths(int m, int n) {
        if (m > n) {
            return uniquePaths_2(n, m);
        } else {
            return uniquePaths_2(m, n);
        }
    }

    public int uniquePaths_2(int m, int n) {
        int[] row = new int[m];
        Arrays.fill(row, 1);

        for (int i = n - 2; i >= 0; i--) {
            row[m - 1] = 1;

            for (int j = m - 2; j >= 0; j--) {
                row[j] = row[j + 1] + row[j];
            }
        }

        return row[0];
    }

    public static void main(String[] args) {
        Leetcode62_unique_paths test = new Leetcode62_unique_paths();
        System.out.println(test.uniquePaths(7, 3));
    }
}
