    fun numSubseq(nums: IntArray, target: Int): Int {
        val MOD = 1e9.toLong() + 7L
        var ans = 0L
        nums.sort()
        val power = LongArray(nums.size + 1) { -1L }
        power[0] = 1L
        for (i in 1 until power.size) {
            power[i] = (power[i - 1] * 2L) % MOD
        }
        var i = 0
        var j = nums.lastIndex
        while (i <= j) {
            if (nums[i] + nums[j] > target) {
                j--
            } else {
                ans = (ans + power[j - i]) % MOD
                i++
            }
        }
        return ans.toInt()
    }


