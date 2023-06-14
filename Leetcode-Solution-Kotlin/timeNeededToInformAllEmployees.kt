    import java.util.*
    import kotlin.collections.ArrayList

    fun numOfMinutes(n: Int, headID: Int, manager: IntArray, informTime: IntArray): Int {
        val adj = ArrayList<ArrayList<Int>>()
        repeat(n) { adj.add(ArrayList()) }

        manager.forEachIndexed { emp, mgr ->
            if (mgr != -1) adj[mgr].add(emp)
        }

        val dp = IntArray(n) { -1 }
        return dfs(adj, headID, informTime, dp)
    }

    private fun dfs(adj: ArrayList<ArrayList<Int>>, manager: Int, informTime: IntArray, dp: IntArray): Int {
        var time = 0
        if (dp[manager] != -1) return dp[manager]
        for (subManager in adj[manager]) {
            time = time.coerceAtLeast(dfs(adj, subManager, informTime, dp))
        }
        dp[manager] = time + informTime[manager]
        return dp[manager]
    }