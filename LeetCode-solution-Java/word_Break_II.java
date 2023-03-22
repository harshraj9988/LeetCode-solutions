
/**
 * Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
Output: ["cats and dog","cat sand dog"]
Example 2:

Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: []
 

Constraints:

1 <= s.length <= 20
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 10
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
Accepted
481,283
Submissions

 */
import java.util.*;

public class word_Break_II {

    private void recursion(String s, Set<String> set, List<String> ans, List<String> temp, int i, int n) {
        StringBuilder sb = new StringBuilder();
        if(i>=n){
            for(String str: temp){
                sb.append(str);
                sb.append(" ");
            }
            sb.setLength(sb.length()-1);
            ans.add(sb.toString());
            return;
        }

        for(int j=i; j<n; j++) {
            sb.append(s.charAt(j));
            if(set.contains(sb.toString())){
                List<String> t = new ArrayList<>(temp);
                t.add(sb.toString());
                recursion(s, set, ans, t, j+1, n);
            }
        } 
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        List<String> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        int n = s.length();
        recursion(s, set, ans, temp, 0, n);
        return ans;
    }
}
