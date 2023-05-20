import java.util.*

    fun predictPartyVictory(senate: String): String {
        val rq: Queue<Int> = LinkedList()
        val dq: Queue<Int> = LinkedList()
        senate.forEachIndexed { i, c ->
            if (c == 'R') rq.add(i)
            else dq.add(i)
        }

        while (rq.isNotEmpty() && dq.isNotEmpty()) {
            val ri = rq.poll()
            val di = dq.poll()
            if (ri < di) rq.add(ri + senate.length)
            else dq.add(di + senate.length)
        }

        return if (rq.size > dq.size) "Radiant" else "Dire"
    }