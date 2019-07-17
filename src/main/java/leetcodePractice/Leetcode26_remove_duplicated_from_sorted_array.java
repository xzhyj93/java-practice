import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode26_remove_duplicated_from_sorted_array {
    public static int removeDuplicates(int[] nums) {
        int len = 0;
        int j = 1;

        if (nums.length > 0) {
            len = 1;
        }

        for(int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            } else {
                nums[j++] = nums[i];
                len++;
            }
        }

        return len;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,3,3,4};
        System.out.println(removeDuplicates(arr));
    }
}
