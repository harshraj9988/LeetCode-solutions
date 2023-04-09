import java.util.*
import kotlin.collections.ArrayList

    private fun getAdjList(edges: Array<IntArray>, n: Int): ArrayList<ArrayList<Int>> {
        val adj = ArrayList<ArrayList<Int>>()
        for(i in 0 until n){
            adj.add(ArrayList())
        }
        for(edge in edges) {
            adj[edge[0]].add(edge[1])
        }
        return adj
    }

    private fun update(node: Array<Int>, next: Array<Int>, color: Int) {
        for (i in 0 until 26) {
            next[i] = next[i].coerceAtLeast(node[i])
        }
        if (node[color] + 1 > next[color]) {
            next[color] = node[color] + 1
        }
    }

    private fun khansAlgo(
        adj: ArrayList<ArrayList<Int>>,
        n: Int,
        colors: Array<Array<Int>>,
        cols: Array<Int>
    ): ArrayList<Int> {
        val inDegree = ArrayList<Int>()
        for (i in 0 until n) {
            inDegree.add(0)
        }
        for (nodes in adj) {
            for (node in nodes) {
                inDegree[node] += 1
            }
        }
        val queue: Queue<Int> = LinkedList()
        for (i in 0 until n) {
            if (inDegree[i] == 0) {
                queue.add(i)
            }
        }
        val arr = ArrayList<Int>()
        while (queue.isNotEmpty()) {
            val node = queue.poll()
            arr.add(node)
            for (next in adj[node]) {
                inDegree[next] -= 1
                update(colors[node], colors[next], cols[next])
                if (inDegree[next] == 0) {
                    queue.add(next)
                }
            }
        }
        return arr
    }

    fun largestPathValue(colors: String, edges: Array<IntArray>): Int {
        val n = colors.length
        val clrs = Array(n) { Array(26) { 0 } }
        val cols = Array(n) { 0 }
        for (i in 0 until n) {
            cols[i] = colors[i] - 'a'
            clrs[i][cols[i]] = 1
        }
        val adj = getAdjList(edges, n)
        val sorted = khansAlgo(adj, n, clrs, cols)
        if (sorted.size != n) {
            return -1
        }
        var result = 0
        for (i in 0 until n) {
            for (j in 0 until 26) {
                result = result.coerceAtLeast(clrs[i][j])
            }
        }
        return result
    }