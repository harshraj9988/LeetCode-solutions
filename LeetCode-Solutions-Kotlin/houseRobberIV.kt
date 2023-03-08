    fun minCapability(nums: IntArray, k: Int): Int {
        var mini = Int.MAX_VALUE
        var maxi = Int.MIN_VALUE
        nums.forEach {
            mini = mini.coerceAtMost(it)
            maxi = maxi.coerceAtLeast(it)
        }
        var start = mini
        var end = maxi
        var ans = 0
        while (start < end) {
            val mid = start + (end - start) / 2
            if (check(nums, k, mid)) {
                ans = mid
                end = mid - 1
            } else {
                start = mid + 1
            }
        }
        
        return ans
    }

    private fun check(nums: IntArray, k: Int, value: Int): Boolean {
        var last = -2
        var elems = 0
        for (i in nums.indices) {
            if (nums[i] >= value && last + 1 != i) {
                last = i
                elems++
            }
        }
        return elems >= k
    }
