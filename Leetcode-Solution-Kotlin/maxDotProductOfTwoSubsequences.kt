    fun maxDotProduct(nums1: IntArray, nums2: IntArray): Int {
        val dp = Array(nums1.size) { Array(nums2.size) { IntArray(2) { -(1e8.toInt() + 1) } } }
        return memoization(nums1, nums2, 0, 0, 0, dp)
    }

    private fun recursion(nums1: IntArray, nums2: IntArray, a: Int, b: Int, took: Int): Int {
        if (a == nums1.size || b == nums2.size) return if (took == 1) 0 else -(1e8.toInt())
        val takeBoth = (nums1[a] * nums2[b]) + recursion(nums1, nums2, a + 1, b + 1, 1)
        val notFirst = recursion(nums1, nums2, a + 1, b, 0)
        val notSecond = recursion(nums1, nums2, a, b + 1, 0)
        return takeBoth.coerceAtLeast(notFirst).coerceAtLeast(notSecond)
    }

    private fun memoization(nums1: IntArray, nums2: IntArray, a: Int, b: Int, took: Int, dp: Array<Array<IntArray>>): Int {
        if (a == nums1.size || b == nums2.size) {
            return if (took == 1) 0 else -(1e8.toInt())
        }
        if (dp[a][b][took] != -(1e8.toInt() + 1)) return dp[a][b][took]
        val takeBoth = (nums1[a] * nums2[b]) + memoization(nums1, nums2, a + 1, b + 1, 1, dp)
        val notFirst = memoization(nums1, nums2, a + 1, b, took, dp)
        val notSecond = memoization(nums1, nums2, a, b + 1, took, dp)
        dp[a][b][took] = takeBoth.coerceAtLeast(notFirst).coerceAtLeast(notSecond)
        return dp[a][b][took]
    }