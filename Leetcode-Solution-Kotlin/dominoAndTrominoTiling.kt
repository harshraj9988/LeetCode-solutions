    fun numTilings(n: Int): Int {
        return spaceOptimization(n)
    }

    private val mod = (1e9).toLong() + 7.toLong()

    fun recursion(i: Int, n: Int, gap: Boolean): Long {
        if (i > n) return 0
        if (i == n) return if (gap) 0 else 1
        return ((if (gap) (recursion(i + 1, n, false) + recursion(i + 1, n, true)) else (recursion(
            i + 1,
            n,
            false
        ) + recursion(i + 2, n, false) + (2L) * recursion(i + 2, n, true))) % mod)
    }


    fun memoization(i: Int, n: Int, gap: Int, dp: Array<Array<Long>>): Long {
        if (i > n) return 0
        if (i == n) return if (gap == 1) 0 else 1
        if (dp[gap][i] != -1L) return dp[gap][i]
        dp[gap][i] = ((if (gap == 1) (memoization(i + 1, n, 0, dp) + memoization(i + 1, n, 1, dp)) else (memoization(
            i + 1,
            n,
            0,
            dp
        ) + memoization(i + 2, n, 0, dp) + (2L) * memoization(i + 2, n, 1, dp))) % mod)
        return dp[gap][i]
    }

    fun tabulation(n: Int): Int {
        val dp = Array(2) { Array(n + 2) { 0L } }
        dp[0][n] = 1L
        for (i in (n - 1) downTo 0) {
            for (gap in 0..1) {
                dp[gap][i] =
                    ((if (gap == 1) (dp[0][i + 1] + dp[1][i + 1]) else (dp[0][i + 1] + dp[0][i + 2] + (2L) * dp[1][i + 2])) % mod)
            }
        }
        return dp[0][0].toInt()
    }

    fun spaceOptimization(n: Int): Int {
        var nxt = Array(2) { 0L }
        var nxtToNxt = Array(2) { 0L }
        nxt[0] = 1L
        for (i in (n - 1) downTo 0) {
            val curr = Array(2) { 0L }
            for (gap in 0..1) {
                curr[gap] =
                    ((if (gap == 1) (nxt[0] + nxt[1]) else (nxt[0] + nxtToNxt[0] + (2L) * nxtToNxt[1])) % mod)
            }
            nxtToNxt = nxt
            nxt = curr
        }
        return nxt[0].toInt()
    }