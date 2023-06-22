import java.util.*

fun minCostToMakeArrayEqual(nums: IntArray, cost: IntArray): Long {
    val arr = Array(nums.size) { intArrayOf(nums[it], cost[it]) }
    Arrays.sort(arr) { a, b -> a[0].compareTo(b[0]) }
    val prefix = LongArray(nums.size) { arr[it][1].toLong() }
    for (i in 1 until prefix.size) {
        prefix[i] += prefix[i - 1]
    }

    val prefixCost = LongArray(nums.size) { 0L }
    val suffixCost = LongArray(nums.size) { 0L }

        for (i in 1 until nums.size) {
            prefixCost[i] = prefixCost[i - 1] + (arr[i][0] - arr[i - 1][0]).toLong() * prefix[i - 1]
        }

        for (i in nums.lastIndex - 1 downTo 0) {
            suffixCost[i] = suffixCost[i + 1] + (arr[i + 1][0] - arr[i][0]).toLong() * (prefix.last() - prefix[i])
        }

    var minCost = Long.MAX_VALUE
    for (i in arr.indices) {
        var currentCost = prefixCost[i] + suffixCost[i]
        if (currentCost < minCost) minCost = currentCost
    }
    return minCost
}