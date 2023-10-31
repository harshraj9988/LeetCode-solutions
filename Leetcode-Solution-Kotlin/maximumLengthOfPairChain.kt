import java.util.*

//    fun findLongestChain(pairs: Array<IntArray>): Int {
//        val routes = HashMap<Int, ArrayList<Int>>()
//        var maxDepth = 0
//        var cachedDepth = IntArray(pairs.size) { -1 }
//
//        for (i in pairs.indices) {
//            for (j in pairs.indices) {
//                if (routes[i] == null) routes[i] = ArrayList()
//                if (i == j) continue
//                if (pairs[i][1] >= pairs[j][0]) continue
//                routes[i]!!.add(j)
//            }
//        }
//
//        for (i in pairs.indices) {
//            maxDepth = maxDepth.coerceAtLeast(findDepth(routes, BooleanArray(pairs.size), i, cachedDepth))
//        }
//        return maxDepth
//    }
//
//    private fun findDepth(routes: HashMap<Int, ArrayList<Int>>, vis: BooleanArray, curr: Int, cachedDepth: IntArray): Int {
//        if (cachedDepth[curr] != -1) return cachedDepth[curr]
//        var depth = 0
//        vis[curr] = true
//        for (dest in routes[curr]!!) {
//            if (vis[dest]) continue
//            depth = depth.coerceAtLeast(findDepth(routes, vis, dest, cachedDepth))
//        }
//        vis[curr] = false
//        cachedDepth[curr] = depth + 1
//        return cachedDepth[curr]
//    }

    fun findLongestChain(pairs: Array<IntArray>): Int {
        var maxDepth = 0
        Arrays.sort(pairs) { a, b -> a[1].compareTo(b[1]) }
        var curr = Int.MIN_VALUE
        pairs.forEach {
            if (curr < it[0]) {
                curr = it[1]
                maxDepth++
            }
        }
        return maxDepth
    }