import java.util.*
import kotlin.collections.ArrayList

fun getOrder(otasks: Array<IntArray>): IntArray {
    val n = otasks.size
    val tasks = Array(n) { Array(3) { 0 } }
    for (i in 0 until n) {
        tasks[i] = arrayOf(otasks[i][0], otasks[i][1], i)
    }

    Arrays.sort(tasks) { a, b ->
        if (a[0] != b[0]) a[0] - b[0]
        else if (a[1] != b[1]) a[1] - b[1]
        else a[2] - b[2]
    }

    val ans = ArrayList<Int>()
    var currTime = 0
    ans.add(tasks[0][2])
    currTime = tasks[0][0] + tasks[0][1]
    val pool = PriorityQueue<Array<Int>> { a, b ->
        if (a[0] != b[0]) a[0] - b[0] else a[1] - b[1]
    }

    var i = 1
    while (i < n) {
        while (tasks[i][0] > currTime && pool.isNotEmpty()) {
            currTime += pool.peek()[0]
            ans.add(pool.poll()[1])
        }
        if (currTime < tasks[i][0]) currTime = tasks[i][0]
        pool.add(arrayOf(tasks[i][1], tasks[i][2]))
        i++
    }
    while (pool.isNotEmpty()) ans.add(pool.poll()[1])
    return ans.toIntArray()
}

fun main() {
    val otasks = arrayOf(
        arrayOf(1, 2).toIntArray(),
        arrayOf(2, 4).toIntArray(),
        arrayOf(3, 2).toIntArray(),
        arrayOf(4, 1).toIntArray()
    )
    println(getOrder(otasks).contentToString())
}
