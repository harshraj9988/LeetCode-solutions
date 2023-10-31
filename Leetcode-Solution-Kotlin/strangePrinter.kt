    import java.util.*
    import java.util.regex.Pattern

    fun strangePrinter(s: String): Int {
        val text = Pattern.compile("(.)\\1+").matcher(s).replaceAll("$1")
        return rec(0, text.lastIndex, text, Array(text.length) { IntArray(text.length) })
    }

    private fun rec(l: Int, r: Int, s: String, dp: Array<IntArray>): Int {
        if (l > r) return 0
        if (dp[l][r] != 0) return dp[l][r]
        var ops = 1 + rec(l + 1, r, s, dp)

        for (i in l + 1..r) {
            if (s[i] == s[l]) {
                ops = ops.coerceAtMost(
                    rec(l + 1, i - 1, s, dp) +
                            rec(i, r, s, dp)
                )
            }
        }

        dp[l][r] = ops
        return ops
    }

    fun main() {
        val sb= StringBuilder()
        sb.append('a')
        sb.append('b')
        
        println(sb.toString())
    }
