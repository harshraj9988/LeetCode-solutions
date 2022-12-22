import java.util.*;
import java.io.*;

public class cc {

    public boolean isPossible(int n, List<List<Integer>> edges) {
        ArrayList<HashSet<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new HashSet<>());
        int[] degree = new int[n];
        for (List<Integer> edge : edges) {
            int x = edge.get(0) - 1;
            int y = edge.get(1) - 1;
            adj.get(x).add(y);
            adj.get(y).add(x);
            degree[x]++;
            degree[y]++;
        }
        int odds = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] % 2 == 1) {
                if (odds == 4)
                    return false;
                temp.add(i);
                odds++;
            }
        }
        if(odds == 0) return true;
        if(!(odds==2 || odds == 4)){
            return false;
        }
        if(odds==2){
            int a = temp.get(0);
            int b = temp.get(1);
            if(adj.get(a).contains(b)){
                for(int i=0; i<n; i++) {
                    if(i==a || i==b) continue;
                    if(!adj.get(a).contains(i) && !adj.get(b).contains(i)) return true;
                }
            }else{
                return true;
            }
        }
        else{
            int a = temp.get(0);
            int b = temp.get(1);
            int c = temp.get(2);
            int d = temp.get(3);

            return !adj.get(a).contains(b) && !adj.get(c).contains(d) || 
            !adj.get(a).contains(d) && !adj.get(c).contains(b) || 
            !adj.get(a).contains(c) && !adj.get(b).contains(d) ;

        }

        return false;

    }

    public int[] cycleLengthQueries(int n, int[][] queries) {
        n = queries.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> a = temp(queries[i][0]), b = temp(queries[i][1]);

            int z = 0;
            boolean notFound = false;
            while (z < a.size() && z < b.size()) {
                if(a.get(z)==b.get(z)) z++;
                else{
                    z++;
                    notFound = true;
                }
            }
            int c = 0;
            if (notFound)
                c = a.size() + b.size() - 1;
            else
                c = a.size() - z + b.size() - z + 1;
            ans[i] = c;
        }
        return ans;
    }

    private ArrayList<Integer> temp(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        while (n > 0) {
            ans.add(n);
            n /= 2;
        }
        int i = 0;
        int j = ans.size() - 1;
        while (i < j) {
            int temp = ans.get(i);
            ans.set(i, ans.get(j));
            ans.set(j, temp);
            i++;
            j--;
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {

    }
}