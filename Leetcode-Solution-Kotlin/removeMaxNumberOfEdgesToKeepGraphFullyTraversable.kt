import java.util.*

private class UnionFind(n: Int) {
    val parents = IntArray(n) { it }
    val ranks = IntArray(n) { 0 }

    fun findParent(u: Int): Int {
        if (u == parents[u]) {
            return u
        }
        parents[u] = findParent(parents[u])
        return parents[u]
    }

    fun union(u: Int, v: Int): Boolean {
        val parU = findParent(u)
        val parV = findParent(v)
        if (parU == parV) {
            return false
        }
        if (ranks[parU] < ranks[parV]) {
            parents[parU] = parV
        } else if (ranks[parU] > ranks[parV]) {
            parents[parV] = parU
        } else {
            parents[parV] = parU
            ranks[parU]++
        }
        return true
    }

    fun finalize() {
        for (i in parents.indices) {
            findParent(i)
        }
    }

    fun allReachable(): Boolean {
        val parent = parents[0]
        for (p in parents) {
            if (p != parent) {
                return false
            }
        }
        return true
    }
}

fun maxNumEdgesToRemove(n: Int, edges: Array<IntArray>): Int {
    val alice = UnionFind(n)
    val bob = UnionFind(n)
    Arrays.sort(edges) { a, b ->
        b[0].compareTo(a[0])
    }

    var removableEdges = 0

    for (edge in edges) {
        when (edge[0]) {
            1 -> {
                if (!alice.union(edge[1] - 1, edge[2] - 1)) {
                    removableEdges++
                }
            }

            2 -> {
                if (!bob.union(edge[1] - 1, edge[2] - 1)) {
                    removableEdges++
                }
            }

            else -> {
                val forAlice = alice.union(edge[1] - 1, edge[2] - 1)
                val forBob = bob.union(edge[1] - 1, edge[2] - 1)
                if (!forAlice && !forBob) {
                    removableEdges++
                }
            }
        }
    }

    alice.finalize()
    bob.finalize()

    return if (alice.allReachable() && bob.allReachable())
        removableEdges
    else -1

}
