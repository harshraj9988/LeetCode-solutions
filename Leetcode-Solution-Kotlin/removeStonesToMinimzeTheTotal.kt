import java.util.PriorityQueue
import kotlin.math.ceil

    fun minStoneSum(piles: IntArray, k: Int): Int {
        val pq = PriorityQueue<Int>(reverseOrder())
        piles.forEach { pq.add(it) }
        var n = k
        while (n-- > 0) {
            val temp = ceil(pq.poll().toDouble() / 2.toDouble()).toInt()
            pq.add(temp)
        }
        return piles.reduce { a, b -> a + b }
    }