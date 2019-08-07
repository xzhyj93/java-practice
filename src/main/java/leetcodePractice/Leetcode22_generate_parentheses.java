package leetcodePractice;

import java.util.ArrayList;
import java.util.List;

public class Leetcode22_generate_parentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
                List<String> left = generateParenthesis(i);
                List<String> right = generateParenthesis(n - 1 - i);

                if (left.size() == 0) {
                    left.add("");
                }
                if (right.size() == 0) {
                    right.add("");
                }

                for (String le : left) {
                    for (String ri : right) {
                        result.add("(" + le + ")" + ri);
                    }
                }
        }

        return result;
    }

    public static void main(String[] args) {
        Leetcode22_generate_parentheses test = new Leetcode22_generate_parentheses();
        System.out.println(test.generateParenthesis(1));
    }
}
