
/**
Given a string s which represents an expression, evaluate this expression and return its value. 

The integer division should truncate toward zero.

You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

 

Example 1:

Input: s = "3+2*2"
Output: 7
Example 2:

Input: s = " 3/2 "
Output: 1
Example 3:

Input: s = " 3+5 / 2 "
Output: 5
 

Constraints:

1 <= s.length <= 3 * 105
s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
s represents a valid expression.
All the integers in the expression are non-negative integers in the range [0, 231 - 1].
The answer is guaranteed to fit in a 32-bit integer.
*/

import java.util.*;
import java.io.*;

class Solution {
    public int calculate(String s) {
        ArrayList<String> str = new ArrayList<>();
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            } else {
                if (!sb.isEmpty()) {
                    str.add(sb.toString());
                    sb.setLength(0);
                }
                if (s.charAt(i) != ' ') {
                    sb.append(s.charAt(i));
                    str.add(sb.toString());
                    sb.setLength(0);
                }
            }
        }
        if (!sb.isEmpty()) {
            str.add(sb.toString());
        }
        Stack<String> st = new Stack<>();
        for(String x: str) {
            if(!st.isEmpty() && st.peek().equals("*")){
                st.pop();
                int a = Integer.parseInt(st.pop());
                int b = Integer.parseInt(x);
                st.push(Integer.toString(a*b));
            }else if(!st.isEmpty() && st.peek().equals("/")){
                st.pop();
                int a = Integer.parseInt(st.pop());
                int b = Integer.parseInt(x);
                st.push(Integer.toString(a/b));
            }else{
                st.push(x);
            }
        }
        int result = 0;
        while(!st.isEmpty()) {
            int num = Integer.parseInt(st.pop());
            String op = "+";
            if(!st.isEmpty()) op = st.pop();
            if(op.equals("+")){
                result += num;
            }else{
                result -= num;
            }
        }
        return result;
    }
}