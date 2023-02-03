    fun sumOfDistancesInTree(n: Int, edges: Array<IntArray>): IntArray {
        val adj = ArrayList<ArrayList<Int>>()
        val nodesInSubtree = IntArray(n)
        val distanceSums = IntArray(n)

        for (i in 0 until n) adj.add(ArrayList())
        for (edge in edges) {
            adj[edge[0]].add(edge[1])
            adj[edge[1]].add(edge[0])
        }
        findSumWithZeroAsRoot(0, -1, adj, distanceSums, nodesInSubtree)
        relocatedRoots(0, -1, adj, distanceSums, nodesInSubtree, n)
        return distanceSums
    }

    fun findSumWithZeroAsRoot(
        node: Int,
        parent: Int,
        adj: ArrayList<ArrayList<Int>>,
        distanceSum: IntArray,
        nodesInSubtree: IntArray
    ) {
        for (next in adj[node]) {
            if (next == parent) continue
            findSumWithZeroAsRoot(next, node, adj, distanceSum, nodesInSubtree)
            nodesInSubtree[node] += nodesInSubtree[next]
            distanceSum[node] += distanceSum[next] + nodesInSubtree[next]
        }
        nodesInSubtree[node].inc()
    }

    fun relocatedRoots(
        node: Int,
        parent: Int,
        adj: ArrayList<ArrayList<Int>>,
        distanceSum: IntArray,
        nodesInSubtree: IntArray,
        totalNodes: Int
    ) {
        for (next in adj[node]) {
            if (next == parent) continue
            distanceSum[next] = distanceSum[node] - nodesInSubtree[next] + totalNodes - nodesInSubtree[next]
            relocatedRoots(next, node, adj, distanceSum, nodesInSubtree, totalNodes)
        }
    }
