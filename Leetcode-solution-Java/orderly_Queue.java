
/**
You are given a string s and an integer k. You can choose one of the first k letters of s and append it at the end of the string..

Return the lexicographically smallest string you could have after applying the mentioned step any number of moves.

 

Example 1:

Input: s = "cba", k = 1
Output: "acb"
Explanation: 
In the first move, we move the 1st character 'c' to the end, obtaining the string "bac".
In the second move, we move the 1st character 'b' to the end, obtaining the final result "acb".
Example 2:

Input: s = "baaca", k = 3
Output: "aaabc"
Explanation: 
In the first move, we move the 1st character 'b' to the end, obtaining the string "aacab".
In the second move, we move the 3rd character 'c' to the end, obtaining the final result "aaabc".
 

Constraints:

1 <= k <= s.length <= 1000
s consist of lowercase English letters.
*/

import java.util.*;
import java.io.*;

class Solution {
    public String orderlyQueue(String str, int k) {
        char[] s = str.toCharArray();
        int n = s.length;
        if (k > 1) {
            Arrays.sort(s);
            return new String(s);
        } else {
            char[] t = new char[2 * n];
            for (int i = 0; i < 2 * n; i++) {
                if (i < n) {
                    t[i] = s[i];
                } else {
                    t[i] = s[i-n];
                }
            }
            String st = str;
            for (int i = 0; i < n; i++) {
                String x = new String(Arrays.copyOfRange(t, i, i + n));
                if(x.compareTo(st)<0) st = x;
            }
            return st;
        }
    }
}
