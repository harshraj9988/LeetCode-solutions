    fun countRoutes(locations: IntArray, start: Int, finish: Int, fuel: Int): Int {
        return memoization(locations, start, fuel, finish).toInt()
    }

    private val mod = 1e9.toLong() + 7L

    private fun recursion(locations: IntArray, city: Int, fuel: Int, finish: Int): Long {
        if (fuel < 0) return 0L
        var routes = 0L
        if (city == finish) routes++

        for (next in locations.indices) {
            if (city == next) continue
            routes = (routes + recursion(locations, next, fuel - Math.abs(locations[next] - locations[city]), finish)) % mod
        }

        return routes
    }

    private fun memoization(
        locations: IntArray,
        city: Int,
        fuel: Int,
        finish: Int,
        dp: Array<LongArray> = Array(locations.size) { LongArray(fuel+1) { -1L } }
    ): Long {
        if (fuel < 0) return 0L
        var routes = 0L
        if (dp[city][fuel] != -1L) return dp[city][fuel]

        if (city == finish) routes++
        for (next in locations.indices) {
            if (city == next) continue
            routes = (routes + memoization(locations, next, fuel - Math.abs(locations[next] - locations[city]), finish, dp)) % mod
        }
        dp[city][fuel] = routes
        return routes
    }