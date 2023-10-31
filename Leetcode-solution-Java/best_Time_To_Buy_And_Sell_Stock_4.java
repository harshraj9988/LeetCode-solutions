/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

Find the maximum profit you can achieve. You may complete at most k transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: k = 2, prices = [2,4,1]
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
Example 2:

Input: k = 2, prices = [3,2,6,5,0,3]
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 

Constraints:

0 <= k <= 100
0 <= prices.length <= 1000
0 <= prices[i] <= 1000
 */
public class best_Time_To_Buy_And_Sell_Stock_4 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

       int[][] dp = new int[2][k+1];
       

       return spaceOptimization(prices, n, k, dp);
   }
   
   // this problem is same as buy and sell stocks 3, only difference is that instead of hardcoding limit to 2, we are given a limit = k;
   private int spaceOptimization(int[] prices, int n, int limit, int[][] ahead) {
       for (int i = n - 1; i >= 0; i--) {
           int[][] curr = new int[2][limit+1];
           for (int j = 0; j < 2; j++) {
               for (int k = limit; k > 0; k--) {
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

       return ahead[1][limit];
   }
}
