    private fun recursion(A: IntArray, B: IntArray, a: Int, b: Int): Int {
        if (a < 0 || b < 0) {
            return 0
        }
        var matched = 0
        var moveFirst = 0
        var moveSecond = 0
        if (A[a] == B[b]) {
            matched = 1 + (recursion(A, B, a - 1, b - 1))
        }
        moveFirst = recursion(A, B, a - 1, b)
        moveSecond = recursion(A, B, a, b - 1)
        return matched.coerceAtLeast(moveFirst).coerceAtLeast(moveSecond)

    }

    private fun memoization(A: IntArray, B: IntArray, a: Int, b: Int, dp: Array<IntArray>): Int {
        if (a < 0 || b < 0) {
            return 0
        }
        if (dp[a][b] != -1) {
            return dp[a][b]
        }
        var matched = 0
        var moveFirst = 0
        var moveSecond = 0
        if (A[a] == B[b]) {
            matched = 1 + (memoization(A, B, a - 1, b - 1, dp))
        }
        moveFirst = memoization(A, B, a - 1, b, dp)
        moveSecond = memoization(A, B, a, b - 1, dp)
        dp[a][b] = matched.coerceAtLeast(moveFirst).coerceAtLeast(moveSecond)
        return dp[a][b]

    }

    fun maxUncrossedLines(nums1: IntArray, nums2: IntArray): Int {
        val dp = Array(nums1.size) { IntArray(nums2.size) { -1 } }
        return memoization(nums1, nums2, nums1.lastIndex, nums2.lastIndex, dp)
    }