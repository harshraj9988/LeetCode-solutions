/**
Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

 

Example 1:

Input: s = "hello"
Output: "holle"
Example 2:

Input: s = "leetcode"
Output: "leotcede"
 

Constraints:

1 <= s.length <= 3 * 105
s consist of printable ASCII characters.
*/

import java.util.*;
import java.io.*;
class Solution {
    HashSet<Character> vowels = new HashSet<>(Set.of('a', 'e', 'i', 'o','u','A', 'E', 'I', 'O','U'));
    public String reverseVowels(String str) {
        char[] s = str.toCharArray();
        int i = 0, j = s.length - 1;
        while(i<j) {
            while(!isVowel(s[i])) i++;
            while(!isVowel(s[j])) j--;
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
        return new String(s);
    }

    private boolean isVowel(char c){
        return vowels.contains(c);
    }
}