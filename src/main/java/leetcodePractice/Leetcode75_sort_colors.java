import java.util.Arrays;

public class Leetcode75_sort_colors {
    public void sortColors(int[] nums) {
        int num0 = 0, num1 = 0, num2 = 0;

        for (int num : nums) {
            switch (num) {
                case 0:
                    num0++;
                    break;
                case 1:
                    num1++;
                    break;
                case 2:
                    num2++;
                    break;
            }
        }

        for (int i = 0; i < nums.length;i++) {
            if (i < num0) {
                nums[i] = 0;
            } else if (i < num0 + num1) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }

    }

    public static void main(String[] args) {
        Leetcode75_sort_colors test = new Leetcode75_sort_colors();
        int[] nums = {1,2,0,0,1,2};

        test.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
