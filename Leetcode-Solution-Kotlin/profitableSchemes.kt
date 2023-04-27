    private val mod = 1e9.toLong() + 7L
    private fun recursion(
        i: Int,
        profit: Int,
        count: Int,
        n: Int,
        minProfit: Int,
        group: IntArray,
        profits: IntArray
    ): Long {
        if (i == group.size) {
            return if (minProfit <= profit) 1L else 0L
        }
        var noOfWays = (recursion(i + 1, minProfit, count, n, minProfit, group, profits) % mod)

        if (count + group[i] <= n) {
            noOfWays += (recursion(
                i + 1,
                minProfit.coerceAtMost(minProfit + profits[i]),
                count + group[i],
                n,
                minProfit,
                group,
                profits
            ) % mod)
        }
        noOfWays += (recursion(i + 1, minProfit, count, n, minProfit, group, profits) % mod)
        return (noOfWays % mod)
    }

    private fun memoization(
        i: Int,
        profit: Int,
        count: Int,
        n: Int,
        minProfit: Int,
        group: IntArray,
        profits: IntArray,
        dp: Array<Array<Array<Long>>>
    ): Long {
        if (i == group.size) {
            return if (minProfit <= profit) 1L else 0L
        }
        if (dp[i][count][profit] != -1L) {
            return dp[i][count][profit]
        }
        var noOfWays = (memoization(i + 1, profit, count, n, minProfit, group, profits, dp) % mod)

        if (count + group[i] <= n) {
            noOfWays += (memoization(
                i + 1,
                minProfit.coerceAtMost(profit + profits[i]),
                count + group[i],
                n,
                minProfit,
                group,
                profits,
                dp
            ) % mod)
        }
        dp[i][count][profit] = (noOfWays % mod)
        return dp[i][count][profit]
    }

    fun profitableSchemes(n: Int, minProfit: Int, group: IntArray, profit: IntArray): Int {
        val dp = Array(101) { Array(101) { Array(101) { -1L } } }
        return (memoization(0, 0, 0, n, minProfit, group, profit, dp) % mod).toInt()
    }