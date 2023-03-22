/**
 * Design a special dictionary with some words that searchs the words in it by a
 * prefix and a suffix.
 * 
 * Implement the WordFilter class:
 * 
 * WordFilter(string[] words) Initializes the object with the words in the
 * dictionary.
 * f(string prefix, string suffix) Returns the index of the word in the
 * dictionary, which has the prefix prefix and the suffix suffix. If there is
 * more than one valid index, return the largest of them. If there is no such
 * word in the dictionary, return -1.
 * 
 * 
 * Example 1:
 * 
 * Input
 * ["WordFilter", "f"]
 * [[["apple"]], ["a", "e"]]
 * Output
 * [null, 0]
 * 
 * Explanation
 * WordFilter wordFilter = new WordFilter(["apple"]);
 * wordFilter.f("a", "e"); // return 0, because the word at index 0 has prefix =
 * "a" and suffix = 'e".
 * 
 * 
 * Constraints:
 * 
 * 1 <= words.length <= 15000
 * 1 <= words[i].length <= 10
 * 1 <= prefix.length, suffix.length <= 10
 * words[i], prefix and suffix consist of lower-case English letters only.
 * At most 15000 calls will be made to the function f.
 */
import java.util.*;;
public class prefix_And_Suffix_Search {
    private Map<String , Integer> map;
    private Set<String> set;

    public void WordFilter(String[] words) {
        map = new HashMap<>();
        set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            set.add(words[i]);
            String temp = "#" + words[i];
            map.put(temp, i);
            for (int j = words[i].length()-1; j >=0 ; j--) {
                temp = words[i].charAt(j) + temp;
                map.put(temp, i);
            }
        }

        
    }

    public int f(String prefix, String suffix) {
        int ans =-1;
        for (String string : set) {
            if(string.startsWith(prefix) && string.endsWith(suffix)){
                if(map.containsKey(suffix+"#"+string)){
                    ans = Math.max(ans,map.get(suffix+"#"+string));
                }
            }
        }
        return ans;
    } 
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */