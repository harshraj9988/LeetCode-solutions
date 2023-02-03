    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        val n = graph.size
        val allPath = ArrayList<ArrayList<Int>>()
        val path = ArrayList<Int>()
        val vis = Array(n) { false }
        dfs(graph, 0, n - 1, allPath, path, vis)
        return allPath
    }

    private fun dfs(
        graph: Array<IntArray>,
        node: Int,
        dest: Int,
        allPath: ArrayList<ArrayList<Int>>,
        path: ArrayList<Int>,
        vis: Array<Boolean>
    ) {
        path.add(node)
        if (node == dest) {
            allPath.add(ArrayList(path))
        } else {
            graph[node].forEach { next ->
                if (!vis[next]) {
                    vis[next] = true
                    dfs(graph, next, dest, allPath, path, vis)
                    vis[next] = false
                }
            }
        }
        path.removeAt(path.size - 1)
    }
