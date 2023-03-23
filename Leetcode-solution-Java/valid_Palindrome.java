    // A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

    // Given a string s, return true if it is a palindrome, or false otherwise.

    

    // Example 1:

    // Input: s = "A man, a plan, a canal: Panama"
    // Output: true
    // Explanation: "amanaplanacanalpanama" is a palindrome.
    // Example 2:

    // Input: s = "race a car"
    // Output: false
    // Explanation: "raceacar" is not a palindrome.
    // Example 3:

    // Input: s = " "
    // Output: true
    // Explanation: s is an empty string "" after removing non-alphanumeric characters.
    // Since an empty string reads the same forward and backward, it is a palindrome.
    

    // Constraints:

    // 1 <= s.length <= 2 * 105
    // s consists only of printable ASCII characters.

public class valid_Palindrome {
    public boolean isPalindrome(String string) {
       string=string.toLowerCase();
       String s="";
       for(int i=0;i<string.length();i++){
           char c=string.charAt(i);
           if((c>='a' && c<='z') || (c>='0' && c<='9') ){
               s+=c;
           }
       }
       int i=0;
       int n=s.length()-1;
       while(i<n){
           if(s.charAt(i)!=s.charAt(n)) return false;
           i++;
           n--;
       }
       return true;
   }
}
