/**
Given an m*n binary matrix mat, return the number of distinct island.

An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.

Sample Input
3 3
1 0 0
0 1 0
1 1 1
Sample Output
2

Constraints
1<= n <= 1000
1<= e <= n*(n-1)/2
 *
 */

#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
    void dfs(vector<vector<int>> &grid, vector<vector<bool>> &vis, vector<int> &del, string &cor, int i, int j, int &m, int &n, int &x, int &y)
    {
        if (i < 0 || i >= m || j < 0 || j >= n || (vis[i][j]) || (grid[i][j] == 0))
            return;
        vis[i][j] = true;
        cor.push_back(i - x);
        cor.push_back(j - y);
        for (int l = 0; l < 4; l++)
        {
            dfs(grid, vis, del, cor, i + del[l], j + del[l + 1], m, n, x, y);
        }
    }

public:
    int countDistinctIslands(vector<vector<int>> &grid)
    {
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<bool>> vis(m, vector<bool>(n, false));
        vector<int> del = {-1, 0, 1, 0, -1};
        unordered_set<string> distinctIslands;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (!vis[i][j] && (grid[i][j]==1))
                {
                    string temp;
                    dfs(grid, vis, del, temp, i, j, m, n, i, j);
                    distinctIslands.insert(temp);
                }
            }
        }
        return distinctIslands.size();
    }
};