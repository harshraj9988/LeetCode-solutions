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

        return memoization(nums, k, n - 1, dp);
    }

  
    private boolean memoization(int[] nums, int k, int n, int[][] dp) {
        if (k == 0)
            return true;
        if (n == 0) {
            if (nums[n] == k)
                return true;
            else
                return false;
        }

        if (dp[n][k] != 0)
            return (dp[n][k] == 2) ? true : false;

        boolean pick = false;
        if (k >= nums[n]) {
            pick = memoization(nums, k - nums[n], n - 1, dp);
        }
        boolean notPick = memoization(nums, k, n - 1, dp);

        boolean result = pick || notPick;

        dp[n][k] = (result) ? 2 : 1;

        return result;
    }

    // boolean dp[n][k+1]
    private boolean tabulation(int[] nums, int k, int n, boolean[][] dp) {
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        if (nums[0] <= k) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                boolean pick = false;
                if (nums[i] <= j) {
                    pick = dp[i - 1][j - nums[i]];
                }
                boolean notPick = dp[i - 1][j];

                dp[i][j] = pick || notPick;
            }
        }

        return dp[n][k];
    }

    private boolean spaceOptimization(int[] nums, int k, int n, boolean[] so) {

        if (nums[0] <= k) {
            so[nums[0]] = true;
        }
        so[0] = true;

        for (int i = 1; i <= n; i++) {
            boolean[] curr = new boolean[k + 1];
            curr[0] = true;
            for (int j = 1; j <= k; j++) {
                boolean pick = false;
                if (nums[i] <= j) {
                    pick = so[j - nums[i]];
                }
                boolean notPick = so[j];

                curr[j] = pick || notPick;
            }
            so = curr;
        }

        return so[k];
    }

}
