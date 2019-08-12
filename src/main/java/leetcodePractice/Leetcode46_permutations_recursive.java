import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode46_permutations_recursive {
    private Map<int[], List<List<Integer>>> map = new HashMap<>();

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for(int i = 0; i < nums.length; i++) {

            int[] othersArr = deleteArrayElement(nums, i);
            List<List<Integer>> other = permute(othersArr);

            if (other.size() == 0) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                result.add(list);
            } else {
                for(List<Integer> item : other) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.addAll(item);

                    result.add(list);
                }
            }

        }

        return result;
    }

    public int[] deleteArrayElement(int[] nums, int index) {
        int[] result = new int[nums.length - 1];
        for (int i = 0; i < result.length; i++) {
            if (i < index) {
                result[i] = nums[i];
            } else if (i >= index){
                result[i] = nums[i + 1];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Leetcode46_permutations_recursive test = new Leetcode46_permutations_recursive();
        int[] nums = {1,2,3};
        System.out.println(test.permute(nums));
    }
}
