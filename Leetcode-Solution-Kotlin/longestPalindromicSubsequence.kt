import kotlin.math.max

private fun recursion(s: String, t: String, i: Int, j: Int): Int {
    if (i < 0 || j < 0) {
        return 0
    }
    return if (s[i] == t[j]) {
        1 + recursion(s, t, i - 1, j - 1)
    } else {
        (recursion(s, t, i - 1, j)).coerceAtLeast(recursion(s, t, i, j - 1))
            .coerceAtLeast(recursion(s, t, i - 1, j - 1))
    }
}

private fun memoization(s: String, t: String, i: Int, j: Int, dp: Array<Array<Int>>): Int {
    if (i < 0 || j < 0) {
        return 0
    }

    if (dp[i][j] != -1) {
        return dp[i][j]
    }

    dp[i][j] = if (s[i] == t[j]) {
        1 + memoization(s, t, i - 1, j - 1, dp)
    } else {
        (memoization(s, t, i - 1, j, dp)).coerceAtLeast(memoization(s, t, i, j - 1, dp))
            .coerceAtLeast(memoization(s, t, i - 1, j - 1, dp))
    }
    return dp[i][j]
}


private fun tabulation(s: String, t: String, n: Int): Int {
    val dp = Array(n + 1) { Array(n + 1) { 0 } }

    for (i in 1..n) {
        for (j in 1..n) {
            dp[i][j] = if (s[i - 1] == t[j - 1]) {
                1 + dp[i - 1][j - 1]
            } else {
                dp[i][j - 1].coerceAtLeast(dp[i - 1][j]).coerceAtLeast(dp[i - 1][j - 1])
            }
        }
    }

    return dp[n][n]
}

fun longestPalindromeSubseq(s: String): Int {
    val t = s.reversed()
    val n = s.length
    return tabulation(s, t, n)
}

fun main() {
    val s = "bbbab"
    println(longestPalindromeSubseq(s))
}