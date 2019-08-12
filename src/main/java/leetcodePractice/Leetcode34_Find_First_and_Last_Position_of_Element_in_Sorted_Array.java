public class Leetcode34_Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];

        int index = binarySearch(nums, 0, nums.length - 1, target);

        result[0] = index;
        result[1] = index;

        if (index != -1) {
            int i = index - 1;
            while(i >= 0 && nums[i] == target) {
                result[0] = i--;
            }
            i = index + 1;
            while(i < nums.length && nums[i] == target) {
                result[1] = i++;
            }
        }

        return result;
    }

    public int binarySearch(int[] nums, int left, int right, int target) {
        int index = -1;

            while (left <= right && left < nums.length && right >= 0) {
                if (nums[left] == target) {
                    index= left;
                    break;
                } else if (nums[right] == target) {
                    index= right;
                    break;
                } else if (nums[left] < target && nums[right] > target) {
                    int mid = (left + right) / 2;

                    if (nums[mid] == target) {
                        index = mid;
                        break;
                    } else if (nums[mid] > target) {
                        left++;
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                        right--;
                    }
                } else {
                    index = -1;
                    break;
                }
            }


        return index;

    }

    public static void main(String[] args) {
        Leetcode34_Find_First_and_Last_Position_of_Element_in_Sorted_Array test = new Leetcode34_Find_First_and_Last_Position_of_Element_in_Sorted_Array();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] result = test.searchRange(nums, 6);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
