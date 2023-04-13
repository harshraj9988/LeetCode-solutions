    fun miceAndCheese(reward1: IntArray, reward2: IntArray, k: Int): Int {
        val n = reward1.size
        val diff = IntArray(n)
        for(i in 0 until n){
            diff[i] = reward1[i] - reward2[i]
        }
        diff.sortDescending()
        var totalSum = reward2.sum()
        for(i in 0 until k) {
            totalSum += diff[i]
        }
        return totalSum
    }
