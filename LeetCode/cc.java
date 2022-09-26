
/**

*/

import java.util.*;

class Solution {

    // Question 1
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(heights[i], names[i]);
        }
        Arrays.sort(heights);
        int z = 0;
        for (int i = n - 1; i >= 0; i--) {
            names[z++] = map.get(heights[i]);
        }
        return names;
    }

    // Question 2
    public int longestSubarray(int[] nums) {
        int m = 0;
        int l = 0;
        int maxAnd = Arrays.stream(nums).max().getAsInt();
        for (int i : nums) {
            if (i == maxAnd)
                l++;
            else {
                m = Math.max(l, m);
                l = 0;
            }
        }
        m = Math.max(l, m);
        return m;
    }

    // Question 3
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        int[] left = new int[n];
        Arrays.fill(left, 1);
        int[] right = new int[n];
        Arrays.fill(right, 1);
        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[i - 1]) {
                left[i] += left[i - 1];
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1]) {
                right[i] += right[i + 1];
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = k; i < (n - k); i++) {
            if (left[i - 1] >= k && right[i + 1] >= k)
                list.add(i);
        }
        return list;
    }


    // Question 4
    //TODO: wrong code
    
    int ans = 0;
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        createAdj(adj, edges);
        int n = vals.length;
        for (int i = 0; i < n; i++) {
            boolean[] vis = new boolean[n];
            dfs(i, adj, vals[i], vals, vis);
        }
        return ans;
    }

    private void dfs(int val, Map<Integer, List<Integer>> adj, int start, int[] vals, boolean[] vis) {
        if(vals[val]==start) ans++;
       
            vis[val] = true;
            
        if (adj.get(val) != null)

        for (Integer i : adj.get(val)) {
            if (i <= start && vis[i] == false) {
                dfs(i, adj, start, vals, vis);
            }
        }

    }

    private void createAdj(Map<Integer, List<Integer>> adj, int[][] edges) {
        for (int[] edge : edges) {
            if (adj.containsKey(edge[0])) {
                adj.get(edge[0]).add(edge[1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(edge[1]);
                adj.put(edge[0], list);
            }
            if (adj.containsKey(edge[1])) {
                adj.get(edge[1]).add(edge[0]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(edge[0]);
                adj.put(edge[1], list);
            }
        }
    }
}




public class cc {

    

    public static void main(String[] args) {

    }
}