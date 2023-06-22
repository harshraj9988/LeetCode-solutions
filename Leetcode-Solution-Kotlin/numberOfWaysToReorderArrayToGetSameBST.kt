    private lateinit var pascalsTriangle: Array<LongArray>
    private val mod = 1e9.toLong() + 7L

    fun numOfWays(nums: IntArray): Int {
        pascalsTriangle = Array(nums.size) { longArrayOf() }
        repeat(nums.size) {
            pascalsTriangle[it] = LongArray(nums.size)
        }
        repeat(nums.size) { i ->
            pascalsTriangle[i][i] = 1L
            repeat(i) { j ->
                if (j == 0) pascalsTriangle[i][j] = 1L
                else if (i > 1 && j > 0) pascalsTriangle[i][j] = (pascalsTriangle[i - 1][j - 1] + pascalsTriangle[i - 1][j])%mod
            }
        }
        return dfs(nums.toList()).toInt()
    }

    private fun dfs(arr: List<Int>): Long {
        if (arr.size <= 1) return arr.size.toLong()
        val left = arr.filter { it < arr[0] }
        val right = arr.filter { it > arr[0] }
        val p = pascalsTriangle[arr.size - 1][left.size]
        val leftWays = dfs(left)
        val rightWays = dfs(right)
        return (((p * leftWays) % mod) * rightWays) % mod
    }