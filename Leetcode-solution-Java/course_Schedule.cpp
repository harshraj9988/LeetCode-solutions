/**
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.



Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.


Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.
*/

#include <bits/stdc++.h>
using namespace std;
class Solution
{
private:
    bool kahnsAlgo(vector<vector<int>> adj, int n) {
        vector<int> indegree(n, 0);
        for(int i=0; i<n; i++) {
            for(int j: adj[i]) {
                indegree[j]++;
            }
        }
        queue<int> q;
        for(int i=0; i<n; i++) {
            if(!indegree[i]) q.push(i);
        }

        int count = 0;
        while(!q.empty()) {
            int node = q.front();
            count++;
            q.pop();
            for(int it: adj[node]) {
                indegree[it]--;
                if(!indegree[it]) q.push(it);
            }
        }
        return count==n;
    }

public:
    bool canFinish(int numCourses, vector<vector<int>> &prerequisites)
    {
        vector<vector<int>> adj(numCourses);
        for (vector<int> i : prerequisites)
        {
            adj[i[1]].push_back(i[0]);
        }
        
        return kahnsAlgo(adj, numCourses);
    }
};