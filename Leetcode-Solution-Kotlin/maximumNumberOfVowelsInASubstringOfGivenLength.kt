    private fun Char.isVowel(): Boolean = this == 'a' || this == 'e' || this == 'i' || this == 'o' || this == 'u'

    fun maxVowels(s: String, k: Int): Int {
        var i = 0
        var j = 0
        var maximum = 0
        var current = 0
        while (j < s.length) {
            if (s[j].isVowel()) {
                current++
            }
            maximum = maximum.coerceAtLeast(current)
            if (j - i + 1 == k) {
                if (s[i].isVowel()) {
                    current--
                }
                i++
            }
            j++
        }
        return maximum
    }