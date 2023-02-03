fun minTime(n: Int, edges: Array<IntArray>, hasApple: List<Boolean>): Int {
    val adj = ArrayList<ArrayList<Int>>()
    getAdjList(edges, adj, n)
    return dfs(adj, 0, 0, hasApple, -1).down - 1
}

private fun getAdjList(edges: Array<IntArray>, adj: ArrayList<ArrayList<Int>>, n: Int) {
    for (i in 0 until n) {
        adj.add(ArrayList<Int>())
    }
    for (edge in edges) {
        adj[edge[0]].add(edge[1])
        adj[edge[1]].add(edge[0])
    }
}

private fun dfs(adj: ArrayList<ArrayList<Int>>, node: Int, down: Int, hasApple: List<Boolean>, parent: Int): Pair {
    val childrenPair = ArrayList<Pair>()

    val pair = Pair(down, hasApple[node])

    for (next in adj[node]) {
        if (next == parent) continue
        childrenPair.add(dfs(adj, next, down + 1, hasApple, node))
    }

    childrenPair.filter { it.apple }.forEach {
        pair.apple = true
        pair.down += (it.down - down)
    }

    pair.down += 1
    return pair
}

private data class Pair(var down: Int, var apple: Boolean)
