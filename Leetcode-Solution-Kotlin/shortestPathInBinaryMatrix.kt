    private fun dfs(grid: Array<IntArray>, x: Int, y: Int, n: Int): Int {
        if (x !in 0 until n || y !in 0 until n || grid[x][y] == 1) {
            return 1e8.toInt()
        }
        if (x == n - 1 && y == n - 1) {
            return if (grid[x][y] == 0) 1 else 0
        }
        val dx = intArrayOf(0, 0, 1, -1, -1, -1, 1, 1)
        val dy = intArrayOf(1, -1, 0, 0, -1, 1, -1, 1)
        var minPath = Int.MAX_VALUE
        for (i in 0 until 8) {
            minPath = minPath.coerceAtMost(dfs(grid, x + dx[i], y + dy[i], n))
        }

        return 1 + minPath
    }

    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        return dfs(grid, 0, 0, grid.size)
    }