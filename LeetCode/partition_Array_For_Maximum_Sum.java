import java.util.Arrays;

/**
 * Given an integer array arr, partition the array into (contiguous) subarrays
 * of length at most k. After partitioning, each subarray has their values
 * changed to become the maximum value of that subarray.
 * 
 * Return the largest sum of the given array after partitioning. Test cases are
 * generated so that the answer fits in a 32-bit integer.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: arr = [1,15,7,9,2,5,10], k = 3
 * Output: 84
 * Explanation: arr becomes [15,15,15,9,10,10,10]
 * Example 2:
 * 
 * Input: arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
 * Output: 83
 * Example 3:
 * 
 * Input: arr = [1], k = 1
 * Output: 1
 * 
 * 
 * Constraints:
 * 
 * 1 <= arr.length <= 500
 * 0 <= arr[i] <= 109
 * 1 <= k <= arr.length
 */
public class partition_Array_For_Maximum_Sum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        return tabulation(arr,n, k, dp);
    }

    private int recursion(int[] arr, int i, int n, int k) {
        if (i == n)
            return 0;

        int maxValue = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        for (int j = i; j < Math.min(n, i + k); j++) {
            maxValue = Math.max(maxValue, arr[j]);
            int sum = (j - i + 1) * maxValue + recursion(arr, j + 1, n, k);
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    private int memoization(int[] arr, int i, int n, int k, int[] dp) {
        if (i == n)
            return 0;

        if (dp[i] != -1)
            return dp[i];
        int maxValue = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        for (int j = i; j < Math.min(n, i + k); j++) {
            maxValue = Math.max(maxValue, arr[j]);
            int sum = (j - i + 1) * maxValue + memoization(arr, j + 1, n, k, dp);
            maxSum = Math.max(sum, maxSum);
        }
        return dp[i] = maxSum;
    }

    private int tabulation(int[] arr, int n, int k, int[] dp) {
        for (int i = n - 1; i >= 0; i--) {
            int maxValue = Integer.MIN_VALUE;
            int maxSum = Integer.MIN_VALUE;
            for (int j = i; j < Math.min(n, i + k); j++) {
                maxValue = Math.max(maxValue, arr[j]);
                int sum = (j - i + 1) * maxValue + dp[j + 1];
                maxSum = Math.max(sum, maxSum);
            }
            dp[i] = maxSum;
        }
        return dp[0];
    }

}