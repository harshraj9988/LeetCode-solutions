    private val mod = 1e9.toLong() + 7L
    private fun recursion(low: Int, high: Int, zero: Int, one: Int, len: Int): Long {
        if (len > high) {
            return 0L
        }
        val takeZero = recursion(low, high, zero, one, len + zero)
        val takeOne = recursion(low, high, zero, one, len + one)
        return (takeOne + takeZero + (if (len in low..high) 1L else 0L)) % mod
    }

    private fun memoization(low: Int, high: Int, zero: Int, one: Int, len: Int, dp: LongArray): Long {
        if (len > high) {
            return 0L
        }
        if (dp[len] != -1L) return dp[len]
        val takeZero = memoization(low, high, zero, one, len + zero, dp)
        val takeOne = memoization(low, high, zero, one, len + one, dp)
        dp[len] = (takeOne + takeZero + (if (len in low..high) 1L else 0L)) % mod
        return dp[len]
    }

    private fun tabulation(low: Int, high: Int, zero: Int, one: Int): Int {
        val dp = LongArray(high + 1)
        for (len in high downTo 0) {
            val takeZero = if (len + zero <= high) dp[len + zero] else 0
            val takeOne = if (len + one <= high) dp[len + one] else 0
            dp[len] = (takeOne + takeZero + (if (len in low..high) 1L else 0L)) % mod
        }
        return dp[0].toInt()
    }

    fun countGoodStrings(low: Int, high: Int, zero: Int, one: Int): Int {
    //    val dp = LongArray(high + 1) { -1L }
    //    return memoization(low, high, zero, one, 0, dp).toInt()
        return tabulation(low, high, zero, one)
    }