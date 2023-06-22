    import java.util.Collections

    fun countPaths(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val dp = Array(m) { LongArray(n) { 1L } }
        val arr = ArrayList<Pair<Int, Pair<Int, Int>>>()
        for (i in 0 until m) {
            for (j in 0 until n) {
                arr.add(Pair(grid[i][j], Pair(i, j)))
            }
        }
        Collections.sort(arr) { a, b ->
            a.first.compareTo(b.first)
        }

        val adj = intArrayOf(-1, 0, 1, 0, -1)
        val mod = 1e9.toLong() + 7L
        for (node in arr) {
            val x = node.second.first
            val y = node.second.second
            for (i in 0 until 4) {
                val nx = x + adj[i]
                val ny = y + adj[i + 1]
                if (nx in grid.indices && ny in grid[0].indices && grid[nx][ny] > grid[x][y]) {
                    dp[nx][ny] = (dp[nx][ny] + dp[x][y]) % mod
                }
            }
        }

        var sum = 0L

        for (i in grid.indices) {
            for (j in grid[0].indices) {
                sum = (sum + dp[i][j]) % mod
            }
        }

        return sum.toInt()
    }