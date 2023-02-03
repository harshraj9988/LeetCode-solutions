fun minCost(nums: IntArray, k: Int): Int {
    val n = nums.size
    val trimmedValue = Array(n) { Array(n) { -1 } }
    trimmed(nums, trimmedValue)
    val dp = Array(n) { -1 }
    return memoization(nums, 0, n - 1, k, dp, trimmedValue)
}

private fun trimmed(nums: IntArray, trimmedValue: Array<Array<Int>>) {
    val n = nums.size
    for (i in 0 until n) {
        val arr = IntArray(n)
        var count = 0
        for (j in i until n) {
            if (arr[nums[j]] == 1) count--
            arr[nums[j]]++
            if (arr[nums[j]] == 1) count++
            trimmedValue[i][j] = j - i + 1 - count
        }
    }
}

private fun recursion(nums: IntArray, start: Int, end: Int, k: Int, trimmedValue: Array<Array<Int>>): Int {
    if (start > end) return 0
    var trimmingCost = k + trimmedValue[start][end]
    for (mid in start until end) {
        val pr = (recursion(nums, start, mid, k, trimmedValue)) +
                (k + trimmedValue[mid + 1][end])
        trimmingCost = trimmingCost.coerceAtMost(pr)
    }
    return trimmingCost
}

private fun memoization(
    nums: IntArray,
    start: Int,
    end: Int,
    k: Int,
    dp: Array<Int>,
    trimmedValue: Array<Array<Int>>
): Int {
    if (start > end) return 0
    if (dp[end] != -1) return dp[end]
    var trimmingCost = k + trimmedValue[start][end]
    for (mid in start until end) {
        trimmingCost = trimmingCost.coerceAtMost(
            (memoization(nums, start, mid, k, dp, trimmedValue) +
                    (k + trimmedValue[mid + 1][end]))
        )
    }
    dp[end] = trimmingCost
    return trimmingCost
}