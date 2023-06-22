    fun largestAltitude(gain: IntArray): Int {
        var maxAltitude = 0
        var currentAltitude = 0
        gain.forEach {
            currentAltitude += it
            maxAltitude = maxAltitude.coerceAtLeast(currentAltitude)
        }
        return maxAltitude
    }