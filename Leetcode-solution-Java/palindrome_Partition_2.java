import java.util.Arrays;

/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1
 * cut.
 * Example 2:
 * 
 * Input: s = "a"
 * Output: 0
 * Example 3:
 * 
 * Input: s = "ab"
 * Output: 1
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 2000
 * s consists of lowercase English letters only.
 */
public class palindrome_Partition_2 {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        return tabulation(s, n, dp)-1;
    }

    private int recursion(String s, int i, int n) {
        if (i == n)
            return 0;
        int minCost = Integer.MAX_VALUE;
        for (int j = i; j < n; j++) {
            if (isPalindrome(s, i, j)) {
                int cost = 1 + recursion(s, j + 1, n);
                minCost = Math.min(minCost, cost);
            }
        }
        return minCost;
    }

    private int memoization(String s, int i, int n, int[] dp) {
        if (i == n)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        int minCost = Integer.MAX_VALUE;
        for (int j = i; j < n; j++) {
            if (isPalindrome(s, i, j)) {
                int cost = 1 + memoization(s, j + 1, n, dp);
                minCost = Math.min(minCost, cost);
            }
        }
        return dp[i] = minCost;
    }

    private int tabulation(String s, int n, int[] dp) {
        for (int i = n - 1; i >= 0; i--) {
            int minCost = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j)) {
                    int cost = 1 + dp[j + 1];
                    minCost = Math.min(minCost, cost);
                }
            }
            dp[i] = minCost;
        }
        return dp[0];
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
