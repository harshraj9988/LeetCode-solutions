
/**
 * You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.
 */

import java.util.*;

public class rotting_Oranges {
    public int _orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        int[] del = new int[] { -1, 0, 1, 0, -1 };

        while (rotNeighbourOranges(grid, del, m, n))
            count++;

        for (int[] oranges : grid) {
            for (int orange : oranges) {
                if (orange == 1)
                    return -1;
            }
        }

        return count;
    }

    private boolean rotNeighbourOranges(int[][] oranges, int[] del, int rowOranges, int colOranges) {
        boolean hasFreshOranges = false;

        ArrayList<int[]> turnedRot = new ArrayList<>();

        for (int i = 0; i < rowOranges; i++) {
            for (int j = 0; j < colOranges; j++) {
                if (oranges[i][j] != 2)
                    continue;
                for (int x = 0; x < 4; x++) {
                    int dx = i + del[x];
                    int dy = j + del[x + 1];
                    if (dx >= 0 && dx < rowOranges &&
                            dy >= 0 && dy < colOranges &&
                            oranges[dx][dy] == 1) {
                        hasFreshOranges = true;
                        turnedRot.add(new int[] { dx, dy });
                    }
                }
            }
        }

        for (int[] rottenOrange : turnedRot) {
            oranges[rottenOrange[0]][rottenOrange[1]] = 2;
        }

        return hasFreshOranges;
    }

    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i,j,0});
                }
            }
        }

        int[] del = new int[] { -1, 0, 1, 0, -1 };

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- >0){
                int[] orange = queue.poll();
                count = Math.max(count, orange[2]);
                for(int i=0; i<4; i++){
                    int dx = orange[0]+del[i];
                    int dy = orange[1]+del[i+1];
                    if(
                        dx >= 0 && dx < m &&
                            dy >= 0 && dy < n &&
                            grid[dx][dy] == 1
                    ) {
                        grid[dx][dy] = 2;
                        queue.offer(new int[]{dx, dy, orange[2]+1});
                    }
                }
            }
        }

        for (int[] oranges : grid) {
            for (int orange : oranges) {
                if (orange == 1)
                    return -1;
            }
        }

        return count;
    }

}
