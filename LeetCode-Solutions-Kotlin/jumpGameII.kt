    fun jump(nums: IntArray): Int {
    //    val dp = Array(nums.size) { -1 }
    //    return memoization(nums, 0, dp)

        return tabulation(nums)
    }

    private fun recursion(nums: IntArray, ind: Int): Int {
        if (ind >= nums.size - 1) return 0
        var minJumps = Int.MAX_VALUE
        for (next in 1..nums[ind]) {
            minJumps = minJumps.coerceAtMost(
                1 + recursion(nums, ind + next)
            )
        }
        return minJumps
    }

    private fun memoization(nums: IntArray, ind: Int, dp: Array<Int>): Int {
        if (ind >= nums.size - 1) return 0
        if (dp[ind] != -1) return dp[ind]
        var minJumps = 1e8.toInt()
        for (next in 1..nums[ind]) {
            minJumps = minJumps.coerceAtMost(
                1 + memoization(nums, ind + next, dp)
            )
        }
        dp[ind] = minJumps
        return minJumps
    }

    private fun tabulation(nums: IntArray): Int {
        val n = nums.size
        val dp = IntArray(n)
        for (ind in nums.size - 2 downTo 0) {
            var minJumps = 1e8.toInt()
            for (next in 1..nums[ind]) {
                minJumps = minJumps.coerceAtMost(1 + (if (ind + next >= n) 0 else dp[ind + next]))
            }
            dp[ind] = minJumps
        }
        return dp[0]
    }