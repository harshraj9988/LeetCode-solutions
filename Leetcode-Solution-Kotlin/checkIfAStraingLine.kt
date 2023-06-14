    fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
        if (coordinates.size == 2) return true
        for (i in 1 until coordinates.lastIndex) {
            if (
                (coordinates[i][1] - coordinates[i + 1][1]).toLong() * (coordinates[i - 1][0] - coordinates[i][0]).toLong() !=
                (coordinates[i][0] - coordinates[i + 1][0]).toLong() * (coordinates[i - 1][1] - coordinates[i][1]).toLong()
            ) return false
        }
        return true
    }