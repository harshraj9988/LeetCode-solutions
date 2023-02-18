import java.util.*;
import java.io.*;

public class solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int q = queries.length;
        int w = words.length;
        HashSet<Character> vowels = new HashSet<>(Set.of('a', 'e', 'i', 'o', 'u'));

        int[] ans = new int[q];
        int[] vows = new int[w];
        int[] ltr = new int[w];

        for (int i = 0; i < w; i++) {
            if (countVows(words[i], vowels))
                vows[i] = 1;
        }

        ltr[0] = vows[0];

        for (int i = 1; i < w; i++) {
            ltr[i] = vows[i] + ltr[i - 1];
        }

        for (int i = 0; i < q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int temp = ltr[r];
            if (l > 0)
                temp -= ltr[l - 1];

            ans[i] = temp;
        }

        return ans;
    }

    private boolean countVows(String word, HashSet<Character> vows) {
        return vows.contains(word.charAt(0)) && vows.contains(word.charAt(word.length() - 1));
    }

    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        long used = 0;
        long total = 0;
        for (int gift : gifts) {
            total += (long) gift;
            pq.add((long) gift);
        }
        for (int i = 0; i < k && pq.size() > 0; i++) {
            long x = pq.poll();
            long sqrt = (long) Math.floor(Math.sqrt(x));
            used += (x - sqrt);
            if (sqrt > 0)
                pq.add((sqrt));
        }
        return total - used;
    }

    public int minCapability(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++)
                dp[i][j] = -1;
        return recursion(nums, n - 1, 0, k, dp);
    }

    private int recursion(int[] nums, int i, int l, int k, int[][] dp) {
        if (i < 0 && l >= k)
            return Integer.MIN_VALUE;
        if (i < 0 && l < k)
            return Integer.MAX_VALUE;

        if (dp[i][l] != -1)
            return dp[i][l];

        int pick = Math.max(nums[i], recursion(nums, i - 2, l + 1, k, dp));
        int notPick = recursion(nums, i - 1, l, k, dp);

        return dp[i][l] = Math.min(pick, notPick);
    }

    private int tabulation(int[] nums, int k) {
        
        int n = nums.length;
        int[] prevPrev = new int[k + 1];
        int[] prev = new int[k + 1];
        for (int i = 0; i < k; i++) {
            prev[i] = Integer.MAX_VALUE;
            prevPrev[i] = Integer.MAX_VALUE;
        }

        prevPrev[k] = Integer.MIN_VALUE;
        prev[k] = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[k+1];
            for (int j = k - 1; j >= 0; j--) {

                int pick = Math.max(nums[i - 1], (i > 1) ? prevPrev[j + 1] : (j+1==k)?Integer.MIN_VALUE: Integer.MAX_VALUE);
                int notPick = prev[j];

                curr[j] = Math.min(pick, notPick);
            }
            prevPrev = prev;
            prev = curr;
        }

        return prev[0];
    }

    public static void main(String[] args) {
        int[] nums = { 9, 25, 16, 6, 18 };
        int k = 1;
        System.out.println((new solution()).minCapability(nums, k));
    }
}