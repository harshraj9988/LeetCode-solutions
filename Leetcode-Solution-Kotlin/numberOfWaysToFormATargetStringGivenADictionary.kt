    private const val MOD = 1e9.toLong() + 7L
    private fun recursion(words: Array<String>, target: String, charInd: Int, targetInd: Int, freq: Array<IntArray>): Long {
        if (targetInd == target.length) {
            return 1L
        }
        if (charInd >= words[0].length || words[0].length - charInd < target.length - targetInd) {
            return 0L
        }
        var count = 0L
        count += freq[charInd][target[targetInd] - 'a'] * recursion(words, target, charInd + 1, targetInd + 1, freq) % MOD
        count += recursion(words, target, charInd + 1, targetInd, freq) % MOD

        return count % MOD
    }

    private fun memoization(
        words: Array<String>,
        target: String,
        charInd: Int,
        targetInd: Int,
        freq: Array<IntArray>,
        dp: Array<Array<Long>>
    ): Long {
        if (targetInd == target.length) {
            return 1L
        }
        if (charInd >= words[0].length || words[0].length - charInd < target.length - targetInd) {
            return 0L
        }
        if (dp[charInd][targetInd] != -1L) {
            return dp[charInd][targetInd]
        }
        var count = 0L
        count += freq[charInd][target[targetInd] - 'a'] * memoization(
            words,
            target,
            charInd + 1,
            targetInd + 1,
            freq,
            dp
        ) % MOD
        count += memoization(words, target, charInd + 1, targetInd, freq, dp) % MOD
        dp[charInd][targetInd] = count % MOD
        return dp[charInd][targetInd]
    }

    fun numWays(words: Array<String>, target: String): Int {
        val freq = Array(words[0].length) { IntArray(26) }
        for (word in words) {
            for (i in word.indices) {
                val curPos = word[i] - 'a'
                freq[i][curPos] += 1
            }
        }
        val dp = Array(words[0].length + 1) { Array(target.length + 1) { -1L } }
        return (memoization(words, target, 0, 0, freq, dp) % MOD).toInt()
    }

    fun main() {
        val words = arrayOf("acca", "bbbb", "caca")
        val target = "aba"
        println(numWays(words, target))
    }