    import java.util.LinkedList
    import java.util.Queue

    fun findParent(u: Int, parents: IntArray): Int {
        if (parents[u] == u) return u
        parents[u] = findParent(parents[u], parents)
        return parents[u]
    }

    fun union(u: Int, v: Int, parents: IntArray, ranks: IntArray) {
        val parU = findParent(u, parents)
        val parV = findParent(v, parents)
        if (parU == parV) {
            return
        } else if (ranks[parU] < ranks[parV]) {
            parents[parU] = parV
        } else if (ranks[parV] < ranks[parU]) {
            parents[parV] = parU
        } else {
            parents[parV] = parU
            ranks[parU]++
        }
    }

    fun solveUsingUnionFind(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        val parents = IntArray(n)
        val ranks = IntArray(n)
        for (i in 0 until n) {
            parents[i] = i
        }
        for (edge in edges) {
            union(edge[0], edge[1], parents, ranks)
        }
        return findParent(source, parents) == findParent(destination, parents)
    }

    fun solveUsingBFS(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        val adj = ArrayList<ArrayList<Int>>()
        for (i in 0 until n) {
            adj.add(ArrayList<Int>())
        }
        for (edge in edges) {
            adj[edge[0]].add(edge[1])
            adj[edge[1]].add(edge[0])
        }
        val visited = BooleanArray(n)
        val queue: Queue<Int> = LinkedList()
        visited[source] = true
        queue.add(source)
        while (queue.isNotEmpty()) {
            val curr = queue.poll()
            if (curr == destination) return true
            for (next in adj[curr]) {
                if (visited[next]) continue
                visited[next] = true
                queue.add(next)
            }
        }
        return false
    }

    fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        return solveUsingBFS(n, edges, source, destination)
    }
















