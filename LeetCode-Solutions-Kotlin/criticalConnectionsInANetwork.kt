fun criticalConnections(n: Int, connections: List<List<Int>>): List<List<Int>> {
    val adj = createAdjList(n, connections)
    val time = IntArray(n)
    val low = IntArray(n)
    val vis = Array(n) { false }
    val critical = ArrayList<ArrayList<Int>>()
    for (node in 0 until n) {
        if (!vis[node]) {
            dfs(node, -1, adj, time, low, vis, critical)
        }
    }
    return critical
}

private fun dfs(
    node: Int,
    parent: Int,
    adj: ArrayList<ArrayList<Int>>,
    time: IntArray,
    low: IntArray,
    vis: Array<Boolean>,
    critical: ArrayList<ArrayList<Int>>
) {
    vis[node] = true
    time[node] = (if (parent == -1) 1 else time[parent] + 1)
    low[node] = time[node]
    for (next in adj[node]) {
        if (!vis[next]) {
            dfs(next, node, adj, time, low, vis, critical)
        }
        if (next != parent) {
            low[node] = low[node].coerceAtMost(low[next])
            if (
                low[next] > time[node]
            ) {
                val bridge = ArrayList<Int>()
                bridge.add(node)
                bridge.add(next)
                critical.add(bridge)
            }
        }
    }
}

private fun createAdjList(n: Int, connections: List<List<Int>>): ArrayList<ArrayList<Int>> {
    val adj = ArrayList<ArrayList<Int>>()
    for (i in 0 until n) adj.add(ArrayList())
    connections.forEach { connection ->
        adj[connection[0]].add(connection[1])
        adj[connection[1]].add(connection[0])
    }
    return adj
}
