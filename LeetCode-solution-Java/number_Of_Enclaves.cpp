/**
You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.

Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.



Example 1:


Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
Output: 3
Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.
Example 2:


Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
Output: 0
Explanation: All 1s are either on the boundary or can reach the boundary.


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 500
grid[i][j] is either 0 or 1.
 *
 */
#include <bits/stdc++.h>
using namespace std;
class Solution
{

private:
    void dfs(vector<vector<int>> &grid, vector<vector<bool>> &vis, vector<int> &del, int i, int j, int &m, int &n)
    {
        if (i < 0 || i >= m || j < 0 || j >= n || (vis[i][j] == true) || (grid[i][j] == 0))
            return;
        vis[i][j] = true;
        for (int x = 0; x < 4; x++)
        {
            dfs(grid, vis, del, i+del[x], j+del[x+1], m, n);
        }
    }

public:
    int numEnclaves(vector<vector<int>> &grid)
    {
        int m = grid.size();
        int n = grid[0].size();
        int count = 0;
        vector<vector<bool>> vis(m, vector<bool>(n, false));
        vector<int> del = {-1, 0, 1, 0, -1};
        for (int i = 0; i < n; i++)
        {
            dfs(grid, vis, del, 0, i, m, n);
            dfs(grid, vis, del, m - 1, i, m, n);
        }
        for (int i = 1; i < m - 1; i++)
        {
            dfs(grid, vis, del, i, 0, m, n);
            dfs(grid, vis, del, i, n - 1, m, n);
        }

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] == 1 && vis[i][j] == false)
                {
                    count++;
                }
            }
        }

        return count;
    }
};