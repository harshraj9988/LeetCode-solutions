
/**
You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+'). You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.

In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze. Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze. The entrance does not count as an exit.

Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.

 

Example 1:


Input: maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance = [1,2]
Output: 1
Explanation: There are 3 exits in this maze at [1,0], [0,2], and [2,3].
Initially, you are at the entrance cell [1,2].
- You can reach [1,0] by moving 2 steps left.
- You can reach [0,2] by moving 1 step up.
It is impossible to reach [2,3] from the entrance.
Thus, the nearest exit is [0,2], which is 1 step away.
Example 2:


Input: maze = [["+","+","+"],[".",".","."],["+","+","+"]], entrance = [1,0]
Output: 2
Explanation: There is 1 exit in this maze at [1,2].
[1,0] does not count as an exit since it is the entrance cell.
Initially, you are at the entrance cell [1,0].
- You can reach [1,2] by moving 2 steps right.
Thus, the nearest exit is [1,2], which is 2 steps away.
Example 3:


Input: maze = [[".","+"]], entrance = [0,0]
Output: -1
Explanation: There are no exits in this maze.
 

Constraints:

maze.length == m
maze[i].length == n
1 <= m, n <= 100
maze[i][j] is either '.' or '+'.
entrance.length == 2
0 <= entrancerow < m
0 <= entrancecol < n
entrance will always be an empty cell.
*/

import java.util.*;
import java.io.*;

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] dist = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = (int) 1e8;
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && (entrance[0] != i || entrance[1] != j)
                        && maze[i][j] == '.') {
                    dist[i][j] = 0;
                    q.add(new int[] { i, j });
                }
            }
        }
        int[] dx = new int[] { -1, 0, 1, 0 };
        int[] dy = new int[] { 0, 1, 0, -1 };

        while (!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.poll()[1];
            if (x == entrance[0] && y == entrance[1])
                break;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int dis = dist[x][y] + 1;
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && maze[nx][ny] == '.' && dis < dist[nx][ny]) {
                    dist[nx][ny] = dis;
                    q.add(new int[] { nx, ny });
                }
            }
        }

        return (dist[entrance[0]][entrance[1]] == (int) 1e8) ? -1 : dist[entrance[0]][entrance[1]];
    }
}