import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * You are given an array of words where each word consists of lowercase English letters.

wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB.

For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.

Return the length of the longest possible word chain with words chosen from the given list of words.

 

Example 1:

Input: words = ["a","b","ba","bca","bda","bdca"]
Output: 4
Explanation: One of the longest word chains is ["a","ba","bda","bdca"].
Example 2:

Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
Output: 5
Explanation: All the words can be put in a word chain ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].
Example 3:

Input: words = ["abcd","dbqca"]
Output: 1
Explanation: The trivial word chain ["abcd"] is one of the longest word chains.
["abcd","dbqca"] is not a valid word chain because the ordering of the letters is changed.
 

Constraints:

1 <= words.length <= 1000
1 <= words[i].length <= 16
words[i] only consists of lowercase English letters.
 */
public class longest_String_Chain {
    class Solution {
        public int longestStrChain(String[] words) {
            
            if(words == null || words.length == 0) {
                return 0;
            }
        
            int res = 0;
        
            Arrays.sort(words, (a,b)-> a.length()-b.length());
            HashMap<String, Integer> map = new HashMap<>(); 
            
            for(String w : words) {                            
                map.put(w, 1);                                  
            
                for(int i=0; i<w.length(); i++) {  
                    
                    StringBuilder sb = new StringBuilder(w);
                    String next = sb.deleteCharAt(i).toString();
                    
                    if(map.containsKey(next) && map.get(next)+1 > map.get(w))
                        map.put(w, map.get(next)+1);       
                    }
                res = Math.max(res, map.get(w));          
            }
            return res;
        }
    }
}
