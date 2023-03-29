#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
    int recursion(int x, int y, vector<vector<int>> &grid, int m, int n)
    {
        if (x < 0 || y < 0)
        {
            return int(4e6);
        }
        if (x == 0 && y == 0)
        {
            return grid[0][0];
        }
        int left = recursion(x - 1, y, grid, m, n);
        int up = recursion(x, y-1, grid, m, n);
        return grid[x][y] + min(left, up);
    }

    int memoization(int x, int y, vector<vector<int>> &grid, int m, int n, vector<vector<int>> &dp)
    {
        if (x < 0 || y < 0)
        {
            return int(4e6);
        }
        if (x == 0 && y == 0)
        {
            return grid[0][0];
        }
        if(dp[x][y] != -1) 
        {
            return dp[x][y];
        }
        int left = memoization(x - 1, y, grid, m, n, dp);
        int up = memoization(x, y-1, grid, m, n, dp);
        return dp[x][y] = grid[x][y] + min(left, up);
    }

    int tabulation(vector<vector<int>> &grid, int m, int n)
    {
        vector<vector<int>> dp(m+1, vector<int> (n+1, 0));
        for(int i=0; i<=m; i++) dp[i][0] = 4e6;
        for(int i=0; i<=n; i++) dp[0][i] = 4e6;
        dp[1][1] = grid[0][0];
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                int left = dp[i-1][j];
                int up = dp[i][j-1];
                dp[i][j] = grid[i-1][j-1] + min(left, up);
            }
        }

        return dp[m][n];
    }

    int spaceOptimization(vector<vector<int>> &grid, int m, int n)
    {
        vector<int> prev(n+1, 0);
        for(int i=2; i<=n; i++) prev[i] = 4e6;
        
        for(int i=1; i<=m; i++){
            vector<int> curr(n+1, 0);
            curr[0] = 4e6;
            for(int j=1; j<=n; j++){
                int left = prev[j];
                int up = curr[j-1];
                curr[j] = grid[i-1][j-1] + min(left, up);
            }
            prev = curr;
        }

        return prev[n];
    }

public:
    int minPathSum(vector<vector<int>> &grid)
    {
        int m = grid.size();
        int n = grid[0].size();
        return spaceOptimization(grid, m, n);
        // vector<vector<int>> dp(m, vector<int>(n, -1));
        // return memoization(m - 1, n - 1, grid, m, n, dp);
    }
};