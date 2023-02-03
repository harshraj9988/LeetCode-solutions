    fun gcdOfStrings(str1: String, str2: String): String {
        var ans = ""
        for (i in 1..str1.length.coerceAtMost(str2.length)) {
            val temp = match(str1, str2, i)
            if (temp.length > ans.length) ans = temp
        }
        return ans
    }

    private fun match(a: String, b: String, length: Int): String {
        if (a.length % length != 0 || b.length % length != 0) return ""

        for (i in a.indices step length) {
            for (j in 0 until length) {
                if (a[j] != a[i + j]) return ""
            }
        }

        for (i in b.indices step length) {
            for (j in 0 until length) {
                if (a[j] != b[i + j]) return ""
            }
        }

        return a.substring(0 until length)
    }
