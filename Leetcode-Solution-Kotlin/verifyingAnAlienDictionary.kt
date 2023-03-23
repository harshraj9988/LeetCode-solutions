    fun isAlienSorted(words: Array<String>, order: String): Boolean {
        val map = HashMap<Char, Char>()
        var c = 'a'
        order.forEach {
            map[it] = c++
        }
        for (i in words.indices) {
            val sb = StringBuilder()
            words[i].forEach {
                sb.append(map[it]!!)
            }
            words[i] = sb.toString()
            sb.clear()
        }
        for (i in 1 until words.size) {
            if (words[i - 1] > words[i]) return false
        }
        return true
    }