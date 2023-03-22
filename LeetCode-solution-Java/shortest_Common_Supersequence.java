/**
 * Given two strings str1 and str2, return the shortest string that has both
 * str1 and str2 as subsequences. If there are multiple valid strings, return
 * any of them.
 * 
 * A string s is a subsequence of string t if deleting some number of characters
 * from t (possibly 0) results in the string s.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: str1 = "abac", str2 = "cab"
 * Output: "cabac"
 * Explanation:
 * str1 = "abac" is a subsequence of "cabac" because we can delete the first
 * "c".
 * str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
 * The answer provided is the shortest such string that satisfies these
 * properties.
 * Example 2:
 * 
 * Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa"
 * Output: "aaaaaaaa"
 * 
 * 
 * Constraints:
 * 
 * 1 <= str1.length, str2.length <= 1000
 * str1 and str2 consist of lowercase English letters.
 */
public class shortest_Common_Supersequence {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        return tabulation(str1.toCharArray(), str2.toCharArray(), n, m, dp);
    }

    // int dp[][] = new int[n+1][m+1], n = S1.length, m = S2.length
    private String tabulation(char[] S1, char[] S2, int n, int m, int[][] dp) {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (S1[i - 1] == S2[j - 1])
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        String sss = getTheShortestSuperSequence(dp, S1, S2, n, m);

        return sss;
    }

    private String getTheShortestSuperSequence(int[][] dp, char[] S1, char[] S2, int n, int m) {
        StringBuilder sb = new StringBuilder();
        while (n > 0 && m > 0) {
            if (S1[n - 1] == S2[m - 1]) {
                sb.append(S1[n - 1]);
                n--; m--;
            } else if (dp[n - 1][m] > dp[n][m - 1]) {
                sb.append(S1[n - 1]);
                n--;
            } else {
                sb.append(S2[m - 1]);
                m--;
            }
        }
        while (n > 0) {
            sb.append(S1[n - 1]);
            n--;
        }
        while (m > 0) {
            sb.append(S2[m - 1]);
            m--;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String str1 = "abac";
        String str2 = "cab";

        System.out.println(new shortest_Common_Supersequence().shortestCommonSupersequence(str1, str2));
    }
}
