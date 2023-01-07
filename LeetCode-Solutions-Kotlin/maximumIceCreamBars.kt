import kotlin.math.floor

    fun maxIceCream(costs: IntArray, coins: Int): Int {
        var bars = 0
        var remCoins = coins
        val freq = IntArray( costs.reduce { a, b -> a.coerceAtLeast(b) } + 1 )
        for(cost in costs) freq[cost]++
        for( i in freq.indices ) {
            val newBars = floor(remCoins.toDouble() / i.toDouble()).toInt().coerceAtMost(freq[i])
            remCoins -= (newBars * i)
            bars += newBars
        }
        return bars
    }