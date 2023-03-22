
/**
 * You are given a string s and an array of strings words of the same length. Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once, in any order, and without any intervening characters.

You can return the answer in any order.

 

Example 1:

Input: s = "barfoothefoobarman", words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.
Example 2:

Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
Output: []
Example 3:

Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
Output: [6,9,12]
 

Constraints:

1 <= s.length <= 104
1 <= words.length <= 5000
1 <= words[i].length <= 30
s and words[i] consist of lowercase English letters.
 */
import java.util.*;

public class substring_With_Concatenation_Of_All_Words {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int strLen = s.length();
        int wrdLen = words[0].length();
        int totWrdsLen = words.length * wrdLen;
        if (strLen < totWrdsLen)
            return result;

        Map<String, Integer> totWrdFreq = new HashMap<>();
        for (String word : words)
            totWrdFreq.put(word, totWrdFreq.getOrDefault(word, 0) + 1);
         

        int left = 0;
        int right = totWrdsLen - 1;

        while (right < strLen) {
            Map<String, Integer> wrdFreq = new HashMap<>();
            int currLeft = left;
            int currRight = currLeft + wrdLen - 1;
            while (currRight <= right) {
                String temp = s.substring(currLeft, currRight+1);
                wrdFreq.put(temp, wrdFreq.getOrDefault(temp, 0) + 1);
                currLeft+=wrdLen;
                currRight+=wrdLen;
                
            }
            if(totWrdFreq.equals(wrdFreq)) result.add(left);
            left++;
            right++;
        }

        return result;
    }

}
