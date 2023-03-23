import java.util.Arrays;

/**
 * Given two strings word1 and word2, return the minimum number of operations
 * required to convert word1 to word2.
 * 
 * You have the following three operations permitted on a word:
 * 
 * Insert a character
 * Delete a character
 * Replace a character
 * 
 * 
 * Example 1:
 * 
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 * 
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 * 
 * 
 * Constraints:
 * 
 * 0 <= word1.length, word2.length <= 500
 * word1 and word2 consist of lowercase English letters.
 */
public class edit_Distance {
    public int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return memoization(word1.toCharArray(), word2.toCharArray(), n - 1, m - 1, n, m, dp);
    }

    // i = n-1, j = m-1, n = S1.length, m = S2.length
    private int recursion(char[] S1, char[] S2, int i, int j, int n, int m) {
        if (j < 0) {
            if (i < 0)
                return 0;
            else
                return i + 1;
        }
        if (i < 0) {
            return j + 1;
        }

        if (S1[i] == S2[j])
            return recursion(S1, S2, i - 1, j - 1, n, m);
        else {
            int remove = 1 + recursion(S1, S2, i - 1, j, n, m);
            int replace = 1 + recursion(S1, S2, i - 1, j - 1, n, m);
            int insert = 1 + recursion(S1, S2, i, j - 1, n, m);

            return Math.min(Math.min(remove, replace), insert);
        }
    }

    // i = n-1, j = m-1, n = S1.length, m = S2.length, dp[][] = new int[n][m] {-1}
    private int memoization(char[] S1, char[] S2, int i, int j, int n, int m, int[][] dp) {
        if (j < 0) {
            return i + 1;
        }
        if (i < 0) {
            return j + 1;
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        if (S1[i] == S2[j])
            return dp[i][j] = memoization(S1, S2, i - 1, j - 1, n, m, dp);
        else {
            int remove = 1 + memoization(S1, S2, i - 1, j, n, m, dp);
            int replace = 1 + memoization(S1, S2, i - 1, j - 1, n, m, dp);
            int insert = 1 + memoization(S1, S2, i, j - 1, n, m, dp);

            return dp[i][j] = Math.min(Math.min(remove, replace), insert);
        }
    }

    // n = S1.length, m = S2.length, dp[][] = new int[n+1][m+1] (for shifting
    // indiices by 1 to handle base cases)
    private int tabulation(char[] S1, char[] S2, int n, int m, int[][] dp) {
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (S1[i - 1] == S2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1];
                else {
                    int remove = 1 + dp[i - 1][j];
                    int replace = 1 + dp[i - 1][j - 1];
                    int insert = 1 + dp[i][j - 1];

                    dp[i][j] = Math.min(Math.min(remove, replace), insert);
                }
            }
        }
        return dp[n][m];
    }

    // n = S1.length, m = S2.length, prev[] = new int[m+1] (for shifting
    // indiices by 1 to handle base cases)
    private int spaceOptimization(char[] S1, char[] S2, int n, int m, int[] prev) {
        for (int j = 0; j <= m; j++) {
            prev[j] = j;
        }



        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m+1];
            curr[0]=i;
            for (int j = 1; j <= m; j++) {
                if (S1[i - 1] == S2[j - 1])
                    curr[j] = prev[j - 1];
                else {
                    int remove = prev[j];
                    int replace = prev[j - 1];
                    int insert = curr[j - 1];

                    curr[j] = 1 + Math.min(Math.min(remove, replace), insert);
                }
            }
            prev = curr;
        }
        return prev[m];
    }
    
}
