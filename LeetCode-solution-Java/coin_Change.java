import java.util.Arrays;

/**
 * You are given an integer array coins representing coins of different
 * denominations and an integer amount representing a total amount of money.
 * 
 * Return the fewest number of coins that you need to make up that amount. If
 * that amount of money cannot be made up by any combination of the coins,
 * return -1.
 * 
 * You may assume that you have an infinite number of each kind of coin.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 * 
 * Input: coins = [2], amount = 3
 * Output: -1
 * Example 3:
 * 
 * Input: coins = [1], amount = 0
 * Output: 0
 * 
 * 
 * Constraints:
 * 
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 */
public class coin_Change {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;

        int n = coins.length;

        int[] dp = new int[amount + 1];
       

        int minCoin = spaceOptimization(coins, amount, n, dp);

        return (minCoin > 10000) ? -1 : minCoin;
    }

    private int recursion(int[] coins, int amount, int n) {
        if(amount==0) return 0;
        if (n==0){
            if(amount%coins[0]!=0) return 10000;
            else return amount/coins[0];
        }
        


        int notTake = recursion(coins, amount, n-1);
        int take = Integer.MAX_VALUE;
        if(amount>=coins[n]){
            take = 1 + recursion(coins, amount-coins[n], n);
        }
        return Math.min(notTake, take);
    }

    private int memoization(int[] coins, int amount, int n, int[][] dp) {
        if(amount==0) return 0;
        if (n==0){
            if(amount%coins[0]!=0) return 100000;
            else return amount/coins[0];
        }

        if(dp[n][amount]!=-1) return dp[n][amount];

        int notTake = memoization(coins, amount, n-1, dp);
        int take = Integer.MAX_VALUE;
        if(amount>=coins[n]){
            take = 1 + memoization(coins, amount-coins[n], n, dp);
        }
        return dp[n][amount]=Math.min(notTake, take);
    }

    private int tabulation(int[] coins, int amount, int n, int[][] dp){
        for(int i=0; i<=amount; i++){
            if(i%coins[0]==0) dp[0][i] = i/coins[0];
            else dp[0][i] = 100000;
        }

        for(int i =1; i< n; i++){
            for (int j = 0; j <= amount; j++) {
                int notTake = dp[i-1][j];
                int take = 100000;
                if(j>=coins[i]){
                    take = 1+dp[i][j-coins[i]];
                }
                dp[i][j] = Math.min(take, notTake);
            }
        }

        return dp[n-1][amount];
    }

    private int spaceOptimization(int[] coins, int amount, int n, int[] dp){
        for(int i=0; i<=amount; i++){
            if(i%coins[0]==0) dp[i] = i/coins[0];
            else dp[i] = 100000;
        }

        for(int i =1; i< n; i++){
            int[] curr = new int[amount+1];
            for (int j = 0; j <= amount; j++) {
                int notTake = dp[j];
                int take = 100000;
                if(j>=coins[i]){
                    take = 1+curr[j-coins[i]];
                }
                curr[j] = Math.min(take, notTake);
            }
            dp = curr;
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        int amount = 11;

        System.out.println(
        Arrays.binarySearch(coins, 0, 3, 5)
        );
        int ans = new coin_Change().coinChange(coins, amount);
        System.out.println(ans);
    }
}
