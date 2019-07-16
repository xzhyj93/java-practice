package leetcodePractice;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by 祁连山 on 2019/7/14.
 */
public class Leetcode20_valid_parentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (map.get(ch) != pop) {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(Boolean.toString(isValid("()[]}")));
    }
}
