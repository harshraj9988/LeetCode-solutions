import java.util.*;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements.
 *  You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class top_K_Fragment_Elements{
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        addFrequencyToMap(map, nums);
        PriorityQueue<Map.Entry<Integer, Integer>> heap = addToHeap(map);
        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            result[i]=heap.poll().getKey();
        }
        return result;
    }

    private void addFrequencyToMap(Map<Integer, Integer> map, int[] nums){
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
    }

    private PriorityQueue<Map.Entry<Integer, Integer>> addToHeap(Map<Integer, Integer> map){
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            heap.add(entry);
        }
        return heap;
    }

    
}