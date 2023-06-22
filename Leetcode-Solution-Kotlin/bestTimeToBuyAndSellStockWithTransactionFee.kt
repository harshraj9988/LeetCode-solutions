    fun maxProfit(prices: IntArray, fee: Int): Int {
        return getProfit(prices, fee, 0, 0, arrayOf(IntArray(prices.size){-1}, IntArray(prices.size){-1}))
    }

    private fun getProfit(prices: IntArray, fee: Int, buy: Int, day: Int, dp: Array<IntArray>): Int {
        if(day >= prices.size) return 0
        if(dp[buy][day] != -1) return dp[buy][day]
        dp[buy][day] = if(buy == 1) {
            getProfit(prices, fee, buy, day+1, dp).coerceAtLeast(-prices[day] + getProfit(prices, fee, 0, day+1, dp))
        }else{
            getProfit(prices, fee, 0, day+1, dp).coerceAtLeast(prices[day] - fee + getProfit(prices, fee, 1, day, dp))
        }
        return dp[buy][day]
    }