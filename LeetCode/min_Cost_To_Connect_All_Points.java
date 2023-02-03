
/**
You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].

The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.

Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.



Example 1:


Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
Output: 20
Explanation:

We can connect the points as shown above to get the minimum cost of 20.
Notice that there is a unique path between every pair of points.
Example 2:

Input: points = [[3,12],[-2,5],[-4,1]]
Output: 18


Constraints:

1 <= points.length <= 1000
-106 <= xi, yi <= 106
All pairs (xi, yi) are distinct.
*/

/**

*/

import java.util.*;
import java.io.*;

class Solution {
    private class DisJointSet {
        int[] parent, rank;

        DisJointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int findUltParent(int x) {
            if (x == parent[x])
                return x;
            return parent[x] = findUltParent(parent[x]);
        }

        void unionByRank(int u, int v) {
            int ulp_u = findUltParent(u);
            int ulp_v = findUltParent(v);
            if (rank[ulp_u] < rank[ulp_v]) {
                parent[ulp_u] = ulp_v;
            } else if (rank[ulp_v] < rank[ulp_u]) {
                parent[ulp_v] = ulp_u;
            } else {
                parent[ulp_v] = ulp_u;
                rank[ulp_u]++;
            }
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x1 = points[i][0], y1 = points[i][1];
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                int x2 = points[j][0], y2 = points[j][1];
                int cost = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                edges.add(new ArrayList<Integer>(List.of(cost, i, j)));
            }
        }
        Collections.sort(edges, (a, b) -> a.get(0) - b.get(0));
        DisJointSet djs = new DisJointSet(n);
        n = edges.size();
        int mstSum = 0;
        for (int i = 0; i < n; i++) {
            int u = edges.get(i).get(1), v = edges.get(i).get(2), cost = edges.get(i).get(0);
            if (djs.findUltParent(u) == djs.findUltParent(v))
                continue;
            djs.unionByRank(u, v);
            mstSum += cost;
        }
        return mstSum;
    }
}
