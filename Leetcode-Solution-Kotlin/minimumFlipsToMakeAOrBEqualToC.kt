    fun minFlips(a: Int, b: Int, c: Int): Int {
        var count = 0
        var x = a
        var y = b
        var z = c
        while (x > 0 || y > 0 || z > 0) {
            val xBit = x and 1
            val yBit = y and 1
            val zBit = z and 1
            x = x shr 1
            y = y shr 1
            z = z shr 1
            count += if (zBit == 1) {
                (if (xBit or yBit == 1) 0 else 1)
            } else {
                (if (xBit and yBit == 1) 2 else if (xBit or yBit == 1) 1 else 0)
            }
        }
        return count
    }