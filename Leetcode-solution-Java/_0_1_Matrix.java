import java.util.*;

/**
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for
 * each cell.
 * 
 * The distance between two adjacent cells is 1.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: [[0,0,0],[0,1,0],[0,0,0]]
 * Example 2:
 * 
 * 
 * Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
 * Output: [[0,0,0],[0,1,0],[1,2,1]]
 * 
 * 
 * Constraints:
 * 
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * mat[i][j] is either 0 or 1.
 * There is at least one 0 in mat.
 */

public class _0_1_Matrix {
    public int[][] updateMatrix(int[][] mat) {
        int[] dim = new int[] { mat.length, mat[0].length };
        int[] del = new int[] { -1, 0, 1, 0, -1 };
        int[][] dist = new int[dim[0]][dim[1]];
        nearestZero(mat, del, dim, dist);
        return dist;
    }

    private void nearestZero(int[][] mat, int[] del, int[] dim, int[][] dist) {
        int[][] vis = new int[dim[0]][dim[1]];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < dim[0]; i++) {
            for (int j = 0; j < dim[1]; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[] { i, j, 0 });
                    vis[i][j] = 1;
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] curr = queue.poll();
                for (int x = 0; x < 4; x++) {
                    int dx = curr[0] + del[x];
                    int dy = curr[1] + del[x + 1];
                    int dis = curr[2] + 1;
                    if (dx >= 0 && dx < dim[0] &&
                            dy >= 0 && dy < dim[1] && vis[dx][dy] == 0) {
                        vis[dx][dy] = 1;
                        if (mat[dx][dy] == 1) {
                            dist[dx][dy] = dis;
                            queue.offer(new int[]{dx, dy, dis});
                        }
                    }

                }
            }
        }
    }
}
