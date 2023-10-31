/**
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right, which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 * Example 2:
 * 
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 * 
 * 
 * Constraints:
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 */
public class minimum_Path_Sum {
    public int minPathSum(int[][] grid) {
        return spaceOptimization(grid);
    }

    private int solve(int[][] grid, int m, int n, int[][] dp) {
        if (m < 0 || n < 0)
            return Integer.MAX_VALUE;

        if (m == 0 && n == 0) {
            return grid[m][n];
        }

        if (dp[m][n] != -1)
            return dp[m][n];

        int left = solve(grid, m, n - 1, dp);
        int up = solve(grid, m - 1, n, dp);

        int currMin = Math.min(left, up);

        return dp[m][n] = grid[m][n] + currMin;
    }

    private int tabulation(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0 && j==0) dp[i][j]=grid[i][j];
                else{
                    int left = Integer.MAX_VALUE;
                    int up = Integer.MAX_VALUE;

                    if(i>0){
                        up = dp[i-1][j];
                    }
                    if(j>0){
                        left = dp[i][j-1];
                    }
                    dp[i][j] = grid[i][j] + Math.min(up, left);
                }
            }
        }
        return dp[m-1][n-1];
    }

    private int spaceOptimization(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        int[] so = new int[n];

        for (int i = 0; i < m; i++) {
            int[] curr = new int[n];
            for (int j = 0; j < n; j++) {
                if(i==0 && j==0) curr[j]=grid[i][j];
                else{
                    int left = Integer.MAX_VALUE;
                    int up = Integer.MAX_VALUE;

                    if(i>0){
                        up = so[j];
                    }
                    if(j>0){
                        left = curr[j-1];
                    }
                    curr[j] = grid[i][j] + Math.min(up, left);
                }
            }
            so = curr;
        }
        return so[n-1];
    }
}
