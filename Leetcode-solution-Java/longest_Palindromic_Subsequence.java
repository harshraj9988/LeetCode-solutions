
public class longest_Palindromic_Subsequence {
    public int longestPalindromeSubseq(String s) {
        return spaceOptimization(s.toCharArray());
    }

    private int recursion(char[] s, int ind1, int ind2, int n) {
        if(ind1<0 || ind2<0) return 0;


        if(s[ind1] == s[n-ind2-1]) return 1 + recursion(s, ind1-1, ind2-1, n);
        else 
            return Math.max(
                recursion(s, ind1-1, ind2, n),
                recursion(s, ind1, ind2-1, n)
            ); 
    }
    
    private int memoization(char[] s, int ind1, int ind2, int n, int[][] dp){
        if(ind1<0 || ind2<0) return 0;

        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];

        if(s[ind1] == s[n-ind2-1]) return dp[ind1][ind2] = 1 + memoization(s, ind1-1, ind2-1, n, dp);
        else 
            return dp[ind1][ind2] = Math.max(
                memoization(s, ind1-1, ind2, n, dp),
                memoization(s, ind1, ind2-1, n, dp)
            ); 
    }

    private int tabulation(char[] s){
        int n = s.length;
        int[][] dp = new int[n+1][n+1];
        
        for(int i =1; i<=n ;i++){
            for(int j=1; j<=n; j++){
                if(s[i-1]==s[n-j]) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        return dp[n][n];
    }

    private int spaceOptimization(char[] s){
        int n = s.length;
        int[] prev = new int[n+1];
        
        for(int i =1; i<=n ;i++){
            int[] curr = new int[n+1];
            for(int j=1; j<=n; j++){
                if(s[i-1]==s[n-j]) curr[j] = 1 + prev[j-1];
                else curr[j] = Math.max(prev[j], curr[j-1]);
            }
            prev = curr;
        }
        
        return prev[n];
    }
}
