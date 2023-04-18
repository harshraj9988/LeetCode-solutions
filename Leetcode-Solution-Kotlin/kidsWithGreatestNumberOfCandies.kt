    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
        val maximumCandies = candies.maxOrNull()!!
        return candies.map { it+extraCandies >= maximumCandies }
    }