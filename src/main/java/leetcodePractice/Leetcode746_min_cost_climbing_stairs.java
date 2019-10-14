public class Leetcode746_min_cost_climbing_stairs {

    public int minCostClimbingStairs(int[] cost) {
        int[] result = new int[cost.length + 1];
        result[0] = result[1] = 0;

        for (int i = 2; i < result.length; i++) {
            result[i] = Math.min(result[i - 1] + cost[i - 1], result[i - 2] + cost[i - 2]);
        }

        return result[result.length - 1];
    }

    public static void main(String[] args) {
        int[] cost = {10, 15, 25};
        System.out.println(new Leetcode746_min_cost_climbing_stairs().minCostClimbingStairs(cost));
    }
}
