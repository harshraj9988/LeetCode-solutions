/**
You are given a positive integer k. You are also given:

a 2D integer array rowConditions of size n where rowConditions[i] = [abovei, belowi], and
a 2D integer array colConditions of size m where colConditions[i] = [lefti, righti].
The two arrays contain integers from 1 to k.

You have to build a k x k matrix that contains each of the numbers from 1 to k exactly once. The remaining cells should have the value 0.

The matrix should also satisfy the following conditions:

The number abovei should appear in a row that is strictly above the row at which the number belowi appears for all i from 0 to n - 1.
The number lefti should appear in a column that is strictly left of the column at which the number righti appears for all i from 0 to m - 1.
Return any matrix that satisfies the conditions. If no answer exists, return an empty matrix.



Example 1:


Input: k = 3, rowConditions = [[1,2],[3,2]], colConditions = [[2,1],[3,2]]
Output: [[3,0,0],[0,0,1],[0,2,0]]
Explanation: The diagram above shows a valid example of a matrix that satisfies all the conditions.
The row conditions are the following:
- Number 1 is in row 1, and number 2 is in row 2, so 1 is above 2 in the matrix.
- Number 3 is in row 0, and number 2 is in row 2, so 3 is above 2 in the matrix.
The column conditions are the following:
- Number 2 is in column 1, and number 1 is in column 2, so 2 is left of 1 in the matrix.
- Number 3 is in column 0, and number 2 is in column 1, so 3 is left of 2 in the matrix.
Note that there may be multiple correct answers.
Example 2:

Input: k = 3, rowConditions = [[1,2],[2,3],[3,1],[2,3]], colConditions = [[2,1]]
Output: []
Explanation: From the first two conditions, 3 has to be below 1 but the third conditions needs 3 to be above 1 to be satisfied.
No matrix can satisfy all the conditions, so we return the empty matrix.


Constraints:

2 <= k <= 400
1 <= rowConditions.length, colConditions.length <= 104
rowConditions[i].length == colConditions[i].length == 2
1 <= abovei, belowi, lefti, righti <= k
abovei != belowi
lefti != righti
*/

#include <bits/stdc++.h>
using namespace std;
class Solution
{
private:
    bool isCycle(vector<vector<int>> &adj, vector<bool> &vis, int node, vector<bool> &pathVis)
    {
        vis[node] = true;
        pathVis[node] = true;
        for (int it : adj[node])
        {
            if (!vis[it])
            {
                if (isCycle(adj, vis, it, pathVis))
                    return true;
            }
            else if (pathVis[it])
            {
                return true;
            }
        }

        pathVis[node] = false;
        return false;
    }

    bool findCycle(vector<vector<int>> adj, int n)
    {
        vector<bool> vis(n, false);
        vector<bool> pathVis(n, false);
        for (int i = 0; i < n; i++)
        {
            if (!vis[i])
            {
                if (isCycle(adj, vis, i, pathVis))
                    return true;
            }
        }
        return false;
    }

    void dfs(vector<vector<int>> &adj, vector<bool> &vis, int node, stack<int> &st)
    {
        vis[node] = true;
        for (auto it : adj[node])
        {
            if (!vis[it])
            {
                dfs(adj, vis, it, st);
            }
        }
        st.push(node);
    }

    vector<int> topoSort(vector<vector<int>> &adj)
    {
        int n = adj.size();
        vector<bool> vis(n, false);
        stack<int> st;
        for (int i = 0; i < n; i++)
        {
            if (!vis[i])
            {
                dfs(adj, vis, i, st);
            }
        }
        vector<int> arr;
        while (!st.empty())
        {
            arr.push_back(st.top());
            st.pop();
        }
        return arr;
    }

public:
    vector<vector<int>> buildMatrix(int k, vector<vector<int>> &rowConditions, vector<vector<int>> &colConditions)
    {
        vector<vector<int>> col(k);
        vector<vector<int>> row(k);
        for (vector<int> v : colConditions)
        {
            col[v[0]-1].push_back(v[1]-1);
        }
        for (vector<int> v : rowConditions)
        {
            row[v[0]-1].push_back(v[1]-1);
        }
        if (findCycle(col, k) || findCycle(row, k))
            return vector<vector<int>>();

        vector<int> arrangedRow = topoSort(row);
        vector<int> arrangedCol = topoSort(col);

        map<int, int> colPos;
        for (int i = 0; i < k; i++)
        {
            colPos[arrangedCol[i]] = i;
        }

        vector<vector<int>> mat(k, vector<int>(k, 0));
        
        for (int i = 0; i < k; i++)
        {
            mat[i][colPos[arrangedRow[i]]] = arrangedRow[i]+1;
        }

        return mat;
    }
};