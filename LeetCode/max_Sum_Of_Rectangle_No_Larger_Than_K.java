
/**
 * Given an m x n matrix matrix and an integer k, return the max sum of a
 * rectangle in the matrix such that its sum is no larger than k.
 * 
 * It is guaranteed that there will be a rectangle with a sum no larger than k.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix = [[1,0,1],[0,-2,3]], k = 2
 * Output: 2
 * Explanation: Because the sum of the blue rectangle [[0, 1], [-2, 3]] is 2,
 * and 2 is the max number no larger than k (k = 2).
 * Example 2:
 * 
 * Input: matrix = [[2,2,-1]], k = 3
 * Output: 3
 * 
 * 
 * Constraints:
 * 
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -100 <= matrix[i][j] <= 100
 * -105 <= k <= 105
 * 
 * 
 * Follow up: What if the number of rows is much larger than the number of
 * columns?
 */
import java.util.*;

public class max_Sum_Of_Rectangle_No_Larger_Than_K {

    // Brute Force;
    public int _maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        long[][] prefixSum = findPrefixSum(matrix);

        long maxSum = Integer.MIN_VALUE;

        for (int r1 = 0; r1 < m; r1++) {
            for (int c1 = 0; c1 < n; c1++) {
                for (int r2 = 0; r2 <= r1; r2++) {
                    for (int c2 = 0; c2 <= c1; c2++) {
                        
                        long sum = prefixSum[r1][c1] - ((r2>0)?prefixSum[r2-1][c1]:0) - ((c2>0)?prefixSum[r1][c2-1]:0)
                                + ((r2>0 && c2>0)?prefixSum[r2-1][c2-1]:0);
                        if(sum<=k)
                        maxSum = Math.max(sum, maxSum);
                    }
                }
            }
        }

        return (int)((maxSum!=Integer.MIN_VALUE)?maxSum: 0);
    }

    private long[][] findPrefixSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        long[][] prefixSum = new long[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                long sum = 0;
                if (j != 0) {
                    sum = prefixSum[i][j - 1] + matrix[i][j];
                } else {
                    sum = matrix[i][j];
                }
                prefixSum[i][j] = sum;
            }
        }

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                long sum = 0;
                if (i != 0) {
                    sum = prefixSum[i - 1][j] + prefixSum[i][j];
                } else {
                    sum = prefixSum[i][j];
                }
                prefixSum[i][j] = sum;
            }
        }
        return prefixSum;
    }




    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        long[][] prefixSum = findColPreSum(matrix);
        
        long sum = Integer.MIN_VALUE;

        for(int i=0; i<m; i++){
            for(int j = 0; j<=i; j++){
                long max = kadanesAlgo(prefixSum, j, i, k);
                if(max<=k){
                    sum = Math.max(sum, max);
                }

            }
        }
        return (int) sum;
    }

    private long kadanesAlgo(long[][] matrix, int x, int y, int k){
        int n = matrix[0].length;
        
        
        long maxSum = Integer.MIN_VALUE;
        long sum = 0;
        
        for(int i=0; i<n; i++){
           long curr = matrix[y][i]-((x>0)?matrix[x-1][i]:0);

           if(sum+curr<curr){
            sum = curr;
           }else{
            sum+=curr;
           }
            
            if(sum<=k)            
           maxSum = Math.max(sum, maxSum);
        }


        return maxSum;
    }
    
    private long[][] findColPreSum(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        long[][] prefixSum = new long[m][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                long sum = 0;
                if (i != 0) {
                    sum = prefixSum[i - 1][j] + matrix[i][j];
                } else {
                    sum = matrix[i][j];
                }
                prefixSum[i][j] = sum;
            }
        }
        return prefixSum;
    }




    public static void main(String[] args) {
        int[][] matrix = new int[][]{{2,2,-1}};
        int k = 10;
        
        new max_Sum_Of_Rectangle_No_Larger_Than_K()._maxSumSubmatrix(matrix, k);
    }
}
