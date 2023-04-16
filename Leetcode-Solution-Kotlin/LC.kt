class LC {
    fun addMinimum(word: String): Int {
        val n = word.length
        var lastChar = 'c'
        var index = 0
        var ans = 0
        while (index < n) {
            when (lastChar) {
                'c' -> {
                    if (word[index] == 'a') {
                        index++
                    } else {
                        ans++
                    }
                    lastChar = 'a'
                }
                'a' -> {
                    if (word[index] == 'b') {
                        index++
                    } else {
                        ans++
                    }
                    lastChar = 'b'
                }
                else -> {
                    if (word[index] == 'c') {
                        index++
                    } else {
                        ans++
                    }
                    lastChar = 'c'
                }
            }
        }


        if (lastChar == 'a') ans += 2
        else if (lastChar == 'b') ans++

        return ans
    }

    fun maxDivScore(nums: IntArray, divisors: IntArray): Int {
        var divisibles = 0
        var answer = Int.MAX_VALUE
        for(div in divisors){
            var temporaryCount = 0
            for(num in nums) {
                if(num%div == 0) {
                    temporaryCount++
                }
            }
            if(temporaryCount > divisibles){
                divisibles = temporaryCount
                answer = div
            }else if(temporaryCount == divisibles) {
                answer = answer.coerceAtMost(div)
            }
        }
        return answer
    }

    fun rowAndMaximumOnes(mat: Array<IntArray>): IntArray {
        val ans = IntArray(2)
        for(i in mat.indices) {
            val temp = mat[i].count { x -> x == 1 }
            if(temp > ans[1]){
                ans[0] = i
                ans[1] = temp
            }
        }
        return ans
    }


    private lateinit var touched: Array<Boolean>

    private fun dfs(adj: ArrayList<ArrayList<Int>>, vis: Array<Boolean>, price: IntArray, node: Int, target: Int): Int {
        touched[node] = true
        if(node == target) {
            return price[target]
        }
        var temp = 1e8.toInt()

        for(next in adj[node]) {
            if(!vis[next]){
                vis[next] = true
                temp = temp.coerceAtMost( price[node] + dfs(adj, vis, price, next, target) )
            }
        }

        return temp
    }

    fun minimumTotalPrice(n: Int, edges: Array<IntArray>, price: IntArray, trips: Array<IntArray>): Int {
        touched = Array(n) { false }
        val adj = ArrayList<ArrayList<Int>>()
        repeat(n){
            adj.add(ArrayList())
        }
        for(edge in edges) {
            adj[edge[0]].add(edge[1])
            adj[edge[1]].add(edge[0])
        }
        var ans = 0
        for(trip in trips) {
            val vis = Array(n) { false }
            vis[trip[0]] = true
            ans += (dfs(adj, vis, price, trip[0], trip[1]))
        }



        for(trip in trips) {
            val vis = Array(n) { false }
            vis[trip[0]] = true
            ans += (dfs(adj, vis, price, trip[0], trip[1]))
        }
        return ans
    }
}

fun main() {
    val lc = LC()
    var a = "abc"
    println(lc.addMinimum(a))

}
