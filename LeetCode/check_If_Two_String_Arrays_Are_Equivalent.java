
/**
Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.

A string is represented by an array if the array elements concatenated in order forms the string.

 

Example 1:

Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
Output: true
Explanation:
word1 represents string "ab" + "c" -> "abc"
word2 represents string "a" + "bc" -> "abc"
The strings are the same, so return true.
Example 2:

Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
Output: false
Example 3:

Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
Output: true
 

Constraints:

1 <= word1.length, word2.length <= 103
1 <= word1[i].length, word2[i].length <= 103
1 <= sum(word1[i].length), sum(word2[i].length) <= 103
word1[i] and word2[i] consist of lowercase letters.
*/

import java.util.*;
import java.io.*;

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int n = word1.length;
        int m = word2.length;
        int i = 0, j = 0, a = 0, b = 0;
        while (i < n && j < m) {
            if (a < word1[i].length() && b < word2[j].length() && word1[i].charAt(a++) != word2[j].charAt(b++))
                return false;
            else {
                if (a == word1[i].length()) {
                    i++;
                    a = 0;
                }
                if (b == word2[j].length()) {
                    j++;
                    b = 0;
                }
            }
        }
        if(i!=n || j!=m) return false;
        return true;
    }
}