    import java.util.*

    private lateinit var parents: IntArray
    private lateinit var rank: IntArray

    private fun findParent(u: Int): Int {
        return if (parents[u] < 0) u else {
            parents[u] = findParent(parents[u])
            parents[u]
        }
    }

    private fun union(u: Int, v: Int): Boolean {
        val parU = findParent(u)
        val parV = findParent(v)

        if (parU == parV) return false

        if (parents[parU] <= parents[parV]) {
            parents[parU] += parents[parV]
            parents[parV] = parU
        } else {
            parents[parV] = parents[parU]
            parents[parU] = parV

        }

        return true
    }

    fun numberOfGoodPaths(vals: IntArray, edges: Array<IntArray>): Int {
        val n = vals.size
        parents = IntArray(n)
        rank = IntArray(n)
        var ans = 0

        val adj = ArrayList<ArrayList<Int>>()

        val values = TreeMap<Int, ArrayList<Int>>()

        for (i in 0 until n) {
            parents[i] = -1
            values[vals[i]] = ArrayList<Int>()
            adj.add(ArrayList<Int>())
        }

        for(i in 0 until n) {
            values[vals[i]]!!.add(i)
        }

        for (edge in edges) {
            if (vals[edge[0]] >= vals[edge[1]]) {
                adj[edge[0]].add(edge[1])
            } else {
                adj[edge[1]].add(edge[0])
            }
        }

        for (entry in values.entries) {
            for (u in entry.value) {
                for (v in adj[u]) {
                    union(u, v)
                }
            }

            val group = HashMap<Int, Int>()

            for (u in entry.value) {
                group[findParent(u)] = (group[findParent(u)] ?: 0) + 1
            }

            ans += entry.value.size

            for (grp in group.entries) {
                val size = grp.value
                ans += ((size * (size - 1)) / 2)
            }
        }
        return ans
    }