
/**
A message containing letters from A-Z can be encoded into numbers using the following mapping:

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:

"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)
Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

Given a string s containing only digits, return the number of ways to decode it.

The test cases are generated so that the answer fits in a 32-bit integer.

 

Example 1:

Input: s = "12"
Output: 2
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: s = "226"
Output: 3
Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
Example 3:

Input: s = "06"
Output: 0
Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
 

Constraints:

1 <= s.length <= 100
s contains only digits and may contain leading zero(s).
*/

import java.util.*;
import java.io.*;

class Solution {

    public int numDecodings(String s) {
        int n = s.length();
        return spaceOptimization(s.toCharArray(), n);
    }

    // i == s.length() - 1;
    private int recursion(char[] s, int i) {
        if (i < 0) {
            return 1;
        }
        int pickOne = 0;
        int pickTwo = 0;
        if (s[i] != '0') {
            pickOne = recursion(s, i - 1);
        }
        if ((i - 1) >= 0 && ((s[i] <= '9' && s[i - 1] == '1') || (s[i] <= '6' && s[i - 1] == '2'))) {
            pickTwo = recursion(s, i - 2);
        }
        return pickOne + pickTwo;
    }

    //int[] dp = new int[s.length()]  dp[i] = -1 (0 <= i < s.length())
    private int memoization(char[] s, int i, int[] dp) {
        if (i < 0) {
            return 1;
        }
        if (dp[i] != -1)
            return dp[i];

        int pickOne = 0;
        int pickTwo = 0;
        if (s[i] != '0') {
            pickOne = memoization(s, i - 1, dp);
        }
        if ((i - 1) >= 0 && ((s[i] <= '9' && s[i - 1] == '1') || (s[i] <= '6' && s[i - 1] == '2'))) {
            pickTwo = memoization(s, i - 2, dp);
        }
        return dp[i] = pickOne + pickTwo;
    }

    //int[] dp = new int[s.length() + 2] , shift indices by 2 to handle base case
    private int tabulation(char[] s, int[] dp, int n) {
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 2; i++) {
            int pickOne = 0;
            int pickTwo = 0;
            if (s[i - 2] != '0') {
                pickOne = dp[i - 1];
            }
            if ((i - 1 - 2) >= 0
                    && ((s[i - 2] <= '9' && s[i - 1 - 2] == '1') || (s[i - 2] <= '6' && s[i - 1 - 2] == '2'))) {
                pickTwo = dp[i - 2];
            }
            dp[i] = pickOne + pickTwo;
        }

        return dp[n + 1];
    }

    private int spaceOptimization(char[] s, int n) {
        int last = 1;
        int secondLast = 1;
        for (int i = 2; i < n + 2; i++) {
            int pickOne = 0;
            int pickTwo = 0;
            if (s[i - 2] != '0') {
                pickOne = last;
            }
            if ((i - 1 - 2) >= 0
                    && ((s[i - 2] <= '9' && s[i - 1 - 2] == '1') || (s[i - 2] <= '6' && s[i - 1 - 2] == '2'))) {
                pickTwo = secondLast;
            }
            secondLast = last;
            last = pickOne + pickTwo;
        }

        return last;
    }
}