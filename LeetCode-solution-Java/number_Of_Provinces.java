import java.util.*;

/**
 * There are n cities. Some of them are connected, while some are not. If city a
 * is connected directly with city b, and city b is connected directly with city
 * c, then city a is connected indirectly with city c.
 * 
 * A province is a group of directly or indirectly connected cities and no other
 * cities outside of the group.
 * 
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the
 * ith city and the jth city are directly connected, and isConnected[i][j] = 0
 * otherwise.
 * 
 * Return the total number of provinces.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 * Example 2:
 * 
 * 
 * Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] is 1 or 0.
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 * Accepted
 * 516,762
 * Submissions
 * 
 */
public class number_Of_Provinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];

        int provinces = 0;
        for (int source = 0; source < n; source++) {
            if (vis[source] == false) {
                provinces++;
                dfs(source, n, isConnected, vis);
            }
        }

        return provinces;
    }

    private void dfs(int source, int n, int[][] adj, boolean[] vis) {

        vis[source] = true;
        for (int dest = 0; dest < n; dest++) {
            if (source != dest && adj[source][dest] == 1 && vis[dest] == false) {
                dfs(dest, n, adj, vis);
            }
        }
    }
}
