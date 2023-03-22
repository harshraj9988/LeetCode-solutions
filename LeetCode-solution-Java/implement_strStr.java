/**
 * Implement strStr().

Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

 

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
 

Constraints:

1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.
 */

public class implement_strStr{
    public int strStr(String haystack, String needle) {
        if(haystack.length()<needle.length()) return -1;

        int i=0;
        int j=needle.length()-1;
       while(j<haystack.length()) {
            if(
                haystack.charAt(i) == needle.charAt(0) &&
                haystack.charAt(j) == needle.charAt(needle.length()-1)
            ){
                if(haystack.substring(i, j+1).equals(needle)){
                    return i;
                }
            }

            i++;
            j++;
       }

        return -1;  
    }

    public static void main(String[] args) {
        String haystack = "aaaaa";
        String needle = "bba";
        System.out.println(new implement_strStr().strStr(haystack, needle));
    }
}