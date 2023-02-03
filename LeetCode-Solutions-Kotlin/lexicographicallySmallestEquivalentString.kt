    import java.lang.StringBuilder

    fun smallestEquivalentString(s1: String, s2: String, baseStr: String): String {
        val parent = HashMap<Char, Char>()
        s1.forEach { parent[it] = it }
        s2.forEach { parent[it] = it }
        baseStr.forEach { parent[it] = it }

        val n = s1.length.coerceAtMost(s2.length)
        for (i in 0 until n) {
            union(s1[i], s2[i], parent)
        }

        val newStr = baseStr.map { findParent(it, parent) }
        return String(newStr.toCharArray())
    }

    private fun findParent(u: Char, parent: HashMap<Char, Char>): Char {
        if (parent[u]!! == u) return u
        parent[u] = findParent(parent[u]!!, parent)
        return parent[u]!!
    }

    private fun union(u: Char, v: Char, parent: HashMap<Char, Char>) {
        val parU = findParent(u, parent)
        val parV = findParent(v, parent)
        val mini = if (parU <= parV) parU else parV
        val maxi = if (mini == parU) parV else parU
        parent[maxi] = mini
    }