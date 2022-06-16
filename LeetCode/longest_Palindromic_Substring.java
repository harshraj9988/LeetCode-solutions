/**
 * Given a string s, return the longest palindromic substring in s.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 * 
 * Input: s = "cbbd"
 * Output: "bb"
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */

public class longest_Palindromic_Substring {

    public String longestPalindrome(String s) {
        int len = s.length();
        String ans = null;

        boolean[][] check = new boolean[len][len];

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                check[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || check[i + 1][j - 1]);

                if (check[i][j] && (ans == null || j - i + 1 > ans.length())) {
                    ans = s.substring(i, j + 1);
                }
            }
        }

        return ans;
    }

}
