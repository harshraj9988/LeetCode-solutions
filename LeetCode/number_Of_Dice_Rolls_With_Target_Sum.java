
/**

*/

import java.util.*;
import java.io.*;

class Solution {
    long mod = 1000000007;

    public int numRollsToTarget(int n, int k, int target) {
        return (int) spaceOptimization(n, k, target);
    }

    private long recursion(int n, int k, int t) {
        if (n == 0) {
            return (t == 0) ? 1 : 0;
        }
        long x = 0;
        for (int i = 1; i <= k; i++) {
            if (i <= t) {
                x += recursion(n - 1, k, t - i);
            }
        }
        return x % mod;
    }

    private long memoization(int n, int k, int t, long[][] dp) {
        if (n == 0) {
            return (t == 0) ? 1 : 0;
        }

        if (dp[n][t] != -1)
            return dp[n][t];

        long x = 0;
        for (int i = 1; i <= k; i++) {
            if (i <= t) {
                x += memoization(n - 1, k, t - i, dp);
            }
        }
        return dp[n][t] = x % mod;
    }

    private long tabulation(int n, int k, int t, long[][] dp) {

        dp[0][0] = 1;

        for(int i = 1; i<=n; i++){
            for(int j=0; j<=t; j++){
                long x = 0;
                for (int l = 1; l <= k; l++) {
                    if (l <= j) {
                        x += dp[i-1][j-l];
                    }
                }
                dp[i][j] = x % mod;
            }
        }
        return dp[n][t]%mod;
    }

    private long spaceOptimization(int n, int k, int t) {
        long[] prev = new long[t+1];
        prev[0] = 1;

        for(int i = 1; i<=n; i++){
            long[] curr = new long[t+1];
            for(int j=0; j<=t; j++){
                long x = 0;
                for (int l = 1; l <= k; l++) {
                    if (l <= j) {
                        x += prev[j-l];
                    }
                }
                curr[j] = x % mod;
            }
            prev = curr;
        }
        return prev[t]%mod;
    }
}

public class number_Of_Dice_Rolls_With_Target_Sum {
    public static void main(String[] args) {
        int n = 30, k = 30, target = 500;
        System.out.println(new Solution().numRollsToTarget(n, k, target));
    }
}