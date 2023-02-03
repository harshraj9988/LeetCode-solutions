fun closeStrings(word1: String, word2: String): Boolean {
    val word1Length = word1.length
    if (word1Length != word2.length) return false
    val freq1 = IntArray(26)
    val freq2 = IntArray(26)
    val charactersInWord1 = BooleanArray(26)
    val charactersInWord2 = BooleanArray(26)
    for (i in 0 until word1Length) {
        charactersInWord1[word1[i] - 'a'] = true
        charactersInWord2[word2[i] - 'a'] = true
        freq1[word1[i] - 'a']++
        freq2[word2[i] - 'a']++
    }
    freq1.sort()
    freq2.sort()
    for (i in 0 until 26) {
        if (charactersInWord1[i] != charactersInWord2[i] || freq1[i] != freq2[i]) return false
    }
    return true
}

