/**
On a 2D plane, we place n stones at some integer coordinate points. Each coordinate point may have at most one stone.

A stone can be removed if it shares either the same row or the same column as another stone that has not been removed.

Given an array stones of length n where stones[i] = [xi, yi] represents the location of the ith stone, return the largest possible number of stones that can be removed.

 

Example 1:

Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
Output: 5
Explanation: One way to remove 5 stones is as follows:
1. Remove stone [2,2] because it shares the same row as [2,1].
2. Remove stone [2,1] because it shares the same column as [0,1].
3. Remove stone [1,2] because it shares the same row as [1,0].
4. Remove stone [1,0] because it shares the same column as [0,0].
5. Remove stone [0,1] because it shares the same row as [0,0].
Stone [0,0] cannot be removed since it does not share a row/column with another stone still on the plane.
Example 2:

Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
Output: 3
Explanation: One way to make 3 moves is as follows:
1. Remove stone [2,2] because it shares the same row as [2,0].
2. Remove stone [2,0] because it shares the same column as [0,0].
3. Remove stone [0,2] because it shares the same row as [0,0].
Stones [0,0] and [1,1] cannot be removed since they do not share a row/column with another stone still on the plane.
Example 3:

Input: stones = [[0,0]]
Output: 0
Explanation: [0,0] is the only stone on the plane, so you cannot remove it.
 

Constraints:

1 <= stones.length <= 1000
0 <= xi, yi <= 104
No two stones are at the same coordinate point.
*/

import java.util.*;
import java.io.*;
class Solution {
    public int removeStones(int[][] stones) {
        HashMap<String, ArrayList<String>> adjMap = new HashMap<>();
        int n = stones.length;
        TreeSet<String> nodes = new TreeSet<>();
        HashSet<String> vis = new HashSet<>();
        for(int i=0; i<n; i++) {
            int r = stones[i][0], c = stones[i][1];
            String node = getNode(stones[i]);
            nodes.add(node);
            if(!adjMap.containsKey(node)) adjMap.put(node, new ArrayList<String>());
            for(int j=0; j<n; j++) {
                if(i==j) continue;
                if(stones[j][0]==r || stones[j][1]==c) {
                    adjMap.get(node).add(getNode(stones[j]));
                }
            }
        }
        int count = 0;
        for(String node: nodes) {
            if(!vis.contains(node)){
                vis.add(node);
                count++;
                dfs(adjMap, node, vis);
            }
        }
        return n-count;
    }
    
    private void dfs(HashMap<String, ArrayList<String>> adjMap, String node, HashSet<String> vis) {
        for(String next: adjMap.get(node)) {
            if(!vis.contains(next)) {
                vis.add(next);
                dfs(adjMap, next, vis);
            }
        }
        
    }
    
    private String getNode(int[] x) {
        StringBuilder sb = new StringBuilder();
        sb.append('r');
        sb.append(x[0]);
        sb.append('c');
        sb.append(x[1]);
        return sb.toString();
    }
}