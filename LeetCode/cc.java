
/**

*/

import java.util.*;
import java.io.*;

class Solution {
    public int commonFactors(int a, int b) {
        int count = 1;
        int mini = Math.min(a, b);
        for (int i = 2; i <= mini; i++) {
            if ((a % i == 0) && (b % i == 0))
                count++;
        }
        return count;
    }

    public int maxSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                maxi = Math.max(maxi, calculate(grid, i, j));
            }
        }
        return maxi;
    }

    private int calculate(int[][] grid, int i, int j) {
        int sum = 0;
        for (int k = j; k <= j + 2; k++) {
            sum += grid[i][k] + grid[i + 2][k];
        }
        sum += grid[i + 1][j + 1];
        return sum;
    }

    public int minimizeXor(int n, int m) {
        int oneBits = Integer.bitCount(n);
        int twoBits = Integer.bitCount(m);
        int[] one = new int[32];
        int[] two = new int[32];
        int i = 31;
        int j = 31;
        while (n > 0) {
            if ((n & 1) == 1)
                one[i--] = 1;
            else
                one[i--] = 0;
            n = n >> 1;
        }
        while (m > 0) {
            if ((m & 1) == 1)
                two[j--] = 1;
            else
                two[j--] = 0;
            m = m >> 1;
        }

        for (i = 31; i >= 0; i--) {
            if (oneBits == twoBits) {
                break;
            } else if (oneBits < twoBits) {
                if (one[i] == 0) {
                    one[i] = 1;
                    oneBits++;
                }
            } else if (twoBits < oneBits) {
                if (one[i] == 1) {
                    one[i] = 0;
                    oneBits--;
                }
            }
        }

        int result = 0;
        for (int x : one) {
            result = result << 1;
            result |= x;
        }

        return result;
    }

    private int recursion(String s, int n) {
        if (0 == n) {
            return 1;
        }
        int x = 0;
        boolean flag = false;
        for (int i = 0; i < n / 2; i++) {
            if (i + 2 + i <= n && s.substring(0, i + 1).equals(s.substring(i + 1, (i + 2 + i)))) {
                flag = true;
                String str = s.substring(i + 1, n);
                System.out.println(str);
                x = Math.max(x, 1+recursion(str, str.length()));
            }
        }
        if(!flag) return 1;
        return x;
    }


    private int memoization(String s, int n, int[] dp) {
        if (0 == n) {
            return 1;
        }
        if(dp[n]!=-1) return dp[n];
        int x = 0;
        boolean flag = false;
        for (int i = 0; i < n / 2; i++) {
            if (i + 2 + i <= n && s.substring(0, i + 1).equals(s.substring(i + 1, (i + 2 + i)))) {
                flag = true;
                String str = s.substring(i + 1, n);
                x = Math.max(x, 1+memoization(str, str.length(), dp));
            }
        }
        if(!flag) return 1;
        return dp[n] = x;
    }


    public int deleteString(String s) {
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp, -1);
        return memoization(s, s.length(), dp);
    }
}

public class cc {
    public static void main(String[] args) throws Exception {
       int x = 98;
       StringBuilder sb = new StringBuilder();
       sb.append(x);
       System.out.println(sb.toString());
    }
}