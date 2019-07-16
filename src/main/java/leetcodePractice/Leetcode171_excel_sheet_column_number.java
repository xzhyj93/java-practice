package leetcodePractice;

/**
 * Created by 祁连山 on 2019/7/16.
 */
public class Leetcode171_excel_sheet_column_number {
    public static int titleToNumber(String s) {
        int num = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int j = s.length() - i;
            num += (s.charAt(i) - 'A' + 1) * Math.pow(26, j - 1);
        }

        return num;
    }
    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));
    }
}
