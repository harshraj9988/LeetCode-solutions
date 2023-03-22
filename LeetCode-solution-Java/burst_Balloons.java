import java.util.Arrays;

/**
 * You are given n balloons, indexed from 0 to n - 1. Each balloon is painted
 * with a number on it represented by an array nums. You are asked to burst all
 * the balloons.
 * 
 * If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i +
 * 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as
 * if there is a balloon with a 1 painted on it.
 * 
 * Return the maximum coins you can collect by bursting the balloons wisely.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [3,1,5,8]
 * Output: 167
 * Explanation:
 * nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
 * coins = 3*1*5 + 3*5*8 + 1*3*8 + 1*8*1 = 167
 * Example 2:
 * 
 * Input: nums = [1,5]
 * Output: 10
 * 
 * 
 * Constraints:
 * 
 * n == nums.length
 * 1 <= n <= 300
 * 0 <= nums[i] <= 100
 */
public class burst_Balloons {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            newNums[i] = nums[i - 1];
        }
        return tabulation(newNums, n, dp);
    }

    private int recursion(int[] nums, int i, int j) {
        if (i > j)
            return 0;

        int maxCoins = Integer.MIN_VALUE;
        for (int ind = i; ind <= j; ind++) {
            int coins = nums[i - 1] * nums[ind] * nums[j + 1] + recursion(nums, i, ind - 1)
                    + recursion(nums, ind + 1, j);
            maxCoins = Math.max(maxCoins, coins);
        }
        return maxCoins;
    }

    private int memoization(int[] nums, int i, int j, int[][] dp) {
        if (i > j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int maxCoins = Integer.MIN_VALUE;
        for (int ind = i; ind <= j; ind++) {
            int coins = nums[i - 1] * nums[ind] * nums[j + 1] + memoization(nums, i, ind - 1, dp)
                    + memoization(nums, ind + 1, j, dp);
            maxCoins = Math.max(maxCoins, coins);
        }
        return dp[i][j] = maxCoins;
    }

    private int tabulation(int[] nums, int n, int[][] dp) {
        for (int i = n; i >= 1; i--) {
            for (int j = i; j <= n ; j++) {
                int maxCoins = Integer.MIN_VALUE;
                for (int ind = i; ind <= j; ind++) {
                    int coins = nums[i - 1] * nums[ind] * nums[j + 1] + dp[i][ind-1]
                            + dp[ind + 1][j];
                    maxCoins = Math.max(maxCoins, coins);
                }
                dp[i][j] = maxCoins;
            }
        }

        return dp[1][n];
    }
}
