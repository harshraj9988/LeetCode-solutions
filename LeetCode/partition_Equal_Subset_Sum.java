/**
 * Given a non-empty array nums containing only positive integers, find if the
 * array can be partitioned into two subsets such that the sum of elements in
 * both subsets is equal.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 * 
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 */
public class partition_Equal_Subset_Sum {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 == 1)
            return false;

        int k = sum / 2;

        int[][] dp = new int[n + 1][k + 1];

        return solve(nums, k, n - 1, dp);
    }

    private boolean solve(int[] nums, int k, int n, int[][] dp) {
        if (k == 0)
            return true;
        int val = nums[n];
        if (n == 0) {
            if (k == val)
                return true;
            else
                return false;
        }
        if (k < 0)
            return false;

        int prevCal = dp[n][k];
        if (prevCal != 0)
            return (prevCal == 2) ? true : false;

        boolean pick = false;
        if (k >= val) {
            pick = solve(nums, k - val, n - 1, dp);
        }
        boolean notPick = solve(nums, k, n - 1, dp);

        boolean result = pick || notPick;

        dp[n][k] = (result) ? 2 : 1;

        return result;
    }
}
