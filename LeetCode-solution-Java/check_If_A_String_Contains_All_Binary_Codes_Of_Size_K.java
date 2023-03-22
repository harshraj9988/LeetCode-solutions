import java.util.HashSet;
import java.util.Set;

/**
    Given a binary string s and an integer k, return true if every binary code of length k is a substring of s. Otherwise, return false.

    

    Example 1:

    Input: s = "00110110", k = 2
    Output: true
    Explanation: The binary codes of length 2 are "00", "01", "10" and "11". They can be all found as substrings at indices 0, 1, 3 and 2 respectively.
    Example 2:

    Input: s = "0110", k = 1
    Output: true
    Explanation: The binary codes of length 1 are "0" and "1", it is clear that both exist as a substring. 
    Example 3:

    Input: s = "0110", k = 2
    Output: false
    Explanation: The binary code "00" is of length 2 and does not exist in the array.
    

    Constraints:

    1 <= s.length <= 5 * 105
    s[i] is either '0' or '1'.
    1 <= k <= 20
*/

public class check_If_A_String_Contains_All_Binary_Codes_Of_Size_K{
    
    private Integer toDecimal(String s){
        int ans = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i)=='1'){
                ans += (int) Math.pow(2, i);
            }
        }
        return ans;
    }


    public boolean hasAllCodes(String s, int k) {
        
        Set<Integer> store = new HashSet<>();
        int n = (int) Math.pow(2, k) - 1 ;
        
        for (int i = 0; i <= s.length()-k; i++) {
            String subString = s.substring(i, i+k);

            store.add(toDecimal(subString));
        }
        
        for(int i=0;i<=n;i++){
            if(!store.contains(i)) return false;
        }
        
        return true;
    }
}
