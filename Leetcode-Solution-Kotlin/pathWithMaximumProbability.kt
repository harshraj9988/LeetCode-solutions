    import java.util.PriorityQueue

    fun maxProbability(n: Int, edges: Array<IntArray>, succProb: DoubleArray, start: Int, end: Int): Double {
        val adj = getAdjList(n, edges, succProb)
        val prob = DoubleArray(n) { 0.0 }
        prob[start] = 1.0
        val pq = PriorityQueue<Pair<Int, Double>> { a, b -> b.second.compareTo(a.second) }
        pq.add(Pair(start, 1.0))

        while (pq.isNotEmpty()) {
            val p = pq.peek().second
            val node = pq.poll().first

            for (next in adj[node]) {
                val np = next.second * p
                val dest = next.first

                if (np > prob[dest]) {
                    prob[dest] = np
                    pq.add(Pair(dest, np))
                }
            }

        }

        return prob[end]
    }

    private fun getAdjList(n: Int, edges: Array<IntArray>, succProb: DoubleArray): ArrayList<ArrayList<Pair<Int, Double>>> {
        val adj = ArrayList<ArrayList<Pair<Int, Double>>>().apply { repeat(n) { add(ArrayList()) } }
        edges.forEachIndexed { i, edge ->
            adj[edge[0]].add(Pair(edge[1], succProb[i]))
            adj[edge[1]].add(Pair(edge[0], succProb[i]))
        }
        return adj
    }