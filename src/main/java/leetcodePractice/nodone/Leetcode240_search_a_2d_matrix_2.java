package nodone;

public class Leetcode240_search_a_2d_matrix_2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = row > 0 ? matrix[0].length : 0;
        int rowMid = row / 2;
        int colMid = col / 2;
        int top = 0;

        if (matrix[0][0] == target || matrix[row][col] == target) {
            return true;
        }
        int mid = matrix[rowMid][colMid];

        if (matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }

        if (mid == target) {
            return true;
        } else if (mid > target) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Leetcode240_search_a_2d_matrix_2 test = new Leetcode240_search_a_2d_matrix_2();
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        System.out.println(test.searchMatrix(matrix, 5));
    }
}
