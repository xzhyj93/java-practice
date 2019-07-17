import java.util.HashMap;

public class No13_roman_to_integer {
    public static int romanToInt(String s) {
        HashMap<Character, Integer> romanMap = new HashMap<>();

        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int i = 0;
        int result = 0;

        while(i < s.length()) {
            char ch = s.charAt(i);
            int j = i + 1;

            if (j > s.length() - 1) {
                result += romanMap.get(ch);
                break;
            }

            if (s.charAt(j) == ch) {
                while (j < s.length()) {
                    if (s.charAt(j) == ch) {
                        result += romanMap.get(ch);
                        i = j++;
                    } else {
                        i = j;
                        break;
                    }
                }
            } else if (romanMap.get(s.charAt(j)) > romanMap.get(ch)) {
                result += -romanMap.get(ch) + romanMap.get(s.charAt(j));
                i += 2;
            } else {
                result += romanMap.get(ch);
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
       System.out.println(romanToInt("DCXXI"));
    }
}
