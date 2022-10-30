
/**
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

 

Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
 

Constraints:

1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length
*/

import java.util.*;
import java.io.*;

class Solution {
    private int maxConsecutivesWithAtmostKDisruptions(char[] s, int k, char c) {
        int i = 0, j = 0, res = 0;
        int n = s.length;
        while (j < n && i < n) {

            if (s[j] == c || k > 0) {
                if (s[j] != c)
                    k--;
                j++;
            } else {
                if (s[i] != c)
                    k++;
                i++;
            }
            res = Math.max(j - i + 1, res);
        }
        return res - 1;
    }

    public int characterReplacement(String s, int k) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray())
            set.add(c);
        int res = 0;
        for (char c : set) {
            res = Math.max(res, maxConsecutivesWithAtmostKDisruptions(s.toCharArray(), k, c));
        }
        return res;
    }
}