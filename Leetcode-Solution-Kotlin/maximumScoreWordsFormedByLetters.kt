    fun maxScoreWords(words: Array<String>, letters: CharArray, score: IntArray): Int {
        val lettersFreq = IntArray(26)
        for (letter in letters) {
            lettersFreq[letter - 'a']++
        }
        val n = words.size
        val wordsFreq = Array(n) { MyPair(0) }
        for (i in 0 until n) {
            for (c in words[i]) {
                wordsFreq[i].second[c - 'a']++
                wordsFreq[i].first += score[c - 'a']
            }
        }
        val dp = Array(n) { HashMap<String, Int>() }
        return memoization(wordsFreq, lettersFreq, n - 1, minus(lettersFreq, IntArray(26), IntArray(26)).first, dp)
    }

    private fun recursion(words: Array<MyPair>, lettersFreq: IntArray, i: Int, j: String): Int {
        if (i < 0) return 0
        val c = IntArray(26)
        val check = minus(lettersFreq, words[i].second, c)
        var pick = 0
        var notPick = 0
        if (check.second) {
            pick = words[i].first + recursion(words, c, i - 1, check.first)
        }
        notPick = recursion(words, lettersFreq, i - 1, j)
        return Math.max(pick, notPick)
    }

    private fun memoization(words: Array<MyPair>, lettersFreq: IntArray, i: Int, j: String, dp: Array<HashMap<String, Int>>): Int {
        if (i < 0) return 0
        if(dp[i].containsKey(j)) return dp[i][j]!!
        val c = IntArray(26)
        val check = minus(lettersFreq, words[i].second, c)
        var pick = 0
        var notPick = 0
        if (check.second) {
            pick = words[i].first + memoization(words, c, i - 1, check.first, dp)
        }
        notPick = memoization(words, lettersFreq, i - 1, j, dp)
        dp[i][j] = Math.max(pick, notPick)
        return dp[i][j]!!
    }
    private data class MyPair(
        var first: Int,
        val second: IntArray = IntArray(26)
    )

    private fun minus(a: IntArray, b: IntArray, c: IntArray): Pair<String, Boolean> {
        val sb = StringBuilder()
        for (i in 0 until 26) {
            c[i] = a[i] - b[i]
            if (c[i] < 0) {
                return Pair("", false)
            }
            sb.append(c[i])
        }
        return Pair(sb.toString(), true)
    }