/**
You are given an array containing N non-negative integers. Your task is to partition this array into two subsets such that the absolute difference between subset sums is minimum.
You just need to find the minimum absolute difference considering any valid division of the array elements.
Note:
1. Each element of the array should belong to exactly one of the subset.

2. Subsets need not be contiguous always. For example, for the array : {1,2,3}, some of the possible divisions are a) {1,2} and {3}  b) {1,3} and {2}.

3. Subset-sum is the sum of all the elements in that subset. 
Input Format:
The first line of input contains the integer T, denoting the number of test cases.

The first line of each test case contains an integer N, denoting the size of the array.

The second and the last line of each test case contains N space-separated integers denoting the array elements.
Output Format:
For each test case, return the minimum possible absolute difference in a separate line. 
Note:
You do not need to print anything, it has already been taken care of. Just implement the given function.
Constraints:
1 <= T <= 10
1 <= N <= 10^3
0 <= ARR[i] <= 10^3
0 <= SUM <= 10^4, 

where SUM denotes the sum of all elements in the array for a given test case.

Time Limit: 1sec
Sample Input 1:
1
4
1 2 3 4
Sample Output 1:
0
Explanation For Sample Input 1:
We can partition the given array into {2,3} and {1,4}, as this will give us the minimum possible absolute difference i.e (5-5=0) in this case.
Sample Input 2:
1
3
8 6 5
Sample Output 2:
3
Explanation For Sample Input 2:
We can partition the given array into {8} and {6,5}, as this will give us the minimum possible absolute difference i.e (11-8=3) in this case
 */

 //coding ninja

public class partition_Array_Into_Two_Arrays_To_Minimize_Sum_Difference {
    public static int minSubsetSumDifference(int[] nums, int n) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        boolean[][] dp = new boolean[n][sum + 1];
        
    
        tabulation(nums, sum, n - 1, dp);
        int min = sum;
        for (int i = 1; i < sum; i++) {
            if (dp[n-1][i] == true) {
                min = Math.min(min, Math.abs((sum - i)-i));
            }
        }
        return min;
    }

    private static boolean tabulation(int[] nums, int k, int n, boolean[][] dp) {
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        if (nums[0] <= k) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                boolean pick = false;
                if (nums[i] <= j) {
                    pick = dp[i - 1][j - nums[i]];
                }
                boolean notPick = dp[i - 1][j];

                dp[i][j] = pick || notPick;
            }
        }
        return dp[n][k];
    }
}
