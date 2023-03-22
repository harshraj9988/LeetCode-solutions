/**
 * You are given a rows x cols matrix grid representing a field of cherries
 * where grid[i][j] represents the number of cherries that you can collect from
 * the (i, j) cell.
 * 
 * You have two robots that can collect cherries for you:
 * 
 * Robot #1 is located at the top-left corner (0, 0), and
 * Robot #2 is located at the top-right corner (0, cols - 1).
 * Return the maximum number of cherries collection using both robots by
 * following the rules below:
 * 
 * From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i
 * + 1, j + 1).
 * When any robot passes through a cell, It picks up all cherries, and the cell
 * becomes an empty cell.
 * When both robots stay in the same cell, only one takes the cherries.
 * Both robots cannot move outside of the grid at any moment.
 * Both robots should reach the bottom row in grid.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: grid = [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]
 * Output: 24
 * Explanation: Path of robot #1 and #2 are described in color green and blue
 * respectively.
 * Cherries taken by Robot #1, (3 + 2 + 5 + 2) = 12.
 * Cherries taken by Robot #2, (1 + 5 + 5 + 1) = 12.
 * Total of cherries: 12 + 12 = 24.
 * Example 2:
 * 
 * 
 * Input: grid =
 * [[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0],[1,0,2,3,0,0,6]]
 * Output: 28
 * Explanation: Path of robot #1 and #2 are described in color green and blue
 * respectively.
 * Cherries taken by Robot #1, (1 + 9 + 5 + 2) = 17.
 * Cherries taken by Robot #2, (1 + 3 + 4 + 3) = 11.
 * Total of cherries: 17 + 11 = 28.
 * 
 * 
 * Constraints:
 * 
 * rows == grid.length
 * cols == grid[i].length
 * 2 <= rows, cols <= 70
 * 0 <= grid[i][j] <= 100
 */
public class cherry_Pickup_2 {
    public int cherryPickup(int[][] grid) {

        int r = grid.length;
        int c = grid[0].length;

        int[][][] dp = new int[r + 1][c + 1][c + 1];
        for (int i = 0; i <= r; i++) {
            for (int j = 0; j <= c; j++) {
                for (int k = 0; k <= c; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return memoization(grid, 0, 0, c - 1, r, c, dp);
    }

    private int memoization(int[][] grid, int i, int j1, int j2, int r, int c, int[][][] dp) {
        if (i < 0 || i > r - 1 || j1 < 0 || j1 > c - 1 || j2 < 0 || j2 > c - 1)
            return 0;

        if (dp[i][j1][j2] != -1)
            return dp[i][j1][j2];

        int value = 0;

        if (j1 == j2)
            value = grid[i][j1];
        else
            value = grid[i][j1] + grid[i][j2];

        if (i == r - 1)
            return value;

        int max = -1;

        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                int temp = memoization(grid, i + 1, j1 + dj1, j2 + dj2, r, c, dp);
                max = Math.max(temp, max);
            }
        }

        return dp[i][j1][j2] = value + max;
    }

    private int tabulation(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][][] dp = new int[r][c][c];

        for (int i = 0; i < c; i++) {
            for (int j = 0; j < c; j++) {
                if (i == j) {
                    dp[r - 1][i][j] = grid[r - 1][i];
                } else {
                    dp[r - 1][i][j] = grid[r - 1][i] + grid[r - 1][j];
                }
            }
        }

        for (int i = r - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < c; j1++) {
                for (int j2 = 0; j2 < c; j2++) {

                    int value = 0;
                    if (j1 == j2) {
                        value = grid[i][j1];
                    } else {
                        value = grid[i][j1] + grid[i][j2];
                    }
                    int max = 0;

                    for (int dj1 = -1; dj1 <= 1; dj1++) {
                        for (int dj2 = -1; dj2 <= 1; dj2++) {
                            if (j1 + dj1 >= 0 && j1 + dj1 < c &&
                                    j2 + dj2 >= 0 && j2 + dj2 < c) {
                                int temp = dp[i + 1][j1 + dj1][j2 + dj2];
                                max = Math.max(temp, max);
                            }
                        }
                    }

                    dp[i][j1][j2] = value + max;
                }
            }
        }

        return dp[0][0][c-1];
    }

    private int spaceOptimization(int[][] grid){
        int r = grid.length;
        int c = grid[0].length;
        int[][] next = new int[c][c];

        for (int i = 0; i < c; i++) {
            for (int j = 0; j < c; j++) {
                if (i == j) {
                    next[i][j] = grid[r-1][i];
                } else {
                    next[i][j] = grid[r - 1][i] + grid[r - 1][j];
                }
            }
        }

        for (int i = r - 2; i >= 0; i--) {
            int[][] curr = new int[c][c];
            for (int j1 = 0; j1 < c; j1++) {
                for (int j2 = 0; j2 < c; j2++) {

                    int value = 0;
                    if (j1 == j2) {
                        value = grid[i][j1];
                    } else {
                        value = grid[i][j1] + grid[i][j2];
                    }
                    int max = 0;

                    for (int dj1 = -1; dj1 <= 1; dj1++) {
                        for (int dj2 = -1; dj2 <= 1; dj2++) {
                            if (j1 + dj1 >= 0 && j1 + dj1 < c &&
                                    j2 + dj2 >= 0 && j2 + dj2 < c) {
                                int temp = next[j1 + dj1][j2 + dj2];
                                max = Math.max(temp, max);
                            }
                        }
                    }

                    curr[j1][j2] = value + max;
                }
            }
            next = curr;
        }

        return next[0][c-1];
    }
}
