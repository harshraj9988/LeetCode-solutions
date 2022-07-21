import java.util.ArrayList;
import java.util.List;

/**
 * Given a triangle array, return the minimum path sum from top to bottom.
 * 
 * For each step, you may move to an adjacent number of the row below. More
 * formally, if you are on index i on the current row, you may move to either
 * index i or index i + 1 on the next row.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * Output: 11
 * Explanation: The triangle looks like:
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined
 * above).
 * Example 2:
 * 
 * Input: triangle = [[-10]]
 * Output: -10
 * 
 * 
 * Constraints:
 * 
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 * 
 * 
 * Follow up: Could you do this using only O(n) extra space, where n is the
 * total number of rows in the triangle?
 */

public class triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        return spaceOptimization(triangle);
    }


    private int solve(List<List<Integer>> triangle, int i, int j, Integer[][] dp) {
        if (dp[i][j] != null)
            return dp[i][j];

        int minPathLength = triangle.get(i).get(j);
        if (i < triangle.size() - 1) {
            int currPathLeft = solve(triangle, i + 1, j, dp);
            int currPathRight = solve(triangle, i + 1, j + 1, dp);

            minPathLength += (currPathLeft < currPathRight) ? currPathLeft : currPathRight;
        }
        dp[i][j] = minPathLength;
        return minPathLength;
    }

    private int memoization(List<List<Integer>> triangle, int i, int j, int n, Integer[][] dp){
        if(i==n-1) return triangle.get(i).get(j);

        if(dp[i][j]!=null) return dp[i][j];
        
        int bottom = memoization(triangle, i+1, j, n, dp);
        int bottomRight = memoization(triangle, i+1, j+1, n, dp);

        return dp[i][j] = triangle.get(i).get(j)+Math.min(bottom, bottomRight);
    }

    private int tabulation(List<List<Integer>> triangle){
        int n = triangle.size();
        Integer[][] dp = new Integer[n][n];
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if(i==n-1){
                    dp[i][j] = triangle.get(i).get(j);
                }else{
                    int bottom = dp[i+1][j];
                    int bottomRight = dp[i+1][j+1];

                    dp[i][j] = triangle.get(i).get(j) + Math.min(bottom, bottomRight);
                }
            }
        }
        return dp[0][0];
    }

    private int spaceOptimization(List<List<Integer>> triangle){
        int n = triangle.size();
        int[] so = new int[n];

        for (int i = n-1; i >= 0; i--) {
            int[] curr = new int[i+1];
            for (int j = 0; j <= i; j++) {
                if(i==n-1){
                    curr[j] = triangle.get(i).get(j);
                }else{
                    int bottom = so[j];
                    int bottomRight = so[j+1];

                    curr[j] = triangle.get(i).get(j) + Math.min(bottom, bottomRight);
                }
            }
            so = curr;
        }
        return so[0];
    }
}
