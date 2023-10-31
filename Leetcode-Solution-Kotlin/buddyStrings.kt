    fun buddyStrings(s: String, goal: String): Boolean {
        val freq = IntArray(26)
        s.forEach { freq[it - 'a']++ }
        goal.forEach { freq[it - 'a']-- }
        for (x in freq) if (x != 0) return false
        var diff = 0
        for (i in s.indices) {
            if (s[i] != goal[i]) diff++
        }
        if (diff != 2 && diff != 0) return false
        if (diff == 2) return true
        for (c in s) freq[c - 'a']++
        for (x in freq) if (x == 2) return true
        return false
    }


