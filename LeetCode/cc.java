
/**

*/

import java.util.*;

public class cc {
    private List<Integer> kahnsAlgo(List<List<Integer>> adj, int n) {
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (Integer it : adj.get(i)) {
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }
        List<Integer> arr = new ArrayList<>();
        while (!q.isEmpty()) {
            Integer node = q.poll();
            arr.add(node);
            for (Integer it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0){
                    q.offer(it);}
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = 3;
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
      
        adj.add(temp);
        List<Integer> temp1 = new ArrayList<>();

        adj.add(temp1);
        List<Integer> temp2 = new ArrayList<>();
        temp2.add(1);

        adj.add(temp2);
        System.out.println((new cc().kahnsAlgo(adj, n)).toString());
    }
}
