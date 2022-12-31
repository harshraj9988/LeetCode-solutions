    import kotlin.math.min

    fun maximumBags(capacity: IntArray, rocks: IntArray, additionalRocks: Int): Int {
        val n = capacity.size
        val remSpace = IntArray(n)
        for (i in 0 until n) {
            remSpace[i] = capacity[i] - rocks[i]
        }
        remSpace.sort()
        var count = 0
        var remRock = additionalRocks
        for (i in 0 until n) {
            val temp = min(remSpace[i], remRock)
            remSpace[i] -= temp
            remRock -= temp
            if (remRock == 0) break
        }
        for (it in remSpace) {
            if (it > 0) break
            count++
        }
        return count
    }