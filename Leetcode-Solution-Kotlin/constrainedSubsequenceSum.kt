    fun constrainedSubsetSum(nums: IntArray, k: Int): Int {
        val q = ArrayDeque<Pair<Int, Int>>()
        var maxSum = -(1e4).toInt() - 1
        for (i in nums.indices) {
            if (q.isEmpty()) {
                q.add(Pair(i, nums[i]))
                maxSum = maxSum.coerceAtLeast(nums[i])
                continue
            }
            val len = i - q.first().first
            if (len > k) q.removeFirst()
            val prev = if (q.isNotEmpty()) q.first().second else 0
            val curr = nums[i].coerceAtLeast(nums[i] + prev)
            maxSum = maxSum.coerceAtLeast(curr)
            while (q.isNotEmpty() && q.last().second <= curr) q.removeLast()
            q.addLast(Pair(i, curr))
        }
        return maxSum
    }