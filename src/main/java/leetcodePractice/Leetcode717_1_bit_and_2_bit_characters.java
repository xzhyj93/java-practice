package leetcodePractice;

/**
 * Created by 祁连山 on 2019/7/18.
 */
public class Leetcode717_1_bit_and_2_bit_characters {
    public static boolean isOneBitCharacter(int[] bits) {
        if (bits.length == 0) {
            return false;
        } else if (bits.length == 1) {
            return true;
        }

        for (int i = 0; i < bits.length; ) {
            if (i == bits.length - 1) {
                return true;
            }

            if (bits[i] == 1) {
                i += 2;
            } else {
                i++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] bits = {1, 1, 1, 0};
        System.out.println(isOneBitCharacter(bits));
    }
}
