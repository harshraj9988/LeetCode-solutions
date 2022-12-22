import java.util.*;
import java.io.*;

class Solution {

    public int deleteGreatestValue(int[][] grid) {
        for (int[] g : grid) {
            Arrays.sort(g);
        }
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int j = n - 1; j >= 0; j--) {
            int temp = 0;
            for (int i = 0; i < m; i++) {
                temp = Math.max(grid[i][j], temp);
            }
            ans += temp;
        }
        return ans;
    }

    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        int len = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int temp = 1;
            int ind = Arrays.binarySearch(nums, nums[i] * nums[i]);
            while (ind >= 0 && ind < n) {
                ind = Arrays.binarySearch(nums, nums[ind] * nums[ind]);
                temp++;
            }
            len = Math.max(len, temp);
        }
        if (len <= 1)
            len = -1;
        return len;
    }

    class Allocator {
        int[] arr;
        int k = 0;
        int len;

        public Allocator(int n) {
            len = n;
            arr = new int[n];
        }

        public int allocate(int size, int mID) {
            int temp = 0;
            int ind = -1;
            for (int i = len - 1; i >= 0; i--) {
                if (arr[i] != 0) {
                    if (temp >= size) {
                        ind = i + 1;
                    }
                    temp = 0;
                } else {
                    temp++;
                }
            }
            if (temp >= size) {
                ind = 0;
            }
            if(ind == -1) return -1;
            for(int i=ind; i<ind+size; i++){
                arr[i] = mID;
            }
            return ind;
        }

        public int free(int mID) {
            int count = 0;
            for(int i=0; i<len; i++){
                if(arr[i]==mID){
                    count++;
                    arr[i] = 0;
                }
            }
            return count;
        }
    }

    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length;
        int n = grid[0].length;
        int k = queries.length;
        int[] ans = new int[k];
        for(int i=0; i<k; i++) {
            boolean[][] vis = new boolean[m][n];
            ans[i] = dfs(grid, queries[i],0, 0, vis, m, n);
        }
        return ans;
    }

    private int dfs(int[][] grid, int q, int i, int j, boolean[][] vis, int m, int n) {
        int ret = 0;
        int[] d = new int[]{-1, 0, 1, 0, -1};
        for(int x=0; x<4; x++){
            int ni = i+d[x];
            int nj = j+d[x+1];
            if(ni>=0 && ni<m && nj>=0 && nj<n && !vis[ni][nj] && grid[ni][nj]<q){
                vis[ni][nj] = true;
                ret += (1+dfs(grid, q, ni, nj, vis, m, n));
            }
        }
        return ret;
    }

    

}