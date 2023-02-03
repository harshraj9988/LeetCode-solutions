import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * A string s is called good if there are no two different characters in s that
 * have the same frequency.
 * 
 * Given a string s, return the minimum number of characters you need to delete
 * to make s good.
 * 
 * The frequency of a character in a string is the number of times it appears in
 * the string. For example, in the string "aab", the frequency of 'a' is 2,
 * while the frequency of 'b' is 1.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "aab"
 * Output: 0
 * Explanation: s is already good.
 * Example 2:
 * 
 * Input: s = "aaabbbcc"
 * Output: 2
 * Explanation: You can delete two 'b's resulting in the good string "aaabcc".
 * Another way it to delete one 'b' and one 'c' resulting in the good string
 * "aaabbc".
 * Example 3:
 * 
 * Input: s = "ceabaacb"
 * Output: 2
 * Explanation: You can delete both 'c's resulting in the good string "eabaab".
 * Note that we only care about characters that are still in the string at the
 * end (i.e. frequency of 0 is ignored).
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 105
 * s contains only lowercase English letters.
 */
public class minimum_Deletion_To_Make_Character_Frequencies_Unique {
    public int minDeletions(String s) {

        int[] frequency = new int[26];

        countTheFrequencies(s, frequency);

        Arrays.sort(frequency);

        return solve(frequency);
    }

    private void countTheFrequencies(String s, int[] frequency) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            frequency[s.charAt(i) - 'a'] = frequency[s.charAt(i) - 'a'] + 1;
        }
    }

    private int solve(int[] frequency) {
        int count = 0;

        int uniqueFreq = frequency[25];
        for (int i = 25; i >= 0; i--) {
            if (frequency[i] == 0)
                break;
            if (frequency[i] > uniqueFreq) {
                count += frequency[i] - uniqueFreq;
            } else {
                uniqueFreq = frequency[i];
            }
            if (uniqueFreq > 0)
                uniqueFreq--;
        }

        return count;
    }
}
