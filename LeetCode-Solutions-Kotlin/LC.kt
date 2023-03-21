import java.util.*

class LC {
    fun findScore(nums: IntArray): Long {
        val marking = ArrayList<Pair<Int, Int>>()
        val visited = Array(nums.size) { false }
        var ans = 0L

        nums.forEachIndexed { index, i ->
            marking.add(Pair(i, index))
        }
        marking.sortWith(Comparator { a, b ->
            if (a.first == b.first) {
                a.second.compareTo(b.second)
            } else {
                a.first.compareTo(b.first)
            }
        })

        for (i in marking.indices) {
            if (visited[marking[i].second]) continue
            else {
                val temp = marking[i].second
                visited[temp] = true
                ans += nums[temp]
                if (temp - 1 >= 0) visited[temp - 1] = true
                if (temp + 1 < nums.size) visited[temp + 1] = true
            }
        }
        return ans
    }

    fun maximizeGreatness(nums: IntArray): Int {
        Arrays.sort(nums)
        var first = 0
        var second = 0
        val n = nums.size
        while (second < n) {
            if (nums[first] == nums[second]) second++
            else {
                first++
                second++
            }
        }
        return first
    }

    fun distMoney(money: Int, children: Int): Int {
        var remMoney = money - children
        var kidsMoney = Array(children) { 1 }
        if (remMoney < 0) return -1
        for (i in 0 until children) {
            if (i == children - 1) kidsMoney[i] += remMoney
            else if (remMoney >= 7) {
                kidsMoney[i] += 7
                remMoney -= 7
            } else {
                kidsMoney[i] += remMoney
                remMoney = 0
                break
            }
        }
        for (i in 0 until children) {
            return if (kidsMoney[i] == 8) continue
            else if (kidsMoney[i] == 4) {
                if (i == children - 1) {
                    i - 1
                } else {
                    i
                }
            } else {
                i
            }
        }
        return kidsMoney.size
    }

    fun repairCars(rr: IntArray, cars: Int): Long {
        Arrays.sort(rr)
        val ranks = rr.map { it.toLong() }
        val n = ranks.size
        val mul = Array(n) { (cars / n).toLong() }
        mul[n - 1] += (cars % n).toLong()
        val time = LongArray(n)
        for (i in time.indices) {
            time[i] = ranks[i]* mul[i] * mul[i]
        }
        var start = 0
        var end = n - 1
        while (start < end) {
            val startTime = ranks[start] * (mul[start] + 1) * (mul[start] + 1)
            val endTime = ranks[end] * (mul[end] - 1) * (mul[end] - 1)
            if (Math.max(startTime, endTime) < Math.max(time[start], time[end])) {
                time[start] = startTime
                time[end] = endTime
                mul[start]++
                mul[end]--
            } else {
                end -= 1
            }
        }
        var solve = 0L
        for (x in time) solve = Math.max(solve, x)
        return solve
    }
}

fun main() {
    val lc = LC()
}