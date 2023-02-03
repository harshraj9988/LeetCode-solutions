    fun maxSubarraySumCircular(nums: IntArray): Int {
        var maxSum = nums[0]
        var minSum = nums[0]
        var currMaxSum = nums[0]
        var currMinSum = nums[0]
        var totalSum = nums[0]

        for (i in 1 until nums.size) {
            totalSum += nums[i]
            if (currMaxSum + nums[i] < nums[i]) currMaxSum = nums[i]
            else currMaxSum += nums[i]

            if (currMinSum + nums[i] > nums[i]) currMinSum = nums[i]
            else currMinSum += nums[i]

            maxSum = maxSum.coerceAtLeast(currMaxSum)
            minSum = minSum.coerceAtMost(currMinSum)
        }
        if(minSum == totalSum) return maxSum
        return maxSum.coerceAtLeast((totalSum - minSum))
    }