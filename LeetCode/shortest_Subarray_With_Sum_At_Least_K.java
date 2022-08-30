/**
 * Given an integer array nums and an integer k, return the length of the shortest non-empty subarray of nums with a sum of at least k. If there is no such subarray, return -1.

A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [1], k = 1
Output: 1
Example 2:

Input: nums = [1,2], k = 4
Output: -1
Example 3:

Input: nums = [2,-1,2], k = 3
Output: 3
 

Constraints:

1 <= nums.length <= 105
-105 <= nums[i] <= 105
1 <= k <= 109
 */
import java.util.*;
public class shortest_Subarray_With_Sum_At_Least_K{
    public int shortestSubarray(int[] nums, int k) {
        int shortest = Integer.MAX_VALUE;

        Deque<long[]> deque = new ArrayDeque<>();
        int n = nums.length;
        long sum = 0;
        for(int i=0; i<n; i++){
            sum+=nums[i];
            if(sum>=k) shortest = Math.min(shortest, i+1);

            long[] pair = new long[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
            while(!deque.isEmpty() && (sum - deque.getFirst()[1])>=k){
                pair = deque.removeFirst();
            }
            if(pair[0]!=Integer.MIN_VALUE){
                shortest = Math.min(shortest, i-(int)pair[0]);
            }
            while(!deque.isEmpty() && sum<deque.getLast()[1]) deque.removeLast();
            deque.add(new long[]{i, sum});
        }    
        return (shortest==Integer.MAX_VALUE)?-1: shortest;
    }
}