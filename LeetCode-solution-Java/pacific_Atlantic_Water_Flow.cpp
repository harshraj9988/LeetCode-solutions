/**
 There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).

The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.

Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.



Example 1:


Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
Explanation: The following cells can flow to the Pacific and Atlantic oceans, as shown below:
[0,4]: [0,4] -> Pacific Ocean
       [0,4] -> Atlantic Ocean
[1,3]: [1,3] -> [0,3] -> Pacific Ocean
       [1,3] -> [1,4] -> Atlantic Ocean
[1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean
       [1,4] -> Atlantic Ocean
[2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean
       [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
[3,0]: [3,0] -> Pacific Ocean
       [3,0] -> [4,0] -> Atlantic Ocean
[3,1]: [3,1] -> [3,0] -> Pacific Ocean
       [3,1] -> [4,1] -> Atlantic Ocean
[4,0]: [4,0] -> Pacific Ocean
       [4,0] -> Atlantic Ocean
Note that there are other possible paths for these cells to flow to the Pacific and Atlantic oceans.
Example 2:

Input: heights = [[1]]
Output: [[0,0]]
Explanation: The water can flow from the only cell to the Pacific and Atlantic oceans.


Constraints:

m == heights.length
n == heights[r].length
1 <= m, n <= 200
0 <= heights[r][c] <= 105
 */

#include <bits/stdc++.h>
using namespace std;
class Solution
{

private:
    void dfs(vector<vector<int>> &h, vector<vector<int>> &vis, vector<int> &dim, int i, int j, int &m, int &n, int prev)
    {
        if (i < 0 || j < 0 || i >= m || j >= n || vis[i][j] == 1 || prev > h[i][j])
            return;

        vis[i][j] = 1;
        for (int x = 0; x < 4; x++)
        {
            dfs(h, vis, dim, i + dim[x], j + dim[x + 1], m, n, h[i][j]);
        }
    }

public:
    vector<vector<int>> pacificAtlantic(vector<vector<int>> &heights)
    {
        int m = heights.size();
        int n = heights[0].size();
        vector<int> dim = {-1, 0, 1, 0, -1};
        vector<vector<int>> vis1(m, vector<int>(n, 0));
        vector<vector<int>> vis2(m, vector<int>(n, 0));
        
        
        for (int i = 0; i < n; i++)
        {
            dfs(heights, vis1, dim, 0, i, m, n, -1);
        }
        for (int i = 1; i < m; i++)
        {
            dfs(heights, vis1, dim, i, 0, m, n, -1);
        }
        

        
        for (int i = 0; i < m; i++)
        {
            dfs(heights, vis2, dim, i, n-1, m, n, -1);
        }
        for (int i = 0; i < n; i++)
        {
            dfs(heights, vis2, dim, m-1, i, m, n, -1);
        }


        
        vector<vector<int>> res;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(vis1[i][j] == 1 && vis2[i][j]==1){
                    vector<int> temp;
                    temp.push_back(i);
                    temp.push_back(j);
                    res.push_back(temp);
                }
            }
        }

        return res;
    }
};