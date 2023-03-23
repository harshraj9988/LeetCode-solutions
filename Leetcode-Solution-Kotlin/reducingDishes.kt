    fun maxSatisfaction(satisfaction: IntArray): Int {
        val n = satisfaction.size
        satisfaction.sort()
        var time = 1
        var totalSatisfaction = 0

        for (i in 0 until n) {
            totalSatisfaction += (satisfaction[i] * time++)
        }
        var tempSatisfaction = totalSatisfaction

        for (i in 0 until n) {
            for (j in i until n) {
                tempSatisfaction -= satisfaction[j]
            }
            totalSatisfaction = totalSatisfaction.coerceAtLeast(tempSatisfaction)
        }
        return totalSatisfaction
    }