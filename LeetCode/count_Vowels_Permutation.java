import java.util.Arrays;

/**
 * Given an integer n, your task is to count how many strings of length n can be
 * formed under the following rules:
 * 
 * Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
 * Each vowel 'a' may only be followed by an 'e'.
 * Each vowel 'e' may only be followed by an 'a' or an 'i'.
 * Each vowel 'i' may not be followed by another 'i'.
 * Each vowel 'o' may only be followed by an 'i' or a 'u'.
 * Each vowel 'u' may only be followed by an 'a'.
 * Since the answer may be too large, return it modulo 10^9 + 7.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 1
 * Output: 5
 * Explanation: All possible strings are: "a", "e", "i" , "o" and "u".
 * Example 2:
 * 
 * Input: n = 2
 * Output: 10
 * Explanation: All possible strings are: "ae", "ea", "ei", "ia", "ie", "io",
 * "iu", "oi", "ou" and "ua".
 * Example 3:
 * 
 * Input: n = 5
 * Output: 68
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 2 * 10^4
 */
public class count_Vowels_Permutation {
    long mod = 1000000007;
    int a = 1, e = 2, i = 3, o = 4, u = 5;

    public int countVowelPermutation(int n) {

        long[][] dp = new long[n+1][6];
        for(int x=0; x<= n; x++){
            Arrays.fill(dp[x], (long)-1);
        }
        return (int) memoization(n, 0, dp);
    }

    private long recursion(int n, int prev) {
        if (n == 0)
            return 1;

        long count = 0;
        switch (prev) {
            case 1:
                count += recursion(n - 1, e);

                break;
            case 2:
                count += recursion(n - 1, a);
                count += recursion(n - 1, i);

                break;

            case 3:
                for (int x = 1; x <= 5; x++) {
                    if (x == i)
                        continue;
                    count += recursion(n - 1, x);
                }

                break;

            case 4:
                count += recursion(n - 1, i);
                count += recursion(n - 1, u);

                break;

            case 5:
                count += recursion(n - 1, a);

                break;

            default:

                for (int x = 1; x <= 5; x++) {
                    count += recursion(n - 1, x);
                }

                break;

        }
        return count % mod;
    }


    private long memoization(int n, int prev, long[][] dp) {
        if (n == 0)
            return 1;

        if(dp[n][prev]!=-1) return dp[n][prev];

        long count = 0;
        switch (prev) {
            case 1:
                count += memoization(n - 1, e, dp);

                break;
            case 2:
                count += memoization(n - 1, a, dp);
                count += memoization(n - 1, i, dp);

                break;

            case 3:
                for (int x = 1; x <= 5; x++) {
                    if (x == i)
                        continue;
                    count += memoization(n - 1, x, dp);
                }

                break;

            case 4:
                count += memoization(n - 1, i, dp);
                count += memoization(n - 1, u, dp);

                break;

            case 5:
                count += memoization(n - 1, a, dp);

                break;

            default:

                for (int x = 1; x <= 5; x++) {
                    count += memoization(n - 1, x, dp);
                }

                break;

        }
        return dp[n][prev] = count % mod;
    }
}
