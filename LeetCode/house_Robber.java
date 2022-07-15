/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 400
 */
public class house_Robber{
    public int rob(int[] nums) {
        int n = nums.length;

        return spaceOptimized(n, nums);
    }

  
    //memoization
    private int memoization(int i, int[] nums, int[] dp){
        if(i<0) return 0;
        if(i==0) return nums[i];

        if(dp[i]!=-1) return dp[i];

        int a = nums[i] + memoization(i-2, nums, dp);
        int b = memoization(i-1, nums, dp);

        return dp[i] = Math.max(a, b);
    }

    private int[] initializeDpArray(int n){
        int[] dp = new int[n+1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        return dp;
    }


    //tabulation
    private int tabulation(int n, int[] nums, int[] dp){
        dp[0] = nums[0];
        for(int i=1; i<n; i++){
            int a = nums[i] + (((i-2)<0)?0:dp[i-2]);
            int b = dp[i-1];
            dp[i] = ((a>b)? a: b);
        }
        return dp[n-1];
    }

    //spaceOptimized
    private int spaceOptimized(int n, int[] nums){
        int prev = nums[0];
        int prev2 = 0;
        for(int i=1; i<n; i++){
            int a = nums[i] + prev2;
            int b = prev;
            int curr = ((a>b)? a: b);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}