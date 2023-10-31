
/**
 * You are given an integer array coins representing coins of different
 * denominations and an integer amount representing a total amount of money.
 * 
 * Return the number of combinations that make up that amount. If that amount of
 * money cannot be made up by any combination of the coins, return 0.
 * 
 * You may assume that you have an infinite number of each kind of coin.
 * 
 * The answer is guaranteed to fit into a signed 32-bit integer.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: amount = 5, coins = [1,2,5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * Example 2:
 * 
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 * Example 3:
 * 
 * Input: amount = 10, coins = [10]
 * Output: 1
 * 
 * 
 * Constraints:
 * 
 * 1 <= coins.length <= 300
 * 1 <= coins[i] <= 5000
 * All the values of coins are unique.
 * 0 <= amount <= 5000
 */
public class coin_Change_2 {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[] dp = new int[amount + 1];

        return spaceOptimization(coins, amount, n, dp);
    }

    private int recursion(int[] coins, int amount, int n) {
        if (amount == 0)
            return 1;
        if (n == 1) {

            if (amount % coins[0] == 0)
                return 1;

            return 0;
        }

        int notPick = recursion(coins, amount, n - 1);
        int pick = 0;
        if (amount >= coins[n - 1]) {
            pick = recursion(coins, amount - coins[n - 1], n);
        }
        return notPick + pick;
    }

    // initialize the dp with -1;
    private int memoization(int[] coins, int amount, int n, int[][] dp) {
        if (amount == 0)
            return 1;

        if (n == 1) {
            if (amount % coins[0] == 0)
                return 1;
            return 0;
        }

        if (dp[n - 1][amount] != -1)
            return dp[n - 1][amount];

        int notPick = memoization(coins, amount, n - 1, dp);
        int pick = 0;
        if (amount >= coins[n - 1]) {
            pick = memoization(coins, amount - coins[n - 1], n, dp);
        }

        return dp[n - 1][amount] = notPick + pick;
    }

    private int tabulation (int[] coins, int amount, int n, int[][] dp){

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for(int i=1; i<= amount; i++){
            if(i%coins[0]==0) dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= amount; j++) {
                int notPick = dp[i-1][j];
                int pick = 0;
                if(j>=coins[i]) pick = dp[i][j-coins[i]];
                dp[i][j] = notPick + pick;
            }
        }

        return dp[n-1][amount];
    }

    private int spaceOptimization (int[] coins, int amount, int n, int[] prev){

        prev[0] = 1;

        for(int i=1; i<= amount; i++){
            if(i%coins[0]==0) prev[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            int[] curr = new int[amount+1];
            
            curr[0]  = 1;

            for (int j = 1; j <= amount; j++) {
                int notPick = prev[j];
                int pick = 0;
                if(j>=coins[i]) pick = curr[j-coins[i]];
                curr[j] = notPick + pick;
            }

            prev = curr;
        }

        return prev[amount];
    }
}
