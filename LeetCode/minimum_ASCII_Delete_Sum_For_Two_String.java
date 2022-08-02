import java.util.Arrays;

/**
 * Given two strings s1 and s2, return the lowest ASCII sum of deleted
 * characters to make two strings equal.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s1 = "sea", s2 = "eat"
 * Output: 231
 * Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the
 * sum.
 * Deleting "t" from "eat" adds 116 to the sum.
 * At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum
 * possible to achieve this.
 * Example 2:
 * 
 * Input: s1 = "delete", s2 = "leet"
 * Output: 403
 * Explanation: Deleting "dee" from "delete" to turn the string into "let",
 * adds 100[d] + 101[e] + 101[e] to the sum.
 * Deleting "e" from "leet" adds 101[e] to the sum.
 * At the end, both strings are equal to "let", and the answer is
 * 100+101+101+101 = 403.
 * If instead we turned both strings into "lee" or "eet", we would get answers
 * of 433 or 417, which are higher.
 * 
 * 
 * Constraints:
 * 
 * 1 <= s1.length, s2.length <= 1000
 * s1 and s2 consist of lowercase English letters.
 */
public class minimum_ASCII_Delete_Sum_For_Two_String {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return memoization(s1.toCharArray(), s2.toCharArray(), n-1, m-1, dp);
    }

    private int memoization(char[] s1, char[] s2, int i, int j, int[][] dp) {
        if (i < 0 || j < 0){
            if(i<0 && j<0) return 0;
            else return (i<0)? remainingSum(s2, j): remainingSum(s1, i);
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        if (s1[i] == s2[j]) {
            return dp[i][j] = memoization(s1, s2, i - 1, j - 1, dp);
        } else {
            return dp[i][j] = Math.min(
                    (s1[i] + memoization(s1, s2, i - 1, j, dp)),
                    (s2[j] + memoization(s1, s2, i, j - 1, dp)));
        }
    }

    private int remainingSum(char[] s, int i){
        int ans = 0;
        while(i>=0){
            ans+=s[i];
            i--;
        }
        return ans;
    }
}
