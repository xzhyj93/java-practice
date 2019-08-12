public class Leetcode33_search_in_rotated_sorted_array {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        return searchInRotate(nums, target, left, right);

    }

    public int searchInRotate(int[] nums, int target, int left, int right) {
        int result = -1;

        while (left <= right) {
            if (nums[left] == target) {
                result = left;
                break;
            }
            if (nums[right] == target) {
                result = right;
                break;
            }

            if (left == right) {
                break;
            }

            if (nums[left] < nums[right]) {
                result = binarySearch(nums, target, left, right);
                break;
            } else {
                int mid = (left + right) / 2;

                if (nums[mid] == target) {
                    result = mid;
                    break;
                }

                if (nums[mid] < nums[right]) {
                    if (nums[mid] < target && nums[right] > target) {
                        result = binarySearch(nums, target, mid + 1, right - 1);
                        break;
                    } else {
                        left++;
                        right = mid - 1;
                    }
                } else {
                    if (nums[mid] > target && nums[left] < target) {
                        result = binarySearch(nums, target, left + 1, mid - 1);
                        break;
                    } else {
                        left = mid + 1;
                        right--;
                    }
                }
            }
        }

        return result;
    }

    public int binarySearch(int[] nums, int target, int left, int right) {
        if (left > nums.length - 1 || right < 0 || left > right || nums[left] > target || nums[right] < target) {
            return -1;
        }

        if (left >= right) {
            if (left <= nums.length - 1 && nums[left] == target) {
                return left;
            } else if (right >= 0 && nums[right] == target) {
                return right;
            } else {
                return -1;
            }
        }

        int result = -1;
        while (left <= right) {
            if (nums[left] == target) {
                result = left;
                break;
            }
            if (nums[right] == target) {
                result = right;
                break;
            }

            if (nums[left] > target || nums[right] < target || left + 1 >= right) {
                result = -1;
                break;
            } else {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    result = mid;
                    break;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
                continue;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        Leetcode33_search_in_rotated_sorted_array test = new Leetcode33_search_in_rotated_sorted_array();
        System.out.println(test.search(nums, 3));
    }
}
