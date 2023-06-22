import java.util.*
import kotlin.collections.HashMap

class LC {
    fun distanceTraveled(mainTank: Int, additionalTank: Int): Int {
        var fuel = mainTank
        var extraFuel = additionalTank
        var totalKms = 0
        while (fuel >= 5) {
            totalKms += 50
            fuel -= 5
            if (extraFuel > 0) {
                fuel++
                extraFuel--
            }
        }
        totalKms += fuel * 10
        return totalKms
    }

    fun findValueOfPartition(nums: IntArray): Int {
        nums.sort()
        var mini = Int.MAX_VALUE
        for (i in 0 until nums.lastIndex) {
            mini = mini.coerceAtMost(nums[i + 1] - nums[i])
        }
        return mini
    }

    private lateinit var map: HashMap<Int, ArrayList<Int>>
    private lateinit var dp : Array<LongArray>
    fun specialPerm(nums: IntArray): Int {
        val done = BooleanArray(nums.size) { false }
        map = HashMap()
        map[-1] = ArrayList()
        for (i in nums.indices) {
            map[-1]!!.add(i)
            map[i] = ArrayList()
        }
        for (i in nums.indices) {
            for (j in nums.indices) {
                if (i == j) continue
                if (nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0) {
                    map[i]!!.add(j)
                    map[j]!!.add(i)
                }
            }
        }

        dp = Array(nums.size+1) { LongArray(nums.size + 2) {-1L} }

        for(i in map.keys) {
            println("$i ${map[i]!!.toString()}")
        }

        return rec(nums, done, 0).toInt()
    }
    private val mod = 1e9.toLong() + 7L
    private fun rec(nums: IntArray, done: BooleanArray, temp: Int, prev: Int = -1): Long {
        if (temp == nums.size) {
            return 1
        }
        if(dp[temp][prev+1] != -1L) return dp[temp][prev+1]
        var count = 0L
        for (i in map[prev]!!) {
            if (!done[i]) {
                done[i] = true
                count = (count + (rec(nums, done, temp + 1, i)%mod))%mod
                done[i] = false
            }
        }
        dp[temp][prev+1] = count
        return count
    }

    fun paintWalls(cost: IntArray, time: IntArray): Int {
        return solve(cost, time, 0, cost.size, 0)
    }

    private fun solve(cost: IntArray, time: IntArray, i: Int, n: Int, busy: Int): Int {
        if(i == n) return 0
        if(busy > 0) {
            return solve(cost, time, i+1, n,busy-1)
        }else{
            return cost[i] + solve(cost, time, i+1, n, time[i])
        }
    }
}

fun main() {
    val lc = LC()

}
