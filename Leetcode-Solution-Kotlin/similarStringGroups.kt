    private lateinit var parents: Array<Int>
    private lateinit var ranks: Array<Int>

    private fun findParent(u: Int): Int {
        if (u == parents[u]) {
            return u
        }
        parents[u] = findParent(parents[u])
        return parents[u]
    }

    private fun union(u: Int, v: Int) {
        val parU = findParent(u)
        val parV = findParent(v)
        if(parU == parV) {
            return
        }
        if (ranks[parU] < ranks[parV]) {
            parents[parU] = parV
        } else if (ranks[parU] > ranks[parV]) {
            parents[parV] = parU
        } else {
            parents[parV] = parU
            ranks[parU] += 1
        }
    }

    private infix fun String.isSimilarTo(str: String): Boolean {
        var notCommon = 0
        this.forEachIndexed { i, c ->
            if (c != str[i]) {
                notCommon++
            }
        }
        return notCommon == 2 || notCommon == 0
    }

    fun numSimilarGroups(strs: Array<String>): Int {
        val n = strs.size
        val m = strs[0].length

        parents = Array(n) { it }
        ranks = Array(n) { 0 }

        for (i in 0 until n) {
            for (j in i+1 until n) {
                if(strs[i] isSimilarTo strs[j]) {
                    union(i, j)
                }
            }
        }

        val set = HashSet<Int>()
        for(i in 0 until n) {
            set.add(findParent(i))
        }

        return set.size
    }

