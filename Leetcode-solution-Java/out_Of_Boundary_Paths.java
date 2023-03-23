/**
 * There is an m x n grid with a ball. The ball is initially at the position
 * [startRow, startColumn]. You are allowed to move the ball to one of the four
 * adjacent cells in the grid (possibly out of the grid crossing the grid
 * boundary). You can apply at most maxMove moves to the ball.
 * 
 * Given the five integers m, n, maxMove, startRow, startColumn, return the
 * number of paths to move the ball out of the grid boundary. Since the answer
 * can be very large, return it modulo 109 + 7.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
 * Output: 6
 * Example 2:
 * 
 * 
 * Input: m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
 * Output: 12
 * 
 * 
 * Constraints:
 * 
 * 1 <= m, n <= 50
 * 0 <= maxMove <= 50
 * 0 <= startRow < m
 * 0 <= startColumn < n
 */

public class out_Of_Boundary_Paths {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
      
        int[][][] dp = new int[maxMove+1][m+1][n+1];
        for(int i = 0; i<= maxMove; i++){
            for(int j =0 ; j<= m; j++){
                for(int k=0; k<=n; k++){
                    dp[i][j][k] = -1;
                }
            }
        }

        int ans = solve(m, n, maxMove, startRow, startColumn, 0,dp);

        return ans;
    }

    private int solve(int m, int n, int maxMove, int x, int y, int moves, int[][][] dp) {

        long mod = 1000000007;
        
        if (moves > maxMove) return 0;

        if ((x < 0 || x >= m) || (y < 0 || y >= n))
                return  1;
        
        if(dp[moves][x][y]!=-1) return dp[moves][x][y];        
        
        long up =       solve(m, n, maxMove , x - 1, y, moves + 1, dp)%mod;
        long down =     solve(m, n, maxMove , x + 1, y, moves + 1, dp)%mod;
        long left =     solve(m, n, maxMove , x, y - 1, moves + 1, dp)%mod;
        long right =    solve(m, n, maxMove , x, y + 1, moves + 1, dp)%mod;
        
        long tot = (up+down+left+right)%mod;
        
        return dp[moves][x][y]=(int) tot;
    }
}
