import java.util.Arrays;

/**
 * You are given an array prices where prices[i] is the price of a given stock
 * on the ith day.
 * 
 * Find the maximum profit you can achieve. You may complete at most two
 * transactions.
 * 
 * Note: You may not engage in multiple transactions simultaneously (i.e., you
 * must sell the stock before you buy again).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: prices = [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit =
 * 3-0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 =
 * 3.
 * Example 2:
 * 
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit =
 * 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you
 * are engaging multiple transactions at the same time. You must sell before
 * buying again.
 * Example 3:
 * 
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * 
 * 
 * Constraints:
 * 
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 105
 */
public class best_Time_To_Buy_And_Sell_Stock_3 {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[2][3];
        

        return spaceOptimization(prices, n,  dp);
    }

    private int recursion(int[] prices, int i, int n, int buy, int limit) {
        if (i == n || limit == 0)
            return 0;

        if (buy == 1) {
            return Math.max(
                    (-prices[i] + recursion(prices, i + 1, n, 0, limit)),
                    recursion(prices, i + 1, n, 1, limit));
        } else {
            return Math.max(
                    (prices[i] + recursion(prices, i, n, 1, limit - 1)),
                    recursion(prices, i + 1, n, 0, limit));
        }
    }

    private int memoization(int[] prices, int i, int n, int buy, int limit, int[][][] dp) {
        if (i == n || limit == 0)
            return 0;

        if (dp[i][buy][limit] != -1)
            return dp[i][buy][limit];

        if (buy == 1) {
            return dp[i][buy][limit] = Math.max(
                    (-prices[i] + memoization(prices, i + 1, n, 0, limit, dp)),
                    memoization(prices, i + 1, n, 1, limit, dp));
        } else {
            return dp[i][buy][limit] = Math.max(
                    (prices[i] + memoization(prices, i, n, 1, limit - 1, dp)),
                    memoization(prices, i + 1, n, 0, limit, dp));
        }
    }

    private int tabulation(int[] prices, int n, int[][][] dp) {
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++)
                for (int k = 2; k > 0; k--) {
                    {
                        if (j == 1) {
                            dp[i][j][k] = Math.max((-prices[i] + dp[i + 1][0][k]), dp[i + 1][1][k]);
                        } else {
                            dp[i][j][k] = Math.max((prices[i] + dp[i + 1][1][k - 1]), dp[i + 1][0][k]);
                        }
                    }
                }
        }

        return dp[0][1][2];
    }

    private int spaceOptimization(int[] prices, int n, int[][] ahead) {
        for (int i = n - 1; i >= 0; i--) {
            int[][] curr = new int[2][3];
            for (int j = 0; j < 2; j++) {
                for (int k = 2; k > 0; k--) {
                    {
                        if (j == 1) {
                            curr[j][k] = Math.max((-prices[i] + ahead[0][k]), ahead[1][k]);
                        } else {
                            curr[j][k] = Math.max((prices[i] + ahead[1][k - 1]), ahead[0][k]);
                        }
                    }
                }
            }
            ahead = curr;
        }

        return ahead[1][2];
    }

}
