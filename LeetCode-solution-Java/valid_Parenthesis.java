    // Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    // An input string is valid if:

    // Open brackets must be closed by the same type of brackets.
    // Open brackets must be closed in the correct order.
    

    // Example 1:

    // Input: s = "()"
    // Output: true
    // Example 2:

    // Input: s = "()[]{}"
    // Output: true
    // Example 3:

    // Input: s = "(]"
    // Output: false
    

    // Constraints:

    // 1 <= s.length <= 104
    // s consists of parentheses only '()[]{}'.
import java.util.*;
public class valid_Parenthesis {

    private boolean isLeftBracket(char c){
        if(c=='[' || c=='{' || c=='(') return true;
        return false;
    }

    private char rev(char c){
        if(c=='[') return ']'; 
        if(c=='{') return '}';
        return ')';
    }

    public boolean isValid(String s) {
        if(s.length()%2!=0) return false;
        
        Stack<Character> bracket=new Stack<>();

        for (char brack: s.toCharArray()) {
            if(bracket.isEmpty() && !isLeftBracket(brack)) return false;
            if(isLeftBracket(brack)) bracket.push(brack);
            if(!isLeftBracket(brack) && rev(bracket.peek())!=brack) return false;
            if(!isLeftBracket(brack) && rev(bracket.peek())==brack) bracket.pop();
        }
        return bracket.isEmpty();
    }
}