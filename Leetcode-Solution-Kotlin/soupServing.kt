    fun soupServings(n: Int): Double {
        return solve(Math.ceil(n.toDouble() / 25).toInt(), Math.ceil(n.toDouble() / 25).toInt(), HashMap())
    }

    private fun solve(a: Int, b: Int, dp: HashMap<Int, HashMap<Int, Double>>): Double {
        if (a <= 0 && b <= 0) return 0.5
        if (a <= 0) return 1.0
        if (b <= 0) return 0.0
        if (a in dp && b in dp[a]!!) return dp[a]!![b]!!
        val x = (solve(a - 4, b, dp) + solve(a - 3, b - 1, dp) + solve(a - 2, b - 2, dp) + solve(a - 1, b - 3, dp)) / 4.0
        val y = dp[a] ?: HashMap()
        y[b] = x
        dp[a] = y
        return x
    }
