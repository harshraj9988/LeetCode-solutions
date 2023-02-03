/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
 

Follow up: Could you use search pruning to make your solution faster with a larger board?
 */
import java.util.*;
public class word_Search {
    boolean ans = false;
    private void dfs(int i, int j, int m, int n, int[] del, char[][] board, String word, int z, int x, boolean[][] vis) {
        if(ans || x==z) {
            ans = true;
            return;
        }
        
        for(int d = 0; d<4; d++) {
            int a = i+del[d], b = j+del[d+1];
            if(a<0 || a>=m || b<0 || b>=n || vis[a][b] || word.charAt(x)!=board[a][b]) continue;
            vis[a][b] = true;
            dfs(a, b, m, n, del, board, word, z, x+1, vis);
            vis[a][b] = false;
        }
        
    }
    public boolean exist(char[][] board, String word) {
        int[] del = new int[]{-1, 0, 1, 0, -1};
        int m = board.length;
        int n = board[0].length;
        int z = word.length();
        int x = 0;
        boolean[][] vis = new boolean[m][n];
        for(int i=0; i<m; i++) {
            for( int j=0; j<n; j++) {
                if(vis[i][j] || word.charAt(x)!=board[i][j]) continue;
                vis[i][j] = true;
                dfs(i, j, m, n, del, board, word, z, x+1, vis);
                vis[i][j] = false;
            }
        }
        return ans;
    }
}
