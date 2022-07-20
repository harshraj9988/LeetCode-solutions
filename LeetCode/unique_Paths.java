/**
 * There is a robot on an m x n grid. The robot is initially located at the
 * top-left corner (i.e., grid[0][0]). The robot tries to move to the
 * bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move
 * either down or right at any point in time.
 * 
 * Given the two integers m and n, return the number of possible unique paths
 * that the robot can take to reach the bottom-right corner.
 * 
 * The test cases are generated so that the answer will be less than or equal to
 * 2 * 109.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: m = 3, n = 7
 * Output: 28
 * Example 2:
 * 
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation: From the top-left corner, there are a total of 3 ways to reach
 * the bottom-right corner:
 * 1. Right -> Down -> Down
 * 2. Down -> Down -> Right
 * 3. Down -> Right -> Down
 * 
 * 
 * Constraints:
 * 
 * 1 <= m, n <= 100
 */
public class unique_Paths {
    public int uniquePaths(int m, int n) {

        return solve_with_tabulation_space_optimization(m, n);
    }

    private int[][] dp(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return dp;
    }

    private int solve(int m, int n, int[][] dp) {
        if (m == 0 && n == 0)
            return 1;
        if (m < 0 || n < 0)
            return 0;

        if (dp[m][n] != -1)
            return dp[m][n];

        int down = solve(m - 1, n, dp);
        int right = solve(m, n - 1, dp);

        return dp[m][n] = down + right;
    }

    private int solve_with_tabulation(int m, int n) {

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int up = 0;
                int left = 0;
                if (i == 0 && j == 0)
                    dp[i][j] = 1;
                else {
                    if (j > 0)
                        left = dp[i][j - 1];
                    if (j == 0)
                        up = dp[i - 1][j];

                    dp[i][j] = left + up;
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    private int solve_with_tabulation_space_optimization(int m, int n) {
        int[] sp = new int[n];
        for (int i = 0; i < m; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                int up = 0;
                int left = 0;
                if (i == 0 && j == 0)
                    temp[j] = 1;
                else {
                    if (j > 0) left = temp[j - 1];
                    if (i > 0) up = sp[j];
                    temp[j] = left + up;
                }
            }
            sp = temp;
        }
        return sp[n - 1];
    }
}
