import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Leetcode46_permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, result, new ArrayList<Integer>(), new boolean[nums.length]);
        return result;
    }

    public void dfs(int[] nums, List<List<Integer>> result, List<Integer>temp, boolean[] isUsed) {
        if (nums.length == temp.size()) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if (!isUsed[i]) {
                temp.add(nums[i]);
                isUsed[i] = true;
                dfs(nums, result, temp, isUsed);
                temp.remove(temp.size() - 1);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Leetcode46_permutations test = new Leetcode46_permutations();

        int[] nums = {1,2,3};
        System.out.println(test.permute(nums));
    }
}
