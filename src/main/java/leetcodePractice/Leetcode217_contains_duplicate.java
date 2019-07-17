package leetcodePractice;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by 祁连山 on 2019/7/17.
 */
public class Leetcode217_contains_duplicate {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if(set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4, 2};
        System.out.println(containsDuplicate(nums));
    }
}
