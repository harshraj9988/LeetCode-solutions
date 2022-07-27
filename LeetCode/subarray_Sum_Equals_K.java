import java.util.Arrays;

// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

// A subarray is a contiguous non-empty sequence of elements within an array.

// Example 1:

// Input: nums = [1,1,1], k = 2
// Output: 2
// Example 2:

// Input: nums = [1,2,3], k = 3
// Output: 2

// Constraints:

// 1 <= nums.length <= 2 * 104
// -1000 <= nums[i] <= 1000
// -107 <= k <= 107

public class subarray_Sum_Equals_K {
    public int subarraySum(int[] nums, int k) {
        return bruteForce(nums, k);
    }

    // for contigeous subarray
    private int bruteForce(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k)
                    ans++;
            }
        }
        return ans;
    }

    // for non contigeous subset
    private int recursion(int[] nums, int k, int i) {
        if (k == 0)
            return 1;
        if (i == 0) {
            if (nums[i] == k)
                return 1;
            else
                return 0;
        }

        int pick = recursion(nums, k - nums[i], i - 1);
        int notPick = recursion(nums, k, i - 1);

        return pick + notPick;
    }

    private int memoization(int[] nums, int k, int i, int[][] dp) {
        if (k == 0)
            return 1;
        if (i == 0) {
            if (nums[i] == k)
                return 1;
            else
                return 0;
        }

        if (dp[i][k] != -1)
            return dp[i][k];
        int pick = 0;
        if (k >= nums[i]) {
            pick = memoization(nums, k - nums[i], i - 1, dp);
        }
        int notPick = memoization(nums, k, i - 1, dp);

        return dp[i][k] = pick + notPick;
    }
}