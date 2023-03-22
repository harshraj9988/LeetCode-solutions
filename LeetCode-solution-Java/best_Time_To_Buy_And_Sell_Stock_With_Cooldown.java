/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:

After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: prices = [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]
Example 2:

Input: prices = [1]
Output: 0
 

Constraints:

1 <= prices.length <= 5000
0 <= prices[i] <= 1000
 */
public class best_Time_To_Buy_And_Sell_Stock_With_Cooldown {
    public int maxProfit(int[] prices) {
        int n = prices.length;
       int[] dp = new int[2];
      
       
       return spaceOptimization(prices, n, dp);
   }
   
   private int memoization(int[] prices, int i, int n, int buy, int[][] dp){
       if(i>=n) return 0;
       
       if(dp[buy][i]!=-1) return dp[buy][i];
       
       
       if(buy==1){
           return dp[buy][i] = Math.max(
               (-prices[i]+memoization(prices, i+1, n, 0, dp)),
               memoization(prices, i+1, n, 1, dp)
           );
       } else {
           return dp[buy][i] = Math.max(
               (prices[i]+memoization(prices, i+2, n, 1, dp)),
               memoization(prices, i+1, n, 0, dp)
               );
       }
   }
   
   private int spaceOptimization(int[] prices, int n, int[] ahead){
       int[] ahead2 = new int[2];
       for(int i = n-1; i>=0; i--){
           int[] curr = new int[2];
           for(int j = 0; j<2; j++){
               if(j==1){
                   curr[j] = Math.max((-prices[i]+ahead[0]), ahead[1]);
               }else{
                   curr[j] = Math.max((prices[i]+ahead2[1]), ahead[0]);
               }
           }
           ahead2 = ahead;
           ahead = curr;
       }
       
       return ahead[1];
   }
}
