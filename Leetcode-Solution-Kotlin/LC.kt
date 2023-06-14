import java.util.*

class LC {
     private fun check(num: Int, remainingNum: Int, sum: Int) : Boolean {
        if(sum + remainingNum == num) {
            return true
        }
        if(remainingNum == 0) {
            return false
        }
        var ans = false
        var add = 0
        var temp = remainingNum
         var multp = 1
        while(temp>0) {
            add += (temp % 10) * multp
            multp *= 10
            temp /= 10
            ans = ans || check(num, temp, sum+add)
        }

        return ans
    }

    fun punishmentNumber(n: Int): Int {
        var ans = 0
        for(i in 1..n) {
            val x = i*i
            if(check(i, x, 0)) {
                ans += x
            }
        }
        return ans
    }

    fun minLength(s: String): Int {
        val stack = Stack<Char>()
        s.forEach {
            if (!stack.isEmpty() && ((stack.peek() == 'A' && it == 'B') || ( stack.peek() == 'C' && it == 'D' ))) {
                stack.pop()
            } else {
                stack.add(it)
            }
        }
        return stack.size
    }

    fun makeSmallestPalindrome(s: String): String {
        val newS = s.toCharArray()
        var first = 0
        var last = newS.lastIndex
        while(first < last) {
            if(newS[first] != newS[last]) {
                if(newS[first] > newS[last]) {
                    newS[first] = newS[last]
                }else{
                    newS[last] = newS[first]
                }
            }
            first++
            last--
        }
        return String(newS)
    }

    private var pathArray = Array<IntArray>(0){ IntArray(0) }
    private var sum = 0
    private var x = 0


    fun modifiedGraphEdges(n: Int, edges: Array<IntArray>, source: Int, destination: Int, target: Int): Array<IntArray> {
        val adj = createAdjList(n, edges)
        val vis = Array(n) { false }

        dfs(adj, source, destination, target, Stack<IntArray>(), 0, 0, vis)

        if(x == 0 && sum != target) {
            return emptyArray()
        }
        if(x != 0){
            sum = target - sum
            pathArray.forEach {
                if (x> 1 && it[2] < 0) {
                    it[2] = 1
                    sum--
                    x--
                }else if(x == 1 && it[2] < 0){
                    it[2] = sum
                    x--
                }
            }
        }

        val arr = Array(n){IntArray(n){-2} }
        edges.forEach {
            arr[it[0]][it[1]] = it[2]
        }

        pathArray.forEach {
            arr[it[0]][it[1]] = it[2]
            arr[it[1]][it[0]] = it[2]
        }

        for(i in edges.indices) {
            edges[i][2] = arr[edges[i][0]][edges[i][1]]
        }


        return edges
    }

    private fun createAdjList(n: Int, edges: Array<IntArray>) : ArrayList<ArrayList<Pair<Int, Int>>> {
        val ans = ArrayList<ArrayList<Pair<Int, Int>>>()
        repeat(n) {
            ans.add(ArrayList())
        }
        edges.forEach{
            ans[it[0]].add(Pair(it[1], it[2]))
            ans[it[1]].add(Pair(it[0], it[2]))
        }
        return ans
    }

    private fun dfs(
        adj: ArrayList<ArrayList<Pair<Int, Int>>>,
        node: Int,
        destination: Int,
        target: Int,
        path: Stack<IntArray>,
        sum: Int,
        x: Int,
        vis: Array<Boolean>
    ) {
        if(node == destination) {
            if(sum + x <= target) {
                pathArray = Array(path.size) { IntArray(3) }
                path.forEachIndexed { i, z ->
                    pathArray[i] = path[i]
                }
                this.sum = sum
                this.x = x
            }
        }
        vis[node] = true
        for(next in adj[node]) {
            if(vis[next.first]) continue
            path.add(intArrayOf(node, next.first, next.second))
            var a = next.second
            var b = 0
            if(a == -1) {
                a = 0
                b = 1
            }
            dfs(adj, next.first, destination, target, path, sum+a, x+b, vis )
            path.pop()
        }
        vis[node]=false    }
}

fun main() {
    val lc = LC()

}
