#include <bits/stdc++.h>
using namespace std;
class Solution
{
private:
    long long dfs(int node, vector<vector<int>> &adj, vector<bool> &visited)
    {
        visited[node] = true;
        long long count = 1;
        for (auto next : adj[node])
        {
            if (visited[next])
            {
                continue;
            }
            count += dfs(next, adj, visited);
        }
        return count;
    }

public:
    long long countPairs(int n, vector<vector<int>> &edges)
    {
        vector<vector<int>> adj(n, vector<int>());
        vector<bool> visited(n, false);
        vector<long long> componentSizes;

        long long ans = 0;
        long long postfix = 0;

        for (auto edge : edges)
        {
            adj[edge[0]].push_back(edge[1]);
            adj[edge[1]].push_back(edge[0]);
        }

        long long temp = 0;
        for (int node = 0; node < n; node++)
        {
            if (visited[node])
            {
                continue;
            }
            temp = dfs(node, adj, visited);
            ans += (postfix * temp);
            postfix = temp + postfix;
        }
        ans += (postfix * temp);
        return ans;
    }
};