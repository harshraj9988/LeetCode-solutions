    fun paintWalls(cost: IntArray, time: IntArray): Int {
        val dp = Array(cost.size) { IntArray(cost.size+1) { -1 } }
        return memoization(cost, time, cost.lastIndex, cost.size, dp)
    }

    private fun recursion(cost: IntArray, time: IntArray, wall: Int, remWall: Int): Int {
        if (remWall <= 0) return 0
        if (wall < 0) return 1e8.toInt() * 5

        val letsPaint = cost[wall] + recursion(cost, time, wall - 1, remWall - 1 - time[wall])
        val skip = recursion(cost, time, wall - 1, remWall)

        return letsPaint.coerceAtMost(skip)
    }

    private fun memoization(cost: IntArray, time: IntArray, wall: Int, remWall: Int, dp: Array<IntArray>): Int {
        if (remWall <= 0) return 0
        if (wall < 0) return 1e8.toInt() * 5
        if (dp[wall][remWall] != -1) return dp[wall][remWall]

        val letsPaint = cost[wall] + memoization(cost, time, wall - 1, remWall - 1 - time[wall], dp)
        val skip = memoization(cost, time, wall - 1, remWall, dp)

        dp[wall][remWall] = letsPaint.coerceAtMost(skip)
        return dp[wall][remWall]
    }
