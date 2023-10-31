class ExtraCharactersInString {
    inner class Trie(
        var children: Array<Trie?> = Array(26) { null },
        var isWord: Boolean = false
    ) {
        fun addWord(word: String) {
            var trie: Trie = this@Trie
            for (c in word) {
                if (trie.children[c - 'a'] == null) {
                    trie.children[c - 'a'] = Trie()
                }
                trie = trie.children[c - 'a']!!
            }
            trie.isWord = true
        }
    }

    fun minExtraChar(s: String, dictionary: Array<String>): Int {
        val trie = Trie()
        dictionary.forEach {
            trie.addWord(it)
        }

        return mem(s, trie, 0, IntArray(s.length) { -1 })
    }

    private fun rec(s: String, root: Trie, start: Int): Int {
        if (start >= s.length) {
            return 0
        }
        var trie = root
        var ans = Int.MAX_VALUE
        for (i in start until s.length) {
            val rem = rec(s, root, i + 1)
            val noWord = i - start + 1 + rem
            ans = ans.coerceAtMost(noWord)

            if (trie.children[s[i] - 'a'] == null) {
                break
            }
            trie = trie.children[s[i] - 'a']!!
            if (trie.isWord) ans = ans.coerceAtMost(rem)
        }
        return ans
    }

    private fun mem(s: String, root: Trie, start: Int, dp: IntArray): Int {
        if (start >= s.length) {
            return 0
        }
        if(dp[start] != -1) return dp[start]
        var trie = root
        var ans = Int.MAX_VALUE
        for (i in start until s.length) {
            val rem = mem(s, root, i + 1, dp)
            val noWord = i - start + 1 + rem
            ans = ans.coerceAtMost(noWord)

            if (trie.children[s[i] - 'a'] == null) {
                break
            }
            trie = trie.children[s[i] - 'a']!!
            if (trie.isWord) ans = ans.coerceAtMost(rem)
        }
        dp[start] = ans
        return ans
    }
}