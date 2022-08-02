import java.util.Arrays;

/**
 * Given two strings s and t, return the number of distinct subsequences of s which equals t.

A string's subsequence is a new string formed from the original string by deleting some (can be none) of the characters without disturbing the remaining characters' relative positions. (i.e., "ACE" is a subsequence of "ABCDE" while "AEC" is not).

The test cases are generated so that the answer fits on a 32-bit signed integer.

 

Example 1:

Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from S.
rabbbit
rabbbit
rabbbit
Example 2:

Input: s = "babgbag", t = "bag"
Output: 5
Explanation:
As shown below, there are 5 ways you can generate "bag" from S.
babgbag
babgbag
babgbag
babgbag
babgbag
 

Constraints:

1 <= s.length, t.length <= 1000
s and t consist of English letters.
 */
public class distinct_Subsequence {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[] prev = new int[m+1];
        
        return spaceOptimization(s.toCharArray(), t.toCharArray(), n , m, prev);
    }

    // i = s.length -1, j = t.length-1
    private int recursion(char[] s, char[] t, int i, int j){
        if(j<0) return 1;
        if(i<0) return 0;

        if(s[i]==t[j]){

            return recursion(s, t, i-1, j-1) + recursion(s, t, i-1, j);

        }else{
            return recursion(s, t, i-1, j);
        }
    }

    // i = s.length -1, j = t.length-1, dp[][] = new int[s.length][t.length] {-1}
    private int memoization(char[] s, char[] t, int i, int j, int[][] dp){
        if(j<0) return 1;
        if(i<0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(s[i]==t[j]){
            return dp[i][j] = memoization(s, t, i-1, j-1, dp) + memoization(s, t, i-1, j, dp);
        } else {
            return dp[i][j] = memoization(s, t, i-1, j, dp);
        }
    }

    // dp[][] = new int[s.length+1][t.length+1], n = s.length, m = t.length
     private int tabulation(char[] s, char[] t, int n, int m, int[][] dp){

        for(int i = 0; i<= n; i++){
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(s[i-1]==t[j-1]){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][m];
    }

    // prev[] = new int[t.length+1], n = s.length, m = t.length
    private int spaceOptimization(char[] s, char[] t, int n, int m, int[] prev){

        prev[0] = 1;

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m+1];
            curr[0] = 1;
            for (int j = 1; j <= m; j++) {
                if(s[i-1]==t[j-1]){
                    curr[j] = prev[j] + prev[j-1];
                }else{
                    curr[j] = prev[j];
                }
            }
            prev = curr;
        }

        return prev[m];
    }

}
