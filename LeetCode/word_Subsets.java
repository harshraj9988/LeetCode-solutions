/**
 * You are given two string arrays words1 and words2.

A string b is a subset of string a if every letter in b occurs in a including multiplicity.

For example, "wrr" is a subset of "warrior" but is not a subset of "world".
A string a from words1 is universal if for every string b in words2, b is a subset of a.

Return an array of all the universal strings in words1. You may return the answer in any order.

 

Example 1:

Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
Output: ["facebook","google","leetcode"]
Example 2:

Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["l","e"]
Output: ["apple","google","leetcode"]
 

Constraints:

1 <= words1.length, words2.length <= 104
1 <= words1[i].length, words2[i].length <= 10
words1[i] and words2[i] consist only of lowercase English letters.
All the strings of words1 are unique.
 */

import java.util.*;
public class word_Subsets {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();

        int n = words1.length;
        int m = words2.length;

        int[] maxFreq = new int[26];

        for (int i = 0; i < m; i++) {
            int[] freq = new int[26];
            char[] word = words2[i].toCharArray();
            int wordSize = word.length;
            for (int j = 0; j < wordSize; j++) {
                int ind = word[j]-'a';
                freq[ind]++;
                maxFreq[ind] = Math.max(maxFreq[ind], freq[ind]);
            }
        }
        
        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            char[] word = words1[i].toCharArray();
            int wordSize = word.length;
            for (int j = 0; j < wordSize; j++) {
                freq[word[j]-'a']++;
            }
            int k=0;
            while(k<26){
                if(freq[k]<maxFreq[k]) break;
                k++;
            }
            if(k==26) result.add(words1[i]);
        }

        return result;
    }
}
