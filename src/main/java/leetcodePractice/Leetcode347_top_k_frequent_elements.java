import java.lang.reflect.Array;
import java.security.KeyStore;
import java.util.*;

public class Leetcode347_top_k_frequent_elements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));

        for (int num : map.keySet()) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        while(!queue.isEmpty()){
            result.add(queue.poll());
        }

        return result;
    }

    public List<Integer> topKFrequent_use_collections(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> item : list) {
            if (result.size() < k) {
                result.add(item.getKey());
            } else {
                break;
            }
        }


        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        Leetcode347_top_k_frequent_elements test = new Leetcode347_top_k_frequent_elements();
        System.out.println(test.topKFrequent(nums, 2));
    }
}
