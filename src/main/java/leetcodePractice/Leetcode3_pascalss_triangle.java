import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Leetcode3_pascalss_triangle {
    public static List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < numRows; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            if (i == 0) {
                row.add(1);
            } else if (i == 1) {
                row.add(1);
                row.add(1);
            } else {
                row.add(1);
                List<Integer> pre = list.get(i - 1);

                for(int j = 1; j < i; j++) {
                    row.add(pre.get(j - 1) + pre.get(j));
                }
                row.add(1);
            }

            list.add(row);
        }

        return list;

    }

    public static void main(String[] args) {
        System.out.println(generate(5).toString());
    }
}
