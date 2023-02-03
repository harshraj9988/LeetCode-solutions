import java.util.*;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and
 * '0's (water), return the number of islands.
 * 
 * An island is surrounded by water and is formed by connecting adjacent lands
 * horizontally or vertically. You may assume all four edges of the grid are all
 * surrounded by water.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 * 
 * Input: grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * Output: 3
 * 
 * 
 * Constraints:
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 */
public class number_Of_Islands {
    public int numIslands(char[][] grid) {
        int count = 0;
        int[] dim = { grid.length, grid[0].length };
        int[] dx = { -1, 0, 1, 0, -1 };
        for (int i = 0; i < dim[0]; i++) {
            for (int j = 0; j < dim[1]; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid, dim, dx);
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, char[][] grid, int[] dim, int[] dx) {
        if (i < 0 || i >= dim[0] || j < 0 || j >= dim[1] || grid[i][j] == '0')
            return;
        grid[i][j] = '0';

        for (int x = 0; x < 4; x++) {
            dfs(i+dx[x], j+dx[x+1], grid, dim, dx);
        }
    }
}
