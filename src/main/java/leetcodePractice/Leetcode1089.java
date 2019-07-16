package leetcodePractice;

import java.util.Arrays;

/**
 * Created by 祁连山 on 2019/7/1.
 */
public class Leetcode1089 {
    public static void duplicateZeros(int[] arr) {
        duplicateZeros(arr, 0);
    }

    public static void duplicateZeros(int[] arr, int start) {
        if (start >= arr.length - 1) {
            return;
        } else if (arr[start] == 0) {
            System.arraycopy(arr, start+1, arr, start+2, arr.length - start - 2);
            arr[start+1] = 0;
            duplicateZeros(arr, start+2);
        } else {
            duplicateZeros(arr, start+1);
        }
    }

    public static void main(String[] args) {
        int[] in =  {0,0,1,0,0,0,0};
        duplicateZeros(in);

        System.out.println(Arrays.toString(in));
    }
}
