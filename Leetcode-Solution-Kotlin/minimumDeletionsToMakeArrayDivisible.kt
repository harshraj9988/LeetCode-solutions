    fun minOperations(nums: IntArray, numsDivide: IntArray): Int {
        val gcd = gcdOfArray(numsDivide)
        nums.sort()
        for (i in nums.indices) {
            if (gcd % (nums[i]) == 0) {
                return i
            }
        }
        return -1
    }

    private fun gcdOfArray(arr: IntArray) = arr.reduce { a, b -> gcd(a, b) }

    private fun gcd(a: Int, b: Int): Int {
        var x = a
        var y = b
        while (x > 0 && y > 0)
            if (x > y) x %= y else y %= x
        return if (x == 0) y else x
    }