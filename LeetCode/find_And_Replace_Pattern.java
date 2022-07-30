import java.util.*;

/**
 * Given a list of strings words and a string pattern, return a list of words[i]
 * that match pattern. You may return the answer in any order.
 * 
 * A word matches the pattern if there exists a permutation of letters p so that
 * after replacing every letter x in the pattern with p(x), we get the desired
 * word.
 * 
 * Recall that a permutation of letters is a bijection from letters to letters:
 * every letter maps to another letter, and no two letters map to the same
 * letter.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * Output: ["mee","aqq"]
 * Explanation: "mee" matches the pattern because there is a permutation {a ->
 * m, b -> e, ...}.
 * "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a
 * permutation, since a and b map to the same letter.
 * Example 2:
 * 
 * Input: words = ["a","b","c"], pattern = "a"
 * Output: ["a","b","c"]
 * 
 * 
 * Constraints:
 * 
 * 1 <= pattern.length <= 20
 * 1 <= words.length <= 50
 * words[i].length == pattern.length
 * pattern and words[i] are lowercase English letters.
 */
public class find_And_Replace_Pattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> finalList = new ArrayList<>();
        char[] pat = pattern.toCharArray();
        int patSize = pat.length;

        int n = words.length;

        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map1.clear();
            map2.clear();

            char[] word  = words[i].toCharArray();

            for (int j = 0; j < patSize; j++) {
              if(!map1.containsKey(word[j])){
                if(!map2.containsKey(pat[j])){
                    map1.put(word[j], pat[j]);
                    map2.put(pat[j], word[j]);
                }else{
                    break;
                }
              }else{
                if(map1.get(word[j])!=pat[j]) break;
              }
              if(j==patSize-1){
                finalList.add(words[i]);
              }
            }
        }

        return finalList;
    }
}
