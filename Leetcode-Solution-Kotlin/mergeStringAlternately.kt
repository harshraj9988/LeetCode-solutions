    fun mergeAlternately(word1: String, word2: String): String {
        val m = word1.length
        val n = word2.length
        var i = 0
        var j = 0
        val sb = StringBuilder()
        while (i < m && j < n) {
            sb.append("${word1[i++]}${word2[j++]}")
        }
        if (i < m) {
            sb.append(word1.substring(i))
        }
        if (j < n) {
            sb.append(word2.substring(j))
        }
        return sb.toString()
    }