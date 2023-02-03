import java.util.*

    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val n = rooms.size
        val visited = BooleanArray(n)
        val queue: Queue<Int> = LinkedList()
        visited[0] = true
        rooms[0].forEach { queue.add(it) }
        while(queue.isNotEmpty()){
            val next = queue.poll()
            visited[next] = true
            rooms[next].forEach { if(!visited[it]) queue.add(it) }
        }
        return visited.reduce{ a,b-> a && b }
    }