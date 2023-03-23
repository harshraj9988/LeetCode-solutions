fun uniquePathsIII(grid: Array<IntArray>): Int {
    var a = -1
    var b = -1
    val m = grid.size
    val n = grid[0].size
    var totalEmptyCells = 0
    val vis = Array(m) { Array(n) { false } }
    for (i in 0 until m) {
        for (j in 0 until n) {
            if (grid[i][j] == 1) {
                a = i
                b = j
                vis[i][j] = true
            } else if (grid[i][j] == 0) {
                totalEmptyCells++
            }
        }
    }
    return dfs(grid, a, b, totalEmptyCells, vis)
}

private fun dfs(
    grid: Array<IntArray>,
    a: Int,
    b: Int,
    totalEmptyCells: Int,
    vis: Array<Array<Boolean>>
): Int {
    if (grid[a][b] == 2) {
        return if (totalEmptyCells == -1) 1 else 0
    }
    var ways = 0
    val dx = arrayOf(-1, 0, 1, 0)
    val dy = arrayOf(0, 1, 0, -1)
    for (i in 0 until 4) {
        val c = a + dx[i]
        val d = b + dy[i]
        if ((c in 0 until grid.size) && (d in 0 until grid[0].size) && (grid[c][d] != -1) && (!vis[c][d])) {
            vis[c][d] = true
            ways += dfs(grid, c, d, totalEmptyCells - 1, vis)
            vis[c][d] = false
        }
    }
    return ways
}