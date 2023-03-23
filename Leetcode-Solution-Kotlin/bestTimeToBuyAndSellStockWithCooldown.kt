    import kotlin.math.max

    fun maxProfit(prices: IntArray): Int {
        val totalDays = prices.size
        val dp = Array(2) { Array(totalDays) {-1} }
        return memoization(prices, 0, totalDays, 1, dp)
    }

    private fun memoization(prices: IntArray, day: Int, totalDays: Int, buy: Int, dp: Array<Array<Int>>): Int {
        if (day >= totalDays) return 0
        if (dp[buy][day] != -1) return dp[buy][day]
        if (buy == 1) {
            val bought = -prices[day] + memoization(prices, day + 1, totalDays, 0, dp)
            val notBought = memoization(prices, day + 1, totalDays, buy, dp)
            dp[buy][day] = max(bought, notBought)
        } else {
            val sold = prices[day] + memoization(prices, day + 2, totalDays, 1, dp)
            val notSold = memoization(prices, day + 1, totalDays, buy, dp)
            dp[buy][day] = max(sold, notSold)
        }
        return dp[buy][day]
    }

    fun main(){
        val prices = arrayOf(1,2,3,0,2).toIntArray()
        println(maxProfit(prices))
    }
