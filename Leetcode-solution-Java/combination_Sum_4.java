import java.util.Arrays;

/**
 * Given an array of distinct integers nums and a target integer target, return
 * the number of possible combinations that add up to target.
 * 
 * The test cases are generated so that the answer can fit in a 32-bit integer.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3], target = 4
 * Output: 7
 * Explanation:
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * Note that different sequences are counted as different combinations.
 * Example 2:
 * 
 * Input: nums = [9], target = 3
 * Output: 0
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 1000
 * All the elements of nums are unique.
 * 1 <= target <= 1000
 * 
 * 
 * Follow up: What if negative numbers are allowed in the given array? How does
 * it change the problem? What limitation we need to add to the question to
 * allow negative numbers?
 * 
 * Accepted
 * 267,333
 * Submissions
 * 533,411
 */
public class combination_Sum_4 {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][target + 1];

        return tabulation(nums, n, target, dp);
    }

    private int recursion(int[] nums, int n, int k, int i) {
        if (k == 0)
            return 1;
        int allCombinations = 0;

        for (int j = 0; j < n; j++) {
            int num = nums[j];
            if (num <= k) {
                allCombinations += recursion(nums, n, k - num, j);
            }

        }
        return allCombinations;
    }

    private int memoization(int[] nums, int n, int k, int i, int[][] dp) {
        if (k == 0)
            return 1;

        int allCombinations = 0;

        if (dp[i][k] != -1)
            return dp[i][k];

        for (int j = 0; j < n; j++) {
            int num = nums[j];
            if (num <= k) {
                allCombinations += memoization(nums, n, k - num, j, dp);
            }
        }
        return dp[i][k] = allCombinations;
    }

    private int tabulation(int[] nums, int n, int k, int[][] dp) {
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= k; j++) {
                int allCombinations = 0;
                for (int l = 0; l < n; l++) {
                    int num = nums[l];
                    if (num <= j) {
                        allCombinations += dp[i][j - num];
                    }
                }
                dp[i][j] = allCombinations;
            }
        }

        return dp[0][k];
    }

    private int spaceOptimization(int[] nums, int n, int k, int[] curr) {

        curr[0] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= k; j++) {
                int allCombinations = 0;
                for (int l = 0; l < n; l++) {
                    int num = nums[l];
                    if (num <= j) {
                        allCombinations += curr[j - num];
                    }
                }
                curr[j] = allCombinations;
            }
        }



        return curr[k];
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        int target = 4;
        int ans = new combination_Sum_4().combinationSum4(nums, target);
        System.out.println(ans);
    }
}
