
/**
Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

 

Example 1:

Input: s = "1 + 1"
Output: 2
Example 2:

Input: s = " 2-1 + 2 "
Output: 3
Example 3:

Input: s = "(1+(4+5+2)-3)+(6+8)"
Output: 23
 

Constraints:

1 <= s.length <= 3 * 105
s consists of digits, '+', '-', '(', ')', and ' '.
s represents a valid expression.
'+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
'-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
There will be no two consecutive operators in the input.
Every number and running calculation will fit in a signed 32-bit integer.
*/

import java.util.*;
import java.io.*;

class Solution {
    public int calculate(String str) {
        Stack<Integer> st = new Stack<>();
        int result = 0;
        int num = 0;
        int sign = 1;
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (int) (c - '0');
            } else if (c == '+') {
                result += sign * num;
                sign = 1;
                num = 0;
            } else if (c == '-') {
                result += sign * num;
                sign = -1;
                num = 0;
            } else if (c == '(') {
                st.push(result);
                st.push(sign);
                num = 0;
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * num;
                num = 0;
                result *= st.pop();
                result += st.pop();
            }
        }
        if (num != 0)
            result += sign * num;
        return result;
    }
}



class InfixToPostfix {
    static Stack<Character> operators = new Stack<>();

    public static void main(String argv[]) throws IOException {
        String infix;
        // create an input stream object
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        // get input from user
        System.out.print("\nEnter the infix expression you want to convert: ");
        infix = keyboard.readLine();
        // output as postfix
        System.out.println("Postfix expression for the given infix expression is:" + toPostfix(infix));
    }

    private static String toPostfix(String infix)
    // converts an infix expression to postfix
    {
        char symbol;
        String postfix = "";
        for (int i = 0; i < infix.length(); ++i)
        // while there is input to be read
        {
            symbol = infix.charAt(i);
            // if it's an operand, add it to the string
            if (Character.isLetter(symbol))
                postfix = postfix + symbol;
            else if (symbol == '(')
            // push (
            {
                operators.push(symbol);
            } else if (symbol == ')')
            // push everything back to (
            {
                while (operators.peek() != '(') {
                    postfix = postfix + operators.pop();
                }
                operators.pop(); // remove '('
            } else
            // print operators occurring before it that have greater precedence
            {
                while (!operators.isEmpty() && !(operators.peek() == '(') && prec(symbol) <= prec(operators.peek()))
                    postfix = postfix + operators.pop();
                operators.push(symbol);
            }
        }
        while (!operators.isEmpty())
            postfix = postfix + operators.pop();
        return postfix;
    }

    static int prec(char x) {
        if (x == '+' || x == '-')
            return 1;
        if (x == '*' || x == '/' || x == '%')
            return 2;
        return 0;
    }

    private void f(){
        Queue<Integer> q = new LinkedList<>();
    }
}