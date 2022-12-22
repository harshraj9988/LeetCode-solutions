
import java.util.*;
import java.io.*;
import java.util.Map.Entry;

class Solution {
    int[] parent;
    int[] rank;

    private int findParent(int u) {
        if (u == parent[u])
            return u;
        return parent[u] = findParent(parent[u]);
    }

    private void union(int u, int v) {
        int U = findParent(u);
        int V = findParent(v);
        if (rank[U] < rank[V]) {
            parent[U] = V;
        } else if (rank[V] < rank[U]) {
            parent[V] = U;
        } else {
            parent[V] = U;
            rank[U]++;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Integer> emailsToInts = new HashMap<>();
        HashMap<Integer, String> intsToEmails = new HashMap<>();
        int x = 0;
        int n = accounts.size();
        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            int m = account.size();
            for (int j = 1; j < m; j++) {
                String email = account.get(j);
                boolean alreadyMapped = emailsToInts.containsKey(email);
                if (alreadyMapped)
                    continue;
                emailsToInts.put(email, x);
                intsToEmails.put(x++, email);
            }
        }
        String[] names = new String[x];
        ArrayList<ArrayList<Integer>> connections = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            String name = account.get(0);
            int m = account.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 1; j < m; j++) {
                int ind = emailsToInts.get(account.get(j));
                names[ind] = name;
                temp.add(ind);
            }
            connections.add(temp);
        }
        parent = new int[x];
        rank = new int[x];
        for (int i = 0; i < x; i++)
            parent[i] = i;

        for (ArrayList<Integer> connection : connections) {
            int z = connection.size();
            for (int i = 0; i < z; i++) {
                for (int j = i + 1; j < z; j++) {
                    union(connection.get(i), connection.get(j));
                }
            }
        }

        for (int i = 0; i < x; i++)
            parent[i] = findParent(i);

        HashMap<Integer, TreeSet<String>> map = new HashMap<>();
        for (int i = 0; i < x; i++) {
            if (!map.containsKey(parent[i])) {
                map.put(parent[i], new TreeSet<String>());
            }
            map.get(parent[i]).add(intsToEmails.get(i));
        }
        List<List<String>> ans = new ArrayList<>();
        for (Entry<Integer, TreeSet<String>> entry : map.entrySet()) {
            String name = names[entry.getKey()];
            TreeSet<String> emails = entry.getValue();
            List<String> temp = new ArrayList<>();
            temp.add(name);
            for (String email : emails) {
                temp.add(email);
            }
            ans.add(temp);
        }
        return ans;
    }
}