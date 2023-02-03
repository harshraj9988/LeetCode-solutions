import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

class Solution {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());
        for (int[] edge : edges) {

            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
            adj.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);

        int[] parent = new int[n + 1];

        int[] distances = new int[n + 1];
        for (int i = 0; i < n; i++) {
            distances[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }

        distances[n] = 0;
        pq.add(new Pair(n, 0));

        while (!pq.isEmpty()) {
            int node = pq.peek().node;
            int dis = pq.remove().dist;

            for (Pair edge : adj.get(node)) {
                int newNode = edge.node;
                int newDis = dis + edge.dist;
                if (newDis < distances[newNode]) {
                    distances[newNode] = newDis;
                    parent[newNode] = node;
                    pq.add(new Pair(newNode, newDis));
                }
            }
        }
        List<Integer> shortestPath = new ArrayList<>();
        int ind = 1;
        if (parent[ind] == -1) {
            shortestPath.add(-1);
            return shortestPath;
        }
        while (ind != n) {
            shortestPath.add(ind);
            ind = parent[ind];
        }
        shortestPath.add(ind);
        return shortestPath;
    }

    private static class Pair {
        int node, dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
}

