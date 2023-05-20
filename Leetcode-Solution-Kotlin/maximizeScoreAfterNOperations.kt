    private fun gcd(x: Int, y: Int): Int = if (y == 0) x else gcd(y, x % y)

    private fun recursion(nums: IntArray, dp: Array<IntArray>, i: Int, mask: Int): Int {
        if (i > nums.size / 2) return 0
        if (dp[i][mask] != 0)
            return dp[i][mask]
        for (j in nums.indices) {
            for (k in j + 1..nums.lastIndex) {
                val newMask = (1 shl j) + (1 shl k)
                if ((mask and newMask) != 0) continue
                dp[i][mask] = dp[i][mask].coerceAtLeast(
                    i * gcd(nums[j], nums[k]) + recursion(nums, dp, i + 1, mask + newMask)
                )
            }
        }
        return dp[i][mask]
    }


    fun maxScore(nums: IntArray): Int {
        return recursion(nums, Array(nums.size / 2 + 1) { IntArray(1 shl nums.size) }, 1, 0)
    }

fun main() {
    val nums = intArrayOf(3, 4, 6, 8)
    println(maxScore(nums))
}