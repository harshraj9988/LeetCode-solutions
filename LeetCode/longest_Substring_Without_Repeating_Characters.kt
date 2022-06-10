/**
    Given a string s, find the length of the longest substring without repeating characters.

    

    Example 1:

    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.
    Example 2:

    Input: s = "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.
    Example 3:

    Input: s = "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.
    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
    

    Constraints:

    0 <= s.length <= 5 * 104
    s consists of English letters, digits, symbols and spaces.
*/

class longest_Substring_Without_Repeating_Characters {
    fun lengthOfLongestSubstring(s: String): Int {
         val hashmap: HashMap<Char , Int> = HashMap<Char, Int>()
    	var max: Int = 0
    	var currMax: Int = 0
    	var i = 0
    	while(i<s.length){
            if(!hashmap.contains(s.get(i))){
                hashmap.put(s.get(i), i)
                currMax++
            	i++
                
            }else{
                i = hashmap.get(s.get(i))!!
                i++
                currMax = 0
                hashmap.clear()
            }
            max = if(currMax > max) currMax else max
            
        }
        return max
    }
}