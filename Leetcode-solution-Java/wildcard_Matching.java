/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern
 * matching with support for '?' and '*' where:
 * 
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 * 
 * Input: s = "aa", p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 * Example 3:
 * 
 * Input: s = "cb", p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not
 * match 'b'.
 * 
 * 
 * Constraints:
 * 
 * 0 <= s.length, p.length <= 2000
 * s contains only lowercase English letters.
 * p contains only lowercase English letters, '?' or '*'.
 */
public class wildcard_Matching {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n+1][m+1];

        return tabulation(s.toCharArray(), p.toCharArray(), n , m , dp);
    }

    private boolean recursion(char[] s, char[] p, int i, int j) {
        if(i<0 && j<0) return true;
        if(j<0 && i>=0) return false;
        if(i<0 && j>=0){
            for(; j>=0; j--){
                if(p[j]!='*') return false;
            }
            return true;
        }

        if(s[i]==p[j] || p[j]=='?'){
            return recursion(s, p, i-1, j-1);
        }
        if(p[j]=='*'){
            boolean notTake = recursion(s, p, i, j-1);
            boolean take = recursion(s, p, i-1, j);

            return take || notTake;
        }
        return false;
    }

    private boolean memoization(char[] s, char[] p, int i, int j, int[][] dp) {
        if(i<0 && j<0) return true;
        if(j<0 && i>=0) return false;
        if(i<0 && j>=0){
            for(; j>=0; j--){
                if(p[j]!='*') return false;
            }
            return true;
        }

        if(dp[i][j]!=0) return dp[i][j]==2;

        if(s[i]==p[j] || p[j]=='?'){
            boolean matched = memoization(s, p, i-1, j-1, dp);
            dp[i][j] = (matched)? 2: 1;
            return matched ;
        }
        if(p[j]=='*'){
            boolean notTake = memoization(s, p, i, j-1, dp);
            boolean take = memoization(s, p, i-1, j, dp);

            boolean eitherTrue = take || notTake; 
            dp[i][j] = (eitherTrue)? 2: 1;
            return  eitherTrue;
        }
        dp[i][j] = 1;
        return false;
    }

    private boolean tabulation(char[] s, char[] p, int n, int m, boolean[][] dp) {

        dp[0][0] = true;
        for (int j = 1; j <= m; j++) {
            boolean flag = true;
            for(int i = j-1; i>=0; i--){
                if(p[i]!='*'){
                    flag = false;
                    break;
                }
            }
            dp[0][j] = flag;
        }
        
        for(int i=1; i<=n ; i++){
            for (int j = 1; j <= m; j++) {
                if(s[i-1]==p[j-1] || p[j-1]=='?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p[j-1]=='*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }

    private boolean spaceOptimization(char[] s, char[] p, int n, int m, boolean[] prev) {

        prev[0] = true;
        for (int j = 1; j <= m; j++) {
            boolean flag = true;
            for(int i = j-1; i>=0; i--){
                if(p[i]!='*'){
                    flag = false;
                    break;
                }
            }
            prev[j] = flag;
        }
        
        for(int i=1; i<=n ; i++){
            boolean[] curr = new boolean[m+1]; 
            for (int j = 1; j <= m; j++) {
                if(s[i-1]==p[j-1] || p[j-1]=='?'){
                    curr[j] = prev[j-1];
                }else if(p[j-1]=='*'){
                    curr[j] = curr[j-1] || prev[j];
                } else {
                    curr[j] = false;
                }
            }
            prev = curr;
        }

        return prev[m];
    }
}
