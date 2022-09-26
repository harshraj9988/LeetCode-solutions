
/**
 * You are given an array of strings equations that represent relationships between variables where each string equations[i] is of length 4 and takes one of two different forms: "xi==yi" or "xi!=yi".Here, xi and yi are lowercase letters (not necessarily different) that represent one-letter variable names.

Return true if it is possible to assign integers to variable names so as to satisfy all the given equations, or false otherwise.

 

Example 1:

Input: equations = ["a==b","b!=a"]
Output: false
Explanation: If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.
There is no way to assign the variables to satisfy both equations.
Example 2:

Input: equations = ["b==a","a==b"]
Output: true
Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
 

Constraints:

1 <= equations.length <= 500
equations[i].length == 4
equations[i][0] is a lowercase letter.
equations[i][1] is either '=' or '!'.
equations[i][2] is '='.
equations[i][3] is a lowercase letter.
 */
import java.util.*;

public class satisfiability_Of_Equality_Equations {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        Arrays.fill(parent, -1);
        for (String eq : equations) {
            if (eq.charAt(1) == '=')
                assignParent(eq.charAt(0) - 'a', eq.charAt(3) - 'a', parent);
        }
        for (String eq : equations) {
            if (eq.charAt(1) == '!' && findParent(eq.charAt(0) - 'a', parent) == findParent(eq.charAt(3) - 'a', parent))
                return false;
        }
        return true;
    }

    private void assignParent(int x, int y, int[] parent) {
        int parentX = findParent(x, parent);
        int parentY = findParent(y, parent);
        if (parentX != parentY)
            parent[parentX] = parentY;
    }

    private int findParent(int x, int[] parent) {
        if (parent[x] == -1)
            return x;
        return parent[x] = findParent(parent[x], parent);
    }

   

}
