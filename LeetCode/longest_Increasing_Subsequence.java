/**
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

 

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
 

Constraints:

1 <= nums.length <= 2500
-104 <= nums[i] <= 104
 

Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 */

import java.util.*;;
public class longest_Increasing_Subsequence{
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len+1];
        for(int i=0; i<len; i++){
            Arrays.fill(dp[i], -1);
        }
        return memoization(nums, len, 0, 0, dp);
    }
    
    private int recursion(int[] nums, int len, int curr, int prev){
        if(curr == len) return 0;
        
        int notTake = recursion(nums, len, curr+1, prev);
        int take = 0;
        if(prev==0 || nums[curr]>nums[prev-1]){
            take = 1 + recursion(nums, len, curr+1, curr+1);
        }
        
        return Math.max(take, notTake);
    }
    
    private int memoization(int[] nums, int len, int curr, int prev, int[][] dp){
        if(curr == len) return 0;
        
        if(dp[curr][prev]!=-1) return dp[curr][prev];
        
        int notTake = memoization(nums, len, curr+1, prev, dp);
        int take = 0;
        if(prev==0 || nums[curr] > nums[prev-1] ){
            take = 1 + memoization(nums, len, curr+1, curr+1, dp);
        }
        
        return dp[curr][prev] = Math.max(take, notTake);
    }
    
    private int binarySearchApproach(int[] nums){
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(nums[0]);
        int size = 1;
        int n = nums.length;
        for(int i=1; i<n; i++){
            int num = nums[i];
            int ind = Collections.binarySearch(arr, num);
            if(ind<0){
                ind*=-1; ind--;
                if(ind==size){
                    arr.add(num); size++;
                }else{
                    arr.set(ind, num);
                }
            }
        }
        return size;
    }
}