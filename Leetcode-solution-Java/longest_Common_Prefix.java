import java.util.Arrays;
import java.util.Comparator;

/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * 
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * 
 * 
 * Constraints:
 * 
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lower-case English letters.
 */

public class longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        String str = "";

        for (int i = 0; i < strs[0].length(); i++) {
            char temp = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                try {
                    if (temp != strs[j].charAt(i))
                        return str;
                } catch (StringIndexOutOfBoundsException e) {
                    return str;
                }

            }

            str += temp;
        }

        return str;
    }
}