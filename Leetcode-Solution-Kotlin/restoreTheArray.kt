private val MOD = 1e9.toLong() + 7L
private fun recursion(s: String, k: Long, i: Int): Long {
    if (i == s.length) {
        return 1L
    }
    if (s[i] == '0') {
        return 0L
    }
    var count = 0L
    var num = 0L
    for (x in i until s.length) {
        if ((num * 10L) + (s[x] - '0').toLong() > k) break
        num = (num * 10L) + (s[x] - '0').toLong()
        count += recursion(s, k, x + 1) % MOD
    }

    return count % MOD
}

private fun memoization(s: String, k: Long, i: Int, dp: Array<Long>): Long {
    if (i == s.length) {
        return 1
    }
    if (s[i] == '0') {
        return 0
    }
    if (dp[i] != -1L) {
        return dp[i]
    }
    var count = 0L
    var num = 0L
    for (x in i until s.length) {
        if ((num * 10L) + (s[x] - '0').toLong() > k) break
        num = (num * 10L) + (s[x] - '0').toLong()
        count += memoization(s, k, x + 1, dp) % MOD
    }
    dp[i] = count % MOD
    return dp[i]
}

private fun tabulation(s: String, k: Long): Int {
    val dp = Array(s.length + 1) { 0L }
    dp[s.length] = 1
    for (i in s.length - 1 downTo 0) {
        if (s[i] == '0') continue
        var num = 0L
        for (x in i until s.length) {
            if (num * 10L + (s[x] - '0').toLong() > k.toLong()) break
            num = num * 10L + (s[x] - '0').toLong()
            dp[i] += dp[x + 1] % MOD
        }
    }
    return (dp[0] % MOD).toInt()
}

fun numberOfArrays(s: String, k: Int): Int {
    val dp = Array(s.length + 1) { -1L }
    return memoization(s, k.toLong(), 0, dp).toInt()
}
