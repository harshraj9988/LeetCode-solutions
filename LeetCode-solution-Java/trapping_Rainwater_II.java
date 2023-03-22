
/**
Given an m x n integer matrix heightMap representing the height of each unit cell in a 2D elevation map, return the volume of water it can trap after raining.



Example 1:


Input: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
Output: 4
Explanation: After the rain, water is trapped between the blocks.
We have two small ponds 1 and 3 units trapped.
The total volume of water trapped is 4.
Example 2:


Input: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
Output: 10

*/

import java.util.*;

public class trapping_Rainwater_II {
    public int trapRainWater(int[][] h) {
        int water = 0;
        int m = h.length;
        int n = h[0].length;
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(vis[i], false);
        }
        if (n < 3 || m < 3)
            return 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < m; i++) {
            pq.add(new int[] { h[i][0], i, 0 });
            vis[i][0] = true;
            pq.add(new int[] { h[i][n - 1], i, n - 1 });
            vis[i][n-1] = true;
        }
        for (int j = 1; j < n - 1; j++) {
            pq.add(new int[] { h[0][j], 0, j });
            vis[0][j] = true;
            pq.add(new int[] { h[m - 1][j], m - 1, j });
            vis[m-1][j] = true;
        }

        int[] del = new int[] { -1, 0, 1, 0, -1 };

        int level = 0;
        while(!pq.isEmpty()){
            level = Math.max(level, pq.peek()[0]);
            int x = pq.peek()[1];
            int y = pq.poll()[2];
            for(int d = 0; d<4; d++){
                int dx = x+del[d], dy = y+del[d+1];
                if(dx>=0 && dx<m && dy>=0 && dy<n && vis[dx][dy]==false) {
                    vis[dx][dy] = true;
                    pq.add(new int[]{h[dx][dy], dx, dy});
                    if(level>h[dx][dy]){
                        water += level - h[dx][dy];
                    }
                }
            }
        }

        return water;
    }
}