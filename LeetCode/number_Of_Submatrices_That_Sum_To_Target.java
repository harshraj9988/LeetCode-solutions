import java.util.Arrays;

/**
 * Given a matrix and a target, return the number of non-empty submatrices that
 * sum to target.
 * 
 * A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x
 * <= x2 and y1 <= y <= y2.
 * 
 * Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different if
 * they have some coordinate that is different: for example, if x1 != x1'.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
 * Output: 4
 * Explanation: The four 1x1 submatrices that only contain 0.
 * Example 2:
 * 
 * Input: matrix = [[1,-1],[-1,1]], target = 0
 * Output: 5
 * Explanation: The two 1x2 submatrices, plus the two 2x1 submatrices, plus the
 * 2x2 submatrix.
 * Example 3:
 * 
 * Input: matrix = [[904]], target = 0
 * Output: 0
 * 
 * 
 * Constraints:
 * 
 * 1 <= matrix.length <= 100
 * 1 <= matrix[0].length <= 100
 * -1000 <= matrix[i] <= 1000
 * -10^8 <= target <= 10^8
 */
public class number_Of_Submatrices_That_Sum_To_Target {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int a = 100000001;

        int[][] prefixSum = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                prefixSum[i][j] = a;
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < m; k++) {
                for (int j = i; j < n; j++) {
                    for (int l = k; l < m; l++) {
                        int sum = 0;
                        if (i == 0 && k == 0) {
                            for (int x = i; x <= j; x++) {
                                for (int y = k; y <= l; y++) sum += matrix[x][y];
                            }
                            prefixSum[j][l] = sum;
                        } else {
                            int c = 0, d =0, e = 0;
                            if (k != 0) c = prefixSum[j][k - 1];
                            if (i != 0) d = prefixSum[i - 1][l];
                            if (i != 0 && k != 0) e = prefixSum[i - 1][k - 1];
                            sum = prefixSum[j][l] - c - d + e;
                        }
                        if (sum == target) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
