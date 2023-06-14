import kotlin.math.max

    fun maxValue(n: Int, index: Int, maxSum: Int): Int {
        var start = 1
        var end = maxSum
        var peek = 0

        while (start <= end) {
            val mid = start + (end - start) / 2
            if (check(mid.toLong(), maxSum.toLong(), index.toLong(), n.toLong())) {
                peek = mid
                start = mid + 1
            } else {
                end = mid - 1
            }
        }

        return peek
    }

    private fun check(maxVal: Long, maxSum: Long, index: Long, n: Long): Boolean {
        val onLeft = index
        val onRight = (n - index - 1)
        if (maxVal - onLeft <= 0 || maxVal - onRight <= 0) return false
        val sum = maxVal + maxVal * onLeft - ((onLeft + 1) * onLeft) / 2 + maxVal * onRight - ((onRight + 1) * onRight / 2)
        return sum <= maxSum
    }