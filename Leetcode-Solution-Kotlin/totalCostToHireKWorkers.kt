    import java.util.*

    fun totalCost(costs: IntArray, k: Int, candidates: Int): Long {
        val left = PriorityQueue<Int>()
        val right = PriorityQueue<Int>()
        var s = 0
        var e = costs.lastIndex
        var total = 0L

        while (left.size < candidates) {
            left.add(costs[s++])
        }
        while (right.size < candidates && e >= s) {
            right.add(costs[e--])
        }

        repeat(k) {
            if (left.isEmpty() && right.isEmpty()) {
            } else if (left.isEmpty()) {
                total += right.poll().toLong()
            } else if (right.isEmpty()) {
                total += left.poll().toLong()
            } else if (left.peek() <= right.peek()) {
                total += left.poll().toLong()
                if (s <= e) left.add(costs[s++])
            } else {
                total += right.poll().toLong()
                if (s <= e) right.add(costs[e--])
            }
        }
        return total
    }