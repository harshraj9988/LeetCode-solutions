    fun wordPattern(pattern: String, s: String): Boolean {
        val pat = pattern.toCharArray()
        val str = s.split(" ")
        val n = pat.size
        if (n != str.size) return false
        val strToChar = HashMap<String, Char>()
        val charToStr = HashMap<Char, String>()
        for (i in 0 until n) {
            if (!strToChar.containsKey(str[i]) && !charToStr.containsKey(pat[i])) {
                strToChar[str[i]] = pat[i]
                charToStr[pat[i]] = str[i]
            } else if (strToChar[str[i]] != pat[i] || charToStr[pat[i]] != str[i]) {
                return false
            }
        }
        return true
    }