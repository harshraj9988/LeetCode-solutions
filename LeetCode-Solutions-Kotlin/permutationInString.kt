fun checkInclusion(s1: String, s2: String): Boolean {
    val m = s1.length
    val n = s2.length
    if (n < m) return false
    val freq = IntArray(26)

    s1.forEach { freq[it - 'a']++ }
    for (i in 0 until m) {
        freq[s2[i] - 'a']--
    }

    var start = 0
    var end = m - 1

    while (end < n - 1) {
        if (freq.isZeros()) return true
        freq[s2[start++] - 'a']++
        freq[s2[++end] - 'a']--
    }
    return freq.isZeros()
}

private fun IntArray.isZeros(): Boolean {
    this.forEach { if (it != 0) return false }
    return true
}