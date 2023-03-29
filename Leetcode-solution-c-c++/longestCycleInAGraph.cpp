#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
    int dfs(int node, vector<int> &edges, vector<bool> &vis, int depth, int par)
    {
        if (node == -1)
        {
            return -1;
        }
        if (vis[node])
        {
            return (node == par) ? depth : -1;
        }
        vis[node] = true;
        int temp = dfs(edges[node], edges, vis, depth+1, par);
        if(temp == -1)
        {
            vis[node] = false;
        }
        return temp;
    }

public:
    int longestCycle(vector<int> &edges)
    {
        int n = edges.size();
        int ans = -1;
        vector<bool> vis(n, false);

        for (int node = 0; node < n; node++)
        {
            if (vis[node] || edges[node] == -1)
            {
                continue;
            }
            ans = max(ans, dfs(node, edges, vis, 0, node));
        }
        return ans;
    }
};