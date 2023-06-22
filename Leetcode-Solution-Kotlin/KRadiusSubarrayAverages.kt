    fun getAverages(nums: IntArray, k: Int): IntArray {
        val prefixSum = LongArray(nums.size)
        val ans = IntArray(nums.size)
        prefixSum[0] = nums[0].toLong()
        for (i in 1 until nums.size) {
            prefixSum[i] = prefixSum[i - 1] + nums[i].toLong()
        }
        for (i in nums.indices) {
            ans[i] = if (i - k >= 0 && i + k <= nums.lastIndex) {
                ((prefixSum[i + k] - (if (i - k - 1 >= 0) prefixSum[i - k - 1] else 0)) / (k.toLong() + 1 + k.toLong())).toInt()
            } else {
                -1
            }
        }
        return ans
    }