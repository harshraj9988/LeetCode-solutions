
/**
You are given an array of strings words. Each element of words consists of two lowercase English letters.

Create the longest possible palindrome by selecting some elements from words and concatenating them in any order. Each element can be selected at most once.

Return the length of the longest palindrome that you can create. If it is impossible to create any palindrome, return 0.

A palindrome is a string that reads the same forward and backward.

 

Example 1:

Input: words = ["lc","cl","gg"]
Output: 6
Explanation: One longest palindrome is "lc" + "gg" + "cl" = "lcggcl", of length 6.
Note that "clgglc" is another longest palindrome that can be created.
Example 2:

Input: words = ["ab","ty","yt","lc","cl","ab"]
Output: 8
Explanation: One longest palindrome is "ty" + "lc" + "cl" + "yt" = "tylcclyt", of length 8.
Note that "lcyttycl" is another longest palindrome that can be created.
Example 3:

Input: words = ["cc","ll","xx"]
Output: 2
Explanation: One longest palindrome is "cc", of length 2.
Note that "ll" is another longest palindrome that can be created, and so is "xx".
 

Constraints:

1 <= words.length <= 105
words[i].length == 2
words[i] consists of lowercase English letters.
*/

import java.util.*;
import java.io.*;

class Solution {
    public int longestPalindrome(String[] words) {
        int ans = 0;
        boolean center = false;
        HashMap<String, Integer> map = createMap(words);
        for(String s: map.keySet()){
            if(same(s)){
                while(map.get(s)>=2){
                    map.put(s, map.get(s)-2);
                    ans = ans+4;
                }
                if(!center && map.get(s)==1){
                    map.put(s, map.get(s)-1);
                    ans = ans+2;
                    center = true;
                }
            } else {
                String revS = rev(s);
                while(map.containsKey(revS) && map.get(s)>0 && map.get(revS)>0) {
                    map.put(s, map.get(s)-1);
                    map.put(revS, map.get(revS)-1);
                    ans = ans+4;
                }
            }
        }
        return ans;
    }

    private HashMap<String, Integer> createMap(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String word: words) {
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        return map;
    }

    private String rev(String s){
        return new String(new char[]{s.charAt(1), s.charAt(0)});        
    }

    private boolean same(String s){
        return (s.charAt(0)==s.charAt(1));
    }
}