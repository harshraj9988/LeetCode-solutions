
/**
We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].

You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.

If you choose a job that ends at time X you will be able to start another job that starts at time X.

 

Example 1:



Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
Output: 120
Explanation: The subset chosen is the first and fourth job. 
Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
Example 2:



Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
Output: 150
Explanation: The subset chosen is the first, fourth and fifth job. 
Profit obtained 150 = 20 + 70 + 60.
Example 3:



Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
Output: 6
 

Constraints:

1 <= startTime.length == endTime.length == profit.length <= 5 * 104
1 <= startTime[i] < endTime[i] <= 109
1 <= profit[i] <= 104
*/

import java.util.*;
import java.io.*;

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] arr = new int[n][3];
        // int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
            // dp[i] = -1;
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });
        Arrays.sort(startTime);
        return tabulation(arr, startTime, n);
        // return memoizaton(arr, startTime, 0, n, dp);
    }

    private int recursion(int[][] arr, int[] st, int i, int n) {
        if (i == n)
            return 0;
        int ind = Arrays.binarySearch(st, arr[i][1]);
        if (ind < 0)
            ind = (-1) * ind - 1;
        return Math.max(arr[i][2] + recursion(arr, st, ind, n), recursion(arr, st, i + 1, n));
    }

    private int memoizaton(int[][] arr, int[] st, int i, int n, int[] dp) {
        if (i == n)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        int ind = Arrays.binarySearch(st, arr[i][1]);
        if (ind < 0)
            ind = (-1) * ind - 1;
        return dp[i] = Math.max(arr[i][2] + memoizaton(arr, st, ind, n, dp), memoizaton(arr, st, i + 1, n, dp));
    }

    private int tabulation(int[][] arr, int[] st, int n) {
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int ind = Arrays.binarySearch(st, arr[i][1]);
            if (ind < 0)
                ind = (-1) * ind - 1;
            dp[i] = Math.max(arr[i][2] + dp[ind], dp[i+1]);
        }
        return dp[0];
    }
}
