import java.util.PriorityQueue

    fun minCostConnectPoints(points: Array<IntArray>): Int {
        val adj = createAdjList(points)
        return primsAlgo(adj)
    }

    private fun primsAlgo(adj: HashMap<Int, ArrayList<Neighbour>>): Int {
        val n = adj.size
        val vis = BooleanArray(n) { false }
        var cost = 0
        val pq = PriorityQueue<Neighbour> { a, b -> a.weight.compareTo(b.weight) }
        pq.add(Neighbour(0, 0))
        while (pq.isNotEmpty()) {
            val weight = pq.peek().weight
            val node = pq.remove().node
            if (vis[node]) continue
            vis[node] = true
            cost += weight
            for (next in adj[node]!!) {
                if (vis[next.node]) continue
                pq.add(next)
            }
        }
        return cost
    }

    private fun createAdjList(points: Array<IntArray>) = HashMap<Int, ArrayList<Neighbour>>().apply {
        for (i in points.indices) {
            val neighboursOfI = ArrayList<Neighbour>()
            for (j in points.indices) {
                if (i == j) continue
                val cost = Math.abs(points[i][0] - points[j][0]) +
                        Math.abs(points[i][1] - points[j][1])
                neighboursOfI.add(Neighbour(j, cost))
            }
            this[i] = neighboursOfI
        }
    }

    data class Neighbour(val node: Int, val weight: Int)