    private fun findParent(u: Int, parents: IntArray): Int {
        if (u == parents[u]) return u
        parents[u] = findParent(parents[u], parents)
        return parents[u]
    }

    private fun union(u: Int, v: Int, ranks: IntArray, parents: IntArray) {
        val parU = findParent(u, parents)
        val parV = findParent(v, parents)
        if (parU == parV) return
        if (ranks[parU] < ranks[parV]) {
            parents[parU] = parV
        } else if (ranks[parU] > ranks[parV]) {
            parents[parV] = parU
        } else {
            parents[parV] = parU
            ranks[parU]++
        }
    }

    fun findCircleNum(isConnected: Array<IntArray>): Int {
        val parents = IntArray(isConnected.size) { it }
        val ranks = IntArray(isConnected.size) { 0 }
        for (i in isConnected.indices) {
            for (j in isConnected.indices) {
                if (isConnected[i][j] == 1) {
                    union(i, j, ranks, parents)
                }
            }
        }
        for (i in isConnected.indices) findParent(i, parents)
        val set = HashSet<Int>()
        for (x in parents) set.add(x)
        val num = parents.count()
        return set.size
    }