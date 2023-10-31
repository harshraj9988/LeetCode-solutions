    fun longestSubsequence(arr: IntArray, difference: Int): Int {
        val last = HashMap<Int, Int>()
        var len = 0
        arr.forEach {
            last[it] = 1 + (last[it-difference] ?: 0)
            len = len.coerceAtLeast(last[it]!!)
        }
        return len
    }