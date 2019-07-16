package leetcodePractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by 祁连山 on 2019/6/30.
 */
public class Leetcode350 {
    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer>hMap = new HashMap<Integer, Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
//        list.toArray(new Integer[]{});
        int i = 0;
        int key;
        int num;

        while(i < nums1.length) {
            key = nums1[i++];
            if (hMap.containsKey(key)) {
                hMap.put(key, hMap.get(key) + 1);
            } else {
                hMap.put(key, 1);
            }
        }

        i = 0;
        while(i < nums2.length) {
            key = nums2[i++];
            if (hMap.containsKey(key)) {
                num = hMap.get(key);

                if (num > 0) {
                    list.add(key);
                    num--;

                    if (num > 0) {
                        hMap.put(key, num);
                    } else {
                        hMap.remove(key);
                    }
                }
            }
        }

        int[] result = new int[list.size()];

        for (i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;

    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2, 2};

        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }
}
