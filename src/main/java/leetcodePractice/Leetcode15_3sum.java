import java.lang.reflect.Array;
import java.util.*;

public class Leetcode15_3sum {
    /*
        sort and map
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int mid = i + 1;
            int right = nums.length - 1;

            while(mid < right) {
                int sum = nums[i] + nums[mid] + nums[right];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[mid]);
                    list.add(nums[right]);

                    if (map.containsKey(nums[i])) {
                        if (map.get(nums[i]) >= nums[mid]) {
                            mid++;
                            right--;
                            continue;
                        }
                    }
                    map.put(nums[i], nums[mid]);
                    mid++;
                    right--;
                    result.add(list);
                } else if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    mid++;
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSum_with_sort(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            while(i > 0 && nums[i] == nums[i - 1] && i < nums.length - 2){
                i++;
            }

            int j = i + 1;
            int right = nums.length - 1;

            while(j < right) {
                while (j > i + 1 && nums[j] == nums[j - 1] && j < nums.length - 1 && j < right){
                    j++;
                }

                if (j >= right) {
                    break;
                }
                int sum = nums[i] + nums[j] + nums[right];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[right]);

                    result.add(list);
                    j++;
                    right--;

                    while(right > 1 && nums[right] == 0) {
                        right--;
                    }
                } else if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    j++;
                }
            }
        }

        return result;
    }

    public List<List<Integer>> threeSum_time_limit_exceeded(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);

                        Collections.sort(list);
                        boolean alreadyHave = false;

                        for(List<Integer> bef : result) {
                            if (bef.get(0) == list.get(0) && bef.get(1) == list.get(1)) {
                                alreadyHave = true;
                                break;
                            }
                        }

                        if (!alreadyHave) {
                            result.add(list);
                        }
                        break;
                    }
                }
            }
        }

        return result;

    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};

        System.out.println(threeSum(nums));
    }
}
