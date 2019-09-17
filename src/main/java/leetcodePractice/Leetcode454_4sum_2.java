import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode454_4sum_2 {
    public int fourSumCount_time_limit(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;
        List<int[]> list = new ArrayList<>();
        list.add(A);
        list.add(B);
        list.add(C);
        list.add(D);

        HashMap[] mapList = new HashMap[4];
        for (int i = 0; i < mapList.length; i++) {
            mapList[i] = new HashMap<Integer, Integer>();
        }

        result = sumCount_time_limit(list, 0, mapList);
        return result;
    }

    public int sumCount_time_limit(List<int[]> list, int sum, HashMap[] mapList) {
        int count = 0;
        HashMap<Integer, Integer> map = mapList[list.size() - 1];

        if (map.containsKey(sum)) {
            return map.get(sum);
        }

        if (list.size() == 1) {
            int[] arr = list.get(0);
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == sum) {
                    count ++;
                }
            }
        } else {
            int[] arr = list.get(0);
            for (int i = 0; i < arr.length; i++) {
                count += sumCount_time_limit(list.subList(1, list.size()), sum - arr[i], mapList);
            }
        }

        map.put(sum, count);

        return count;
    }

    public int fourSumCount_time_limit_2(int[] A, int[] B, int[] C, int[] D) {
        List<int[]> list = new ArrayList<>();
        list.add(A);
        list.add(B);
        list.add(C);
        list.add(D);

        HashMap<Integer, Integer> prev = new HashMap<>();
        HashMap<Integer, Integer> curr = new HashMap<>();

        int count = 0;

        for (int[] arr : list) {
            count = 0;
            curr.clear();

            for (int i = 0; i < arr.length; i++) {
                if (prev.size() > 0) {
                    for (int key : prev.keySet()) {
                        int sum = key + arr[i];
                        if (curr.containsKey(sum)) {
                            curr.put(sum, curr.get(sum) + prev.get(key));
                        } else {
                            curr.put(sum, prev.get(key));
                        }
                    }
                } else {
                    if (curr.containsKey(arr[i])) {
                        curr.put(arr[i], curr.get(arr[i]) + 1);
                    } else {
                        curr.put(arr[i], 1);
                    }
                }

            }

            prev.clear();
            prev.putAll(curr);
        }

        return curr.containsKey(0) ? curr.get(0) : 0;
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> sums = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                sums.put(A[i] + B[j], sums.getOrDefault(A[i] + B[j], 0) + 1);
            }
        }

        int count = 0;

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                count += sums.getOrDefault(-1 * (C[i] + D[j]), 0);
            }
        }

        return count;
    }

    public static void main(String[] args) {
//        int[] A = {1, 2};
//        int[] B = {-2, -1};
//        int[] C = {-1, 2};
//        int[] D = {0, 2};

        int[] A = {1,1,-1,-1};
        int[] B = {-1,-1,1,1};
        int[] C = {1,-1,0,-1};
        int[] D = {1,1,-1,1};

//        int[] A = {-1,-1};
//        int[] B = {-1,1};
//        int[] C = {-1,1};
//        int[] D = {1,-1};

        Leetcode454_4sum_2 test = new Leetcode454_4sum_2();
        System.out.println(test.fourSumCount(A, B, C, D));
    }
}
