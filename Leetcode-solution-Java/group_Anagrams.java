import java.util.*;

/**
 * Given an array of strings strs, group the anagrams together. You can return
 * the answer in any order.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 * 
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 * 
 * Input: strs = ["a"]
 * Output: [["a"]]
 * 
 * 
 * Constraints:
 * 
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 */
public class group_Anagrams {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> finalList = new ArrayList<>();
        HashMap<String, Stack<String>> strMap = new HashMap<>();
        addToMap(strMap, strs);
        addToList(finalList, strMap);
        return finalList;
    }

    private void addToMap(HashMap<String, Stack<String>> strMap, String[] strs) {
        for (String str : strs) {
            String temp = new String(str);
            temp = sortString(temp);
            Stack<String> set = strMap.get(temp);
            if (set == null) {
                set = new Stack<>();
            }
            set.add(str);
            strMap.put(temp, set);
        }
    }

    private String sortString(String string) {
        char[] tempArray = string.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }

    private void addToList(List<List<String>> finalList, HashMap<String, Stack<String>> strMap) {
        for (Stack<String> stack : strMap.values()) {
            List<String> list = new ArrayList<>();
            while (!stack.isEmpty()) {
                list.add(stack.pop());
            }
            finalList.add(list);
        }
    }
}
