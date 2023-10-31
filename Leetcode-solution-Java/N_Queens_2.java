
/**
 * 
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard
 * such that no two queens attack each other.
 * 
 * Given an integer n, return the number of distinct solutions to the n-queens
 * puzzle.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as
 * shown.
 * Example 2:
 * 
 * Input: n = 1
 * Output: 1
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 9
 * 
 */

public class N_Queens_2 {

    private int count = 0;

    private void solve(int col, int n, char[][] cell, int[] leftrow, int[] lowerdia, int[] upperdia) {
        if (col == n) {
            count++;
            return;
        }
        for (int row = 0; row < n; row++) {
            if (leftrow[row] == 0 && lowerdia[col + row] == 0 && upperdia[n - 1 - row + col] == 0) {
                cell[row][col] = 'Q';
                leftrow[row] = 1;
                lowerdia[col + row] = 1;
                upperdia[n - 1 - row + col] = 1;

                solve(col + 1, n, cell, leftrow, lowerdia, upperdia);

                cell[row][col] = '.';
                leftrow[row] = 0;
                lowerdia[col + row] = 0;
                upperdia[n - 1 - row + col] = 0;
            }
        }
    }

    public int totalNQueens(int n) {
        char[][] cell = new char[n][n];

        for (int i = 0; i < cell.length; i++) {
            for (int j = 0; j < cell.length; j++) {
                cell[i][j] = '.';
            }
        }
        int[] leftrow = new int[n];
        int[] lowerdia = new int[n + n - 1];
        int[] upperdia = new int[n + n - 1];

        solve(0, n, cell, leftrow, lowerdia, upperdia);

        return count;
    }
}
