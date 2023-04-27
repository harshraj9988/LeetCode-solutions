import java.util.*

    fun lastStoneWeight(stones: IntArray): Int {
        val pq = PriorityQueue<Int>(Collections.reverseOrder())
        stones.forEach{ pq.add(it) }
        while(pq.size > 1) {
            val a = pq.poll()
            val b = pq.poll()
            if (b < a) {
                pq.add(a - b)
            }
        }
        return if (pq.isNotEmpty()) pq.peek() else 0
    }