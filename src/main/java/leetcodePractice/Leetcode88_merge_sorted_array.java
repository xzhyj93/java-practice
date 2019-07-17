import java.util.Arrays;

public class Leetcode88_merge_sorted_array {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int j1 = m - 1;
        int j2 = n - 1;

        if (n == 0) {
            return;
        }

        for (int i = m + n -1; i >= 0 && j2 >= 0; i--) {
            if (j1 >= 0 && nums2[j2] > nums1[j1] || j1 < 0) {
                nums1[i] = nums2[j2--];
            } else if (j1 >= 0){
                nums1[i] = nums1[j1--];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,4,5,6, 0};
        int[] nums2 = {3};

        merge(nums1, 5, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }
}
