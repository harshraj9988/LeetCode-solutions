    fun shuffle(nums: IntArray, n: Int): IntArray {
        val ans = IntArray(2 * n)
        for (i in 0 until n) {
            ans[i * 2] = nums[i]
            ans[i * 2 + 1] = nums[n + i]
        }
        return ans
    }