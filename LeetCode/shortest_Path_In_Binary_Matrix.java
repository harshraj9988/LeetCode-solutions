/**
 * Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.

 

Example 1:


Input: grid = [[0,1],[1,0]]
Output: 2
Example 2:


Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4
Example 3:

Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
Output: -1
 

Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 100
grid[i][j] is 0 or 1
 */
import java.util.*;
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        for(int i = 0; i<m; i++) for(int j = 0; j<n; j++) dist[i][j] = Integer.MAX_VALUE;
        dist[0][0] = 1;
        pq.add(new Pair(0, 0, 1));
        int[] dx = new int[]{  1,  1,  0, -1, -1, -1,  0,  1};
        int[] dy = new int[]{  0,  1,  1,  1,  0, -1, -1, -1};
        while(!pq.isEmpty()) {
            int x = pq.peek().x;
            int y = pq.peek().y;
            int dis = pq.remove().dist;
            
            for(int i=0; i<8; i++) {
                int nx = x + dx[i], ny = y + dy[i], nDis = dis + 1;
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 0 && nDis < dist[nx][ny]) {
                    dist[nx][ny] = nDis;
                    pq.add(new Pair(nx, ny, nDis));
                }
            }
        }
        
        return (dist[m-1][n-1] == Integer.MAX_VALUE) ? -1 : dist[m-1][n-1];
    }
    
    private class Pair{
        int x, y, dist;
        Pair(int x, int y, int dist) {
            this.x = x; this.y = y; this.dist = dist;
        }
    }
}