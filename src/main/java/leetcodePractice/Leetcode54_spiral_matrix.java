import java.util.ArrayList;
import java.util.List;

public class Leetcode54_spiral_matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix.length > 0) {
            add2List(result, matrix, 0);
        }

        return result;
    }

    public void add2List(List<Integer> list, int[][] matrix, int index) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        if (index < rows) {
            for (int i = index; i <= columns - 1 - index; i++) {
                list.add(matrix[index][i]);
            }
        }

        for (int i = index + 1; i <= rows - 1 - index; i++) {
            list.add(matrix[i][columns - 1 - index]);
        }

        if (rows - 1 - index != index && index < rows) {
            for (int i = columns - 2 - index; i >= index; i--) {
                list.add(matrix[rows - 1 - index][i]);
            }
        }


        if (index < rows && columns - 1 - index != index) {
            for (int i = rows - 2 - index; i > index; i--) {
                list.add(matrix[i][index]);
            }
        }


        if (index >= rows - 2 - index || index >= columns - 2 - index) {
            return;
        } else {
            add2List(list,matrix,++index);
        }
    }

    public static void main(String[] args) {
        Leetcode54_spiral_matrix test = new Leetcode54_spiral_matrix();
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] matrix2 = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix3 = {{2,3}};
        int[][] matrix4 = {{1},{2},{3},{4},{5},{6},{7},{8},{9},{10}};
        System.out.println(test.spiralOrder(matrix));
    }
}
