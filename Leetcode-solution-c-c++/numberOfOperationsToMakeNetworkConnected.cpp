#include <iostream>
#include <vector>
#include<unordered_set>
using namespace std;

class Solution
{
protected:
    int findParent(int u, vector<int> &parent)
    {
        if (u == parent[u])
        {
            return u;
        }
        return findParent(parent[u], parent);
    }

    void createUnion(int u, int v, vector<int> &parent, vector<int> &rank)
    {
        int par_u = findParent(u, parent), par_v = findParent(v, parent);
        if (par_u == par_v)
        {
            return;
        }
        int rank_u = rank[par_u], rank_v = rank[par_v];

        if (rank_u < rank_v)
        {
            parent[par_u] = par_v;
        }
        else if (rank_u > rank_v)
        {
            parent[par_v] = par_u;
        }
        else
        {
            parent[par_v] = par_u;
            rank[par_u]++;
        }
    }

public:
    int makeConnected(int n, vector<vector<int>> &connections)
    {
        vector<int> parent(n);
        vector<int> rank(n);
        for (int i = 0; i < n; i++)
        {
            parent[i] = i;
            rank[i] = 0;
        }

        int cablesRequired = n - 1;
        int cablesAvailable = connections.size();
        if (cablesAvailable < cablesRequired)
        {
            return -1;
        }

        for (vector<int> connection : connections)
        {
            createUnion(connection[0], connection[1], parent, rank);
        }

        for (int i = 0; i < n; i++)
        {
            findParent(i, parent);
        }
        unordered_set<int> s;
        for(int p : parent){
            s.insert(p);
        }
        return s.size()-1;
    }
};