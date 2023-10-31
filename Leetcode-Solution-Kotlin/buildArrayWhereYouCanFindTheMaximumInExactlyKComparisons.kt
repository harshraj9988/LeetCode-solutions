    fun numOfArrays(n: Int, m: Int, k: Int): Int {
        val dp = Array(n) { Array(m + 1) { IntArray(k + 1) { -1 } } }
        return memoization(0, 0, 0, n, m, k, dp)
    }

    private fun recursion(a: Int, b: Int, c: Int, n: Int, m: Int, k: Int): Int {
        if (a == n) {
            return if (c == k) 1 else 0
        }
        val mod = 1e9.toInt() + 7
        var change = 0
        if (c < k) {
            for (i in 1..m) {
                change = (change + recursion(
                    a + 1, b.coerceAtLeast(i), c + (if (i > b) 1 else 0),
                    n, m, k
                ) % mod) % mod
            }
        } else {
            for (i in b downTo 1) {
                change = (change + recursion(
                    a + 1, b, c, n, m, k
                ) % mod) % mod
            }
        }
        return (change) % mod
    }

    private fun memoization(a: Int, b: Int, c: Int, n: Int, m: Int, k: Int, dp: Array<Array<IntArray>>): Int {
        if (a == n) {
            return if (c == k) 1 else 0
        }
        if (dp[a][b][c] != -1) return dp[a][b][c]
        val mod = 1e9.toInt() + 7
        var change = 0
        if (c < k) {
            for (i in 1..m) {
                change = (change + memoization(
                    a + 1, b.coerceAtLeast(i), c + (if (i > b) 1 else 0),
                    n, m, k, dp
                ) % mod) % mod
            }
        } else {
            for (i in b downTo 1) {
                change = (change + memoization(
                    a + 1, b, c, n, m, k, dp
                ) % mod) % mod
            }
        }
        dp[a][b][c] = change % mod
        return dp[a][b][c]
    }