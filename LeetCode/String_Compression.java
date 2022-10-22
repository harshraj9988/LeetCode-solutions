
/**
Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string s. For each group of consecutive repeating characters in chars:

If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

After you are done modifying the input array, return the new length of the array.

You must write an algorithm that uses only constant extra space.

 

Example 1:

Input: chars = ["a","a","b","b","c","c","c"]
Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
Example 2:

Input: chars = ["a"]
Output: Return 1, and the first character of the input array should be: ["a"]
Explanation: The only group is "a", which remains uncompressed since it's a single character.
Example 3:

Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
 

Constraints:

1 <= chars.length <= 2000
chars[i] is a lowercase English letter, uppercase English letter, digit, or symbol.
*/

import java.util.*;
import java.io.*;

class Solution {
    public int compress(char[] chars) {
        int ans = 0;
        int count = 1;
        int n = chars.length;
        int j = 0;
        int k = 0;
        for (int i = 1; i < n; i++) {
            if (chars[i - 1] == chars[i])
                count++;
            else {
                chars[j] = chars[k];
                ans++;
                if (count > 1) {
                    int x = digitInCount(count);
                    ans += x;
                    for (int dig : getDigits(x, count)) {
                        chars[++j] = (char) ((int) ('0') + dig);
                    }
                }
                k = i;
                count = 1;
                j++;
            }
        }
        ans++;
        chars[j] = chars[k];
        if (count > 1) {
            int x = digitInCount(count);
            ans += x;
            for (int dig : getDigits(x, count)) {
                chars[++j] = (char) ((int) ('0') + dig);
            }
        }
        return ans;
    }

    private int digitInCount(int count) {
        if (count < 10)
            return 1;
        if (count < 100)
            return 2;
        if (count < 1000)
            return 3;
        if (count <= 2000)
            return 4;
        return 0;
    }

    private int[] getDigits(int n, int cnt) {
        int[] digs = new int[n];
        int i = n - 1;
        while (i >= 0) {
            digs[i--] = cnt % 10;
            cnt /= 10;
        }
        return digs;
    }
}