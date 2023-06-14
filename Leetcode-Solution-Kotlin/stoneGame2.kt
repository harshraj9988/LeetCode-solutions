
    fun stoneGameII(piles: IntArray): Int {
        val presum = piles.clone()
        for(i in presum.lastIndex-1 downTo 0) {
            presum[i] += presum[i+1]
        }
        val dp = Array(piles.size) { IntArray(piles.size) { 0 } }
        return memoization(presum, 1, 0, dp)
    }
    
    private fun memoization(presum: IntArray, m: Int, x: Int, dp: Array<IntArray>): Int {
        if(x + 2*m >= presum.size) return presum[x]
        if(dp[x][m] > 0) return dp[x][m]
        var ans = 0
        var temp = 0
        for(i in 1 .. 2*m) {
            temp = presum[x] - presum[x+i]
            ans = ans.coerceAtLeast(temp + presum[x+i] - memoization(presum, i.coerceAtLeast(m), x+i, dp))
        }
        dp[x][m] = ans
        return ans
    }