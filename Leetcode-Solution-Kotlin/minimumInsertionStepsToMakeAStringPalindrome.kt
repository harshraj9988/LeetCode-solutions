    private fun recursion(s: String, p: String, i: Int, j: Int): Int {
        if (i < 0 || j < 0) {
            return 0
        }
        return if (s[i] == p[j]) {
            1 + recursion(s, p, i - 1, j - 1)
        } else {
            val moveBoth = recursion(s, p, i - 1, j - 1)
            val moveFirst = recursion(s, p, i - 1, j)
            val moveSecond = recursion(s, p, i, j - 1)
            moveBoth.coerceAtLeast(moveFirst).coerceAtLeast(moveSecond)
        }
    }

    private fun memoization(s: String, p: String, i: Int, j: Int, dp: Array<Array<Int>>): Int {
        if (i < 0 || j < 0) {
            return 0
        }
        if (dp[i][j] != -1) {
            return dp[i][j]
        }
        dp[i][j] = if (s[i] == p[j]) {
            1 + memoization(s, p, i - 1, j - 1, dp)
        } else {
            val moveBoth = memoization(s, p, i - 1, j - 1, dp)
            val moveFirst = memoization(s, p, i - 1, j, dp)
            val moveSecond = memoization(s, p, i, j - 1, dp)
            moveBoth.coerceAtLeast(moveFirst).coerceAtLeast(moveSecond)
        }
        return dp[i][j]
    }

    private fun tabulation(s: String, p: String): Int {
        val n = s.length
        val dp = Array(n + 1) { Array(n + 1) { 0 } }
        for (i in 1..n) {
            for (j in 1..n) {
                if (s[i - 1] == p[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1]
                } else {
                    dp[i][j] = dp[i - 1][j - 1].coerceAtLeast(dp[i - 1][j]).coerceAtLeast(dp[i][j - 1])
                }
            }
        }
        return dp[n][n]
    }

    fun minInsertions(s: String): Int {
        val p = s.reversed()
    //    val dp = Array(s.length) { Array(s.length) { -1 } }
    //    return s.length - memoization(s, p, s.length - 1, s.length - 1, dp)
        return s.length - tabulation(s, p)
    }

    fun main() {
        val s = "l"
        println(minInsertions(s))
    }
