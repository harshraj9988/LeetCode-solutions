/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.

 

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.
Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
 

Constraints:

1 <= prices.length <= 3 * 104
0 <= prices[i] <= 104
 */
public class best_Time_To_Buy_And_Sell_Stock_2 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[2];
                
        return spaceOptimization(prices, n, dp);
    }
    
    private int recursion(int[] prices, int i, int n, int buy){
        if(i==n) return 0;
        
        if(buy==1){
            return Math.max(
                (-prices[i]+recursion(prices, i+1, n, 0)),
                recursion(prices, i+1, n, 1)
            );
        } else {
            return Math.max(
                (prices[i]+recursion(prices, i, n, 1)),
                recursion(prices, i+1, n, 0)
                );
        }
    }
    
    private int memoization(int[] prices, int i, int n, int buy, int[][] dp){
        if(i==n) return 0;
        
        if(dp[buy][i]!=-1) return dp[buy][i];
        
        
        if(buy==1){
            return dp[buy][i] = Math.max(
                (-prices[i]+memoization(prices, i+1, n, 0, dp)),
                memoization(prices, i+1, n, 1, dp)
            );
        } else {
            return dp[buy][i] = Math.max(
                (prices[i]+memoization(prices, i, n, 1, dp)),
                memoization(prices, i+1, n, 0, dp)
                );
        }
    }
    
    private int tabulation(int[] prices, int n, int[][] dp){
        for(int i = n-1; i>=0; i--){
            for(int j = 0; j<2; j++){
                if(j==1){
                    dp[i][j] = Math.max((-prices[i]+dp[i+1][0]), dp[i+1][1]);
                }else{
                    dp[i][j] = Math.max((prices[i]+dp[i+1][1]), dp[i+1][0]);
                }
            }
        }
        
        return dp[0][1];
    }
    
    private int spaceOptimization(int[] prices, int n, int[] ahead){
        for(int i = n-1; i>=0; i--){
            int[] curr = new int[2];
            for(int j = 0; j<2; j++){
                if(j==1){
                    curr[j] = Math.max((-prices[i]+ahead[0]), ahead[1]);
                }else{
                    curr[j] = Math.max((prices[i]+ahead[1]), ahead[0]);
                }
            }
            ahead = curr;
        }
        
        return ahead[1];
    }
}
