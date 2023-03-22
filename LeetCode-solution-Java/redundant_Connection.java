/**
 * In this problem, a tree is an undirected graph that is connected and has no cycles.

You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.

Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.

 

Example 1:


Input: edges = [[1,2],[1,3],[2,3]]
Output: [2,3]
Example 2:


Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
Output: [1,4]
 

Constraints:

n == edges.length
3 <= n <= 1000
edges[i].length == 2
1 <= ai < bi <= edges.length
ai != bi
There are no repeated edges.
The given graph is connected.
 */
import java.util.*;

public class redundant_Connection {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        createAdjacencyMap(adj, edges);
        int[] ans = new int[2];
        bfs(adj, ans);
        return ans;
    }

    private void bfs(Map<Integer, List<Integer>> adj, int[] ans){

    }

    private void createAdjacencyMap(Map<Integer, List<Integer>> map, int[][] edges){
        for(int[] edge: edges){
            if(map.containsKey(edge[0])){
                map.get(edge[0]).add(edge[1]);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(edge[1]);
                map.put(edge[0], list);
            }
            if(map.containsKey(edge[1])){
                map.get(edge[1]).add(edge[0]);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(edge[0]);
                map.put(edge[1], list);
            }
        }
    }

    private class Pair {
        int node;
        int parent;
        Pair(int node, int parent){
            this.node = node;
            this.parent = parent;
        }
    }
}
