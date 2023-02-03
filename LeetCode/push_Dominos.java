
/**
 * There are n dominoes in a line, and we place each domino vertically upright. In the beginning, we simultaneously push some of the dominoes either to the left or to the right.

After each second, each domino that is falling to the left pushes the adjacent domino on the left. Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.

When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.

For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.

You are given a string dominoes representing the initial state where:

dominoes[i] = 'L', if the ith domino has been pushed to the left,
dominoes[i] = 'R', if the ith domino has been pushed to the right, and
dominoes[i] = '.', if the ith domino has not been pushed.
Return a string representing the final state.

 

Example 1:

Input: dominoes = "RR.L"
Output: "RR.L"
Explanation: The first domino expends no additional force on the second domino.
Example 2:


Input: dominoes = ".L.R...LR..L.."
Output: "LL.RR.LLRRLL.."
 

Constraints:

n == dominoes.length
1 <= n <= 105
dominoes[i] is either 'L', 'R', or '.'.
 */
import java.util.*;

public class push_Dominos {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[] left = new int[n];
        int[] right = new int[n];

        // for left dominos
        int dist = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (dominoes.charAt(i) == 'L')
                dist = 1;
            else if (dominoes.charAt(i) == 'R')
                dist = 0;
            else if (dominoes.charAt(i) == '.' && dist != 0)
                dist++;
            left[i] = (dist==0)?Integer.MAX_VALUE:dist;
        }
        // for right dominos
        dist = 0;

        for (int i = 0; i < n; i++) {
            if (dominoes.charAt(i) == 'R')
                dist = 1;
            else if (dominoes.charAt(i) == 'L')
                dist = 0;
            else if (dominoes.charAt(i) == '.' && dist != 0)
                dist++;
            right[i] = (dist==0)?Integer.MAX_VALUE:dist;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++) {
            if(left[i]<right[i]){
                sb.append('L');
            }else if(right[i]<left[i]){
                sb.append('R');
            }else{
                sb.append('.');
            }
        }

        return sb.toString();
    }
}
