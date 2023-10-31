fun knightProbability(n: Int, k: Int, row: Int, column: Int): Double {
    val dp = Array(k + 1) { Array(n) { DoubleArray(n) { -1.0 } } }
    return memoization(n, k, row, column, dp)
}

private val dir = arrayOf(
    Pair(1, -2),
    Pair(2, -1),
    Pair(2, 1),
    Pair(1, 2),
    Pair(-1, 2),
    Pair(-2, 1),
    Pair(-2, -1),
    Pair(-1, -2)
)

private fun memoization(n: Int, k: Int, row: Int, column: Int, dp: Array<Array<DoubleArray>>): Double {
    if (row !in 0 until n || column !in 0 until n) return 0.0
    if (k == 0) return 1.0
    if (dp[k][row][column] != -1.0) return dp[k][row][column]
    var prob = 0.0
    for (i in 0 until 8) {
        prob += memoization(n, k - 1, row + dir[i].first, column + dir[i].second, dp) / 8.0
    }
    dp[k][row][column] = prob
    return prob
}