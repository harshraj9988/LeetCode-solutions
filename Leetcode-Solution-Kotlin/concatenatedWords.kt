    private data class Trie(
        var children: Array<Trie?> = Array(26) { null },
        var isWord: Boolean = false
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Trie

            if (!children.contentEquals(other.children)) return false

            return true
        }

        override fun hashCode(): Int {
            return children.contentHashCode()
        }
    }

    fun findAllConcatenatedWordsInADict(words: Array<String>): List<String> {
        val root = Trie()
        val ans = ArrayList<String>()
        words.forEach { word ->
            var current = root
            word.forEach { c ->
                if (current.children[c - 'a'] == null) current.children[c - 'a'] = Trie()
                current = current.children[c - 'a']!!
            }
            if (current != root) current.isWord = true
        }
        words.forEach { word ->
            if (dfs(root, word, 0, word.length - 1))
                ans.add(word)
        }
        return ans
    }

    private fun dfs(root: Trie, word: String, start: Int, end: Int): Boolean {
        var current = root
        for (i in start..end) {
            val c = word[i]
            if (current.children[c - 'a'] == null) return false
            current = current.children[c - 'a']!!
            if (current.isWord) {
                if (isWord(root, word, i + 1, end) || dfs(root, word, i + 1, end)) {
                    return true
                }
            }
        }
        return false
    }


    private fun isWord(root: Trie, word: String, start: Int, end: Int): Boolean {
        var current = root
        for (i in start..end) {
            val c = word[i]
            if (current.children[c - 'a'] == null) return false
            current = current.children[c - 'a']!!
        }
        return current.isWord
    }