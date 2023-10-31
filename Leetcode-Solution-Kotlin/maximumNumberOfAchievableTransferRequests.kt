    var ans = 0
    fun maximumRequests(n: Int, requests: Array<IntArray>): Int {
        val count = IntArray(n) { 0 }
        dfs(count, requests, requests.lastIndex, 0)
        return ans
    }

    private fun dfs(count: IntArray, requests: Array<IntArray>, i: Int, considered: Int) {
        if (i < 0) {
            for (x in count) if (x != 0) return
            ans = ans.coerceAtLeast(considered)
            return
        }
        count[requests[i][0]]--
        count[requests[i][1]]++
        dfs(count, requests, i - 1, considered + 1)
        count[requests[i][0]]++
        count[requests[i][1]]--
        dfs(count, requests, i - 1, considered)
    }
