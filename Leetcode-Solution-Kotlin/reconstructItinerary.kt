    import java.util.*
    import kotlin.collections.ArrayList
    import kotlin.collections.HashMap

    fun findItinerary(tickets: List<List<String>>): List<String> {
        val routes = generateRoutes(tickets)
        val route = Stack<String>()
        route.add("JFK")
        dfs(routes, "JFK", route, tickets.size)
        return route
    }

    private fun dfs(
        routes: HashMap<String, ArrayList<String>>,
        curr: String,
        route: Stack<String>,
        remTickets: Int
    ): Int {
        if (curr !in routes) return remTickets
        val list = routes[curr]!!
        for (i in 0 until list.size) {
            val next = list[i]
            list.removeAt(i)
            route.add(next)
            val newRemTickets = dfs(routes, next, route, remTickets - 1)
            if (newRemTickets == 0) return 0
            list.add(i, next)
            route.pop()
        }
        return remTickets
    }

    private fun generateRoutes(tickets: List<List<String>>): HashMap<String, ArrayList<String>> {
        val map = HashMap<String, ArrayList<String>>()
        tickets.forEach {
            val list = map[it[0]] ?: ArrayList()
            list.add(it[1])
            map[it[0]] = list
        }
        map.forEach {
            Collections.sort(it.value)
        }
        return map
    }

