#include <bits/stdc++.h>
typedef long long int ll;
using namespace std;
class Solution
{
private:
    int dfs(int node, vector<unordered_set<int>> &unidirectional, vector<unordered_set<int>> &bidirectional, vector<bool> &visited)
    {
        int count = 0;
        for (int next : bidirectional[node])
        {
            if (visited[next])
                continue;

            if (unidirectional[node].count(next) == 0)
            {
                count++;
            }
            visited[next] = true;
            count += dfs(next, unidirectional, bidirectional, visited);
        }

        return count;
    }

public:
    int minReorder(int n, vector<vector<int>> &connections)
    {
        vector<unordered_set<int>> bidirectional(n, unordered_set<int>());
        vector<unordered_set<int>> unidirectional(n, unordered_set<int>());
        vector<bool> visited(n, false);
        visited[0] = true;

        for (auto connection : connections)
        {
            unidirectional[connection[1]].insert(connection[0]);
            bidirectional[connection[0]].insert(connection[1]);
            bidirectional[connection[1]].insert(connection[0]);
        }

        return dfs(0, unidirectional, bidirectional, visited);
    }
};