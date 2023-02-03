fun takeCharacters(s: String, k: Int): Int {
    val freq = IntArray(3)
    val n = s.length
    for (c in s) {
        ++freq[c - 'a']
    }
    freq.forEach { if (it < k) return -1 }
    var maxExcludedWindow = Int.MIN_VALUE
    var j = 0
    for (i in 0 until n) {
        if (--freq[s[i] - 'a'] < k) {
            while (freq[s[i] - 'a'] < k) {
                ++freq[s[j++] - 'a']
            }
        }
        maxExcludedWindow = maxExcludedWindow.coerceAtLeast(i - j + 1)
    }
    return n - maxExcludedWindow
}