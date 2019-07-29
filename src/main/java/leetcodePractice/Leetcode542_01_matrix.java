package leetcodePractice;

import org.omg.CORBA.MARSHAL;

import java.util.Arrays;

/**
 * Created by 祁连山 on 2019/7/17.
 */
public class Leetcode542_01_matrix {
    public int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0 ; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    result[i][j] = 0;
                } else {
                    result[i][j] = Integer.MAX_VALUE;
                    if (i > 0) {
                        result[i][j] = result[i - 1][j] + 1;
                    }
                    if (j > 0) {
                        result[i][j] = Math.min(result[i][j], result[i][j - 1] + 1);
                    }
                }
            }
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (j < cols - 1) {
                    result[i][j] = Math.min(result[i][j], result[i][j + 1] +1);
                }
                if (i < rows - 1) {
                    result[i][j] = Math.min(result[i][j], result[i + 1][j] + 1);
                }
            }
        }

        return result;
    }
    public int[][] updateMatrix_wrong(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        int[][] visited = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                setNum_wrong(matrix, result, visited, i, j);
            }
        }

        return result;
    }

    public int setNum_wrong(int[][] matrix, int[][] result, int[][] visited, int i, int j) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return Integer.MAX_VALUE;
        }


        if (matrix[i][j] == 0) {
            result[i][j] = 0;
        } else if (visited[i][j] == 0) {
//            int[] adjacent = {setNum(matrix, result, visited, i + 1, j), setNum(matrix, result, visited, i, j + 1), setNum(matrix, result, visited, i - 1 , j), setNum(matrix, result, visited, i, j - 1)};
//            visited[i][j] = 1;
//            Arrays.sort(adjacent);
//
//            result[i][j] = adjacent[0] + 1;
        }

        return result[i][j];
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 0}, {0, 1, 0}, {0, 1, 0},{0, 1, 0}};

        Leetcode542_01_matrix ques = new Leetcode542_01_matrix();

        int[][] result = ques.updateMatrix(matrix);

        for (int[] re : result) {
            System.out.println(Arrays.toString(re));
        }
    }
}
