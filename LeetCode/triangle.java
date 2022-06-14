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

    Integer[][] check;

    private int solve(List<List<Integer>> triangle, int i, int j) {
        if (check[i][j] != null)
            return check[i][j];

        int minPathLength = triangle.get(i).get(j);
        if (i < triangle.size() - 1) {
            int currPathLeft = solve(triangle, i + 1, j);
            int currPathRight = solve(triangle, i + 1, j + 1);

            minPathLength += (currPathLeft < currPathRight) ? currPathLeft : currPathRight;
        }
        check[i][j] = minPathLength;
        return minPathLength;
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        check = new Integer[triangle.size()][triangle.size()];
        return solve(triangle, 0, 0);
    }

}
