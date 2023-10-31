import java.util.*
import kotlin.collections.ArrayList

fun minimumTime(n: Int, relations: Array<IntArray>, time: IntArray): Int {
    val inDegree = IntArray(n)
    val adj = createAdjList(n, relations, inDegree)
    val times = time.clone()

    val queue: Queue<Int> = LinkedList()
    inDegree.forEachIndexed { book, reqBooksCount ->
        if (reqBooksCount == 0) queue.add(book)
    }

    while (queue.isNotEmpty()) {
        val curr = queue.poll()
        val timeTillNow = times[curr]
        for (next in adj[curr]) {
            val updatedTime = timeTillNow + time[next]
            if (updatedTime > times[next]) {
                times[next] = updatedTime
                queue.add(next)
            }
        }
    }
    return times.reduce { acc, i -> Math.max(acc, i) }
}

private fun createAdjList(n: Int, relations: Array<IntArray>, inDegree: IntArray): ArrayList<ArrayList<Int>> {
    val adj = ArrayList<ArrayList<Int>>().apply {
        repeat(n) {
            this.add(ArrayList())
        }
    }
    for (relation in relations) {
        val from = relation[0] - 1
        val to = relation[1] - 1
        inDegree[to]++
        adj[from].add(to)
    }
    return adj
}
