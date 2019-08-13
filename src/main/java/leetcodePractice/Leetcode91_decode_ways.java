import java.util.HashMap;

public class Leetcode91_decode_ways {
    private HashMap<String, Integer> map = new HashMap<>();

    public int numDecodings_use_map(String s) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        int nums = 0;

        if (s.length() == 0) {
            nums = 0;
        } else if (s.charAt(0) == '0') {
            nums = 0;
        } else if (s.length() == 1) {
            nums = 1;
        } else {
            if (s.length() > 1) {
                nums = numDecodings(s.substring(1));
            } else {
                nums = 1;
            }

            if (s.charAt(0) < '2' || (s.charAt(0) == '2' && s.charAt(1) <= '6')) {
                if (s.length() > 2) {
                    nums += numDecodings(s.substring(2));
                } else {
                    nums++;
                }

            }
        }

        map.put(s, nums);
        return nums;
    }

    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int nums = 1;
        int pre = 1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (i > 0 && s.charAt(i - 1) <= '2' && s.charAt(i - 1) >= '1') {
                    nums = pre;
                } else {
                    return 0;
                }
            } else if (i > 0) {
                if ((s.charAt(i - 1) > '0' && s.charAt(i - 1) <= '1') || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')) {
                    nums = nums + pre;
                    pre = nums - pre;
                } else {
                    pre = nums;
                }
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        Leetcode91_decode_ways test = new Leetcode91_decode_ways();
        System.out.println(test.numDecodings("12120"));
    }
}
