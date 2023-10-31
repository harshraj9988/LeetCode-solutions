fun uniquePaths(m: Int, n: Int): Int {
    return dfs(m, n, 0, 0, Array(m) { IntArray(n) { -1 } })
}

private fun dfs(m: Int, n: Int, x: Int, y: Int, dp: Array<IntArray>): Int {
    if (x !in 0 until m || y !in 0 until n) return 0
    if (x == m - 1 && y == n - 1) return 1
    if (dp[x][y] != -1) return dp[x][y]
    dp[x][y] = dfs(m, n, x + 1, y, dp) + dfs(m, n, x, y + 1, dp)
    return dp[x][y]
}