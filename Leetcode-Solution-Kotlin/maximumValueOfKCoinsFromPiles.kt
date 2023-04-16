    private fun recursion(preSums: ArrayList<ArrayList<Int>>, pile: Int, k: Int): Int {
        if (k == 0) {
            return 0
        }
        if (pile == preSums.size - 1) {
            return if (k >= preSums[pile].size) Int.MIN_VALUE
            else preSums[pile][k]
        }
        var maxi = 0
        for (i in 0..(preSums[pile].size - 1).coerceAtMost(k)) {
            maxi = maxi.coerceAtLeast(preSums[pile][i] + recursion(preSums, pile + 1, k - i))
        }
        return maxi
    }

    private fun memoization(preSums: ArrayList<ArrayList<Int>>, pile: Int, k: Int, dp: Array<Array<Int>>): Int {
        if (k == 0) {
            return 0
        }
        if (pile == preSums.size - 1) {
            return if (preSums[pile].size < k) Int.MIN_VALUE
            else preSums[pile][k]
        }

        if (dp[pile][k] != -1) {
            return dp[pile][k]
        }

        var maxi = 0
        for (i in 0..(preSums[pile].size - 1).coerceAtMost(k)) {
            maxi = maxi.coerceAtLeast(preSums[pile][i] + memoization(preSums, pile + 1, k - i, dp))
        }
        dp[pile][k] = maxi
        return maxi
    }

    fun maxValueOfCoins(piles: List<List<Int>>, k: Int): Int {
        val preSums = ArrayList<ArrayList<Int>>()
        for (pile in piles) {
            val temp = ArrayList<Int>()
            temp.add(0)
            temp.add(pile[0])
            for (i in 1 until pile.size) {
                temp.add(temp[i] + pile[i])
            }
            preSums.add(temp)
        }

        val dp = Array(preSums.size) { Array(k) { -1 } }

        return memoization(preSums, 0, k, dp)
    }