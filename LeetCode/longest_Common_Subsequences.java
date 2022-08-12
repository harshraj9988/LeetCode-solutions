import java.util.Arrays;
import java.util.Scanner;

/**
 * Given two strings text1 and text2, return the length of their longest common
 * subsequence. If there is no common subsequence, return 0.
 * 
 * A subsequence of a string is a new string generated from the original string
 * with some characters (can be none) deleted without changing the relative
 * order of the remaining characters.
 * 
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both
 * strings.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 * 
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 * 
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 * 
 * 
 * Constraints:
 * 
 * 1 <= text1.length, text2.length <= 1000
 * text1 and text2 consist of only lowercase English characters
 */
public class longest_Common_Subsequences {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n+1][m+1];
  
        return tabulation(text1.toCharArray(), text2.toCharArray(), n, m, dp);
    }

    //initialize the dp with -1
    private int recursion(char[] S1, char[] S2, int ind1, int ind2) {
        if (ind1 < 0 || ind2 < 0)
            return 0;

        if (S1[ind1] == S2[ind2]) {
            return 1 + recursion(S1, S2, ind1 - 1, ind2 - 1);
        } else {
            return Math.max(
                    recursion(S1, S2, ind1 - 1, ind2),
                    recursion(S1, S2, ind1, ind2 - 1));
        }
    }

    private int memoization(char[] S1, char[] S2, int ind1, int ind2, int[][] dp) {
        if (ind1 < 0 || ind2 < 0)
            return 0;

        if (dp[ind1][ind2] != -1)
            return dp[ind1][ind2];

        if (S1[ind1] == S2[ind2]) {
            return dp[ind1][ind2] = 1 + memoization(S1, S2, ind1 - 1, ind2 - 1, dp);
        } else {
            return dp[ind1][ind2] = Math.max(
                    memoization(S1, S2, ind1 - 1, ind2, dp),
                    memoization(S1, S2, ind1, ind2 - 1, dp));
        }
    }

    private int tabulation(char[] S1, char[] S2, int n, int m, int[][] dp){
       
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(S1[i-1]==S2[j-1]) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[n][m];
    }

    private int spaceOptimization(char[] S1, char[] S2, int n , int m, int[] prev ){

        for(int i = 0; i < n; i++){
        int[] curr = new int[m];
            for(int j =0; j< m; j++){
                if(S1[i]==S2[j]) curr[j] = 1 + (((i>0)&&(j>0))?(prev[j-1]):0);
                else curr[j] = Math.max((i>0)?prev[j]:0, (j>0)?curr[j-1]:0);
            }
            prev = curr;
        }
        return prev[m-1];
    }

    private void printLCS(int[][] dp, char[] s1, char[] s2, int i, int j){
        StringBuilder sb = new StringBuilder();

        while(i>0 && j>0){
            if(s1[i-1]==s2[j-1]){
                sb.append(s1[i-1]);
                i--; j--;
            }else if (dp[i-1][j]>dp[i][j-1]) {
                i--;
            }else {
                j--;
            }
        }
        System.out.println();
        System.out.println(sb.reverse().toString());
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text1 = input.next();
        String text2 = input.next();
        int lcs = new longest_Common_Subsequences().longestCommonSubsequence(text1, text2);
        System.out.println();
        System.out.println(lcs);
    }
}
