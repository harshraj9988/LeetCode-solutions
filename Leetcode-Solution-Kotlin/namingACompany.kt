    fun distinctNames(ideas: Array<String>): Long {
        val map = HashMap<Char, HashSet<String>>()
        for (c in 'a'..'z') map[c] = HashSet()
        ideas.forEach { map[it[0]]!!.add(it.substring(1)) }
        var total = 0L
        for (i in 'a'..'y') {
            for (j in i + 1..'z') {
                var common = 0L
                map[i]!!.forEach {
                    if (map[j]!!.contains(it)) common++
                }
                total += (2 * (map[i]!!.size - common) * (map[j]!!.size - common))
            }
        }
        return total
    }



