import java.util.*
import kotlin.collections.ArrayList

fun shortestAlternatingPaths(n: Int, redEdges: Array<IntArray>, blueEdges: Array<IntArray>): IntArray {
    val adj = getAdjList(n, redEdges, blueEdges)
    val dist = Array(2) { Array(n) { 1e8.toInt() } }
    dist[0][0] = 0
    dist[1][0] = 0

    val queue: Queue<Array<Int>> = LinkedList()
    adj[0].forEachIndexed { i, arr ->
        arr.forEach {
            queue.add(arrayOf(it, i))
            dist[i][it] = 1
        }
    }

    while (queue.isNotEmpty()) {
        val curr = queue.peek()[0]
        val prevEdge = queue.poll()[1]
        val prevDist = dist[prevEdge][curr]

        val nextEdge = 1 - prevEdge
        val nextDist = prevDist + 1

        adj[curr][nextEdge].forEach { next ->
            if (nextDist < dist[nextEdge][next]) {
                dist[nextEdge][next] = nextDist
                queue.add(arrayOf(next, nextEdge))
            }
        }
    }

    for (i in 0 until n) {
        dist[0][i] = dist[0][i].coerceAtMost(dist[1][i])
        if (dist[0][i] == 1e8.toInt()) dist[0][i] = -1
    }
    return dist[0].toIntArray()
}

private fun getAdjList(n: Int, redEdges: Array<IntArray>, blueEdges: Array<IntArray>): Array<Array<ArrayList<Int>>> {
    val adj = Array(n) { Array(2) { ArrayList<Int>() } }
    redEdges.forEach { rEdge ->
        adj[rEdge[0]][0].add(rEdge[1])
    }
    blueEdges.forEach { bEdge ->
        adj[bEdge[0]][1].add(bEdge[1])
    }

    val a = 10
    val b = "$a"
    val c = b.toInt()
    println(c)
    return adj
}

fun main(){
    val a = 10
    val d = 10
    val b = "$a$d"
    val c = b.toInt()
    println(c)
}