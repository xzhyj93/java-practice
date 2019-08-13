import Utils.Utils;

public class Leetcode48_rotate_image {
    public void rotate(int[][] matrix) {
        int len = matrix.length;

        for (int i = 0; i < len / 2; i++) {
            for (int j = i; j < len - 1 - i; j++) {
                int num = matrix[i][j];
                int tmp = num;

                tmp = matrix[j][len - 1 - i];
                matrix[j][len - 1 - i] = num;
                num = tmp;

                tmp = matrix[len - 1 - i][len - 1 - j];
                matrix[len - 1 - i][len - 1 - j] = num;
                num = tmp;

                tmp = matrix[len - 1 - j][i];
                matrix[len - 1 - j][i] = num;

                matrix[i][j] = tmp;
//                System.out.println(Integer.toString(i) + ',' + Integer.toString(j));
//                Utils.printMatrix(matrix);
            }
        }
    }

    public static void main(String[] args) {
        Leetcode48_rotate_image test = new Leetcode48_rotate_image();
        int[][] matrix = {{1,2,3, 4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        test.rotate(matrix);
        Utils.printMatrix(matrix);

    }
}
