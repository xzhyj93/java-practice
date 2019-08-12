import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Leetcode56_merge_intervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();

        Arrays.sort(intervals, new IntervalComparator());

        if (intervals.length > 0) {
            int min = intervals[0][0];
            int max = intervals[0][1];

            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] <= max) {
                    max = Math.max(max, intervals[i][1]);
                } else {
                    result.add(new int[]{min, max});
                    min = intervals[i][0];
                    max = intervals[i][1];
                }
            }

            result.add(new int[]{min, max});
        }

        int[][] resultArr = new int[result.size()][];

        for (int i = 0; i < result.size(); i++) {
            resultArr[i] = result.get(i);
        }
        return resultArr;
    }

    class IntervalComparator implements Comparator<int[]> {
        public int compare(int[] interval1, int[] interval2) {
            if (interval1[0] > interval2[0]) {
                return 1;
            } else if (interval1[0] == interval2[0]){
                return 0;
            } else {
                return -1;
            }
        }
    }
    public static void main(String[] args) {
        Leetcode56_merge_intervals test = new Leetcode56_merge_intervals();
        int[][] nums = {{1,3},{2,5},{9,10},{12,18},{3,4}};

        int[][] result = test.merge(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }
}
