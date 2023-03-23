    fun maximumTastiness(price: IntArray, k: Int): Int {
        price.sort()
        var lowestTastiness = 0
        var highestTastiness = (1e9).toInt()
        var maximumTastiness = 0
        while (lowestTastiness <= highestTastiness) {
            val middleTastiness = lowestTastiness + (highestTastiness - lowestTastiness) / 2
            if (isPossible(middleTastiness, price, k)) {
                maximumTastiness = middleTastiness
                lowestTastiness = middleTastiness + 1
            } else {
                highestTastiness = middleTastiness - 1
            }
        }
        return maximumTastiness
    }

    private fun isPossible(assumedTastiness: Int, price: IntArray, k: Int): Boolean {
        var remCandiesToPick = k - 1
        var lastCandy = 0

        for (currCandy in 1 until price.size) {
            if ((price[currCandy] - price[lastCandy]) >= assumedTastiness) {
                lastCandy = currCandy
                remCandiesToPick--
            }
        }
        return (remCandiesToPick <= 0)
    }


