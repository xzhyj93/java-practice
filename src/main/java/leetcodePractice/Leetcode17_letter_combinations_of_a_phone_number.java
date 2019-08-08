import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode17_letter_combinations_of_a_phone_number {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();

        HashMap<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});

        if (digits.length() > 0) {
            for (char ch : map.get(digits.charAt(0))) {
                if (digits.length() > 1) {
                    dfc(map, result, 1, Character.toString(ch), digits);
                } else {
                    result.add(Character.toString(ch));
                }
            }
        }

        return result;

    }

    public void dfc(HashMap<Character, char[]> map, List<String> result, int index, String str, String digits) {
        if (index == digits.length() - 1) {
            for (char ch : map.get(digits.charAt(index))) {
                result.add(str + Character.toString(ch));
            }
        } else {
            for (char ch : map.get(digits.charAt(index))) {
                dfc(map, result, index + 1, str + Character.toString(ch), digits);
            }
        }
    }

    public static void main(String[] args) {
        Leetcode17_letter_combinations_of_a_phone_number test = new Leetcode17_letter_combinations_of_a_phone_number();
        System.out.println(test.letterCombinations("234"));
    }
}
