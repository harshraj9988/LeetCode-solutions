/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8
 */

import java.util.*;
public class generate_Parentheses {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        solve(n, 0, list, "");
      
        return list;
    }

    private void solve(int n, int m, List<String> list, String x) {
        if(n==0 && m == 0){
            list.add(x);
            return;
        }
        if(m>0)
        solve(n, m-1, list, x+")");
        if(n>0)
        solve(n-1, m+1, list, x+"(");
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> ans = new generate_Parentheses().generateParenthesis(n);
        System.out.println(ans.toString());
    }
}
