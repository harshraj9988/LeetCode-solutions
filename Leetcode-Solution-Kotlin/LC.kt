import java.util.*
import kotlin.collections.ArrayList

class LC {

    fun countBeautifulPairs(nums: IntArray): Int {
        var ans = 0
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                var x = nums[i]
                while (x >= 10) x /= 10
                if (isCoPrime(Math.max(x, nums[j] % 10), Math.min(x, nums[j] % 10)) == 1) {
                    ++ans
                }
            }
        }
        return ans
    }

    private fun isCoPrime(x: Int, y: Int): Int {
        if (y == 0) return x
        return isCoPrime(y, x % y)
    }

    fun numberOfGoodSubarraySplits(nums: IntArray): Int {
        var subLengthOf0s = 0L
        var foundOne = false
        val subLengths = ArrayList<Long>()

        var ways = 1L
        val mod = 1e9.toLong() + 7L

        for (i in nums.lastIndex downTo 0) {
            if (nums[i] == 1) foundOne = true
            if (foundOne) {
                if (nums[i] == 0) {
                    subLengthOf0s++
                } else {
                    if (subLengthOf0s > 0L) subLengths.add(subLengthOf0s + 1)
                    subLengthOf0s = 0
                }
            }
        }

        for (i in subLengths) {
            ways = (ways * i) % mod
        }

        return if (foundOne) ways.toInt() else 0
    }

    private class DataOfRobots(val pos: Int, val heal: Int, val dir: Char, val i: Int)

    fun survivedRobotsHealths(positions: IntArray, healths: IntArray, directions: String): List<Int> {
        val dataOfRobots = Array(positions.size) { DataOfRobots(0, 0, 'a', 0) }
        val requiredList = ArrayList<DataOfRobots>()

        for (i in positions.indices) {
            dataOfRobots[i] = DataOfRobots(positions[i], healths[i], directions[i], i)
        }
        Arrays.sort(dataOfRobots) { a, b ->
            a.pos.compareTo(b.pos)
        }
        val stackOfData = Stack<DataOfRobots>()
        for (x in dataOfRobots) {
            if (stackOfData.isEmpty()) stackOfData.add(x)
            else {
                if (stackOfData.peek().dir == 'R' && x.dir == 'L') {
                    var z = x
                    while (stackOfData.isNotEmpty() && stackOfData.peek().dir == 'R' && stackOfData.peek().heal < z.heal) {
                        z = DataOfRobots(z.pos, z.heal - 1, z.dir, z.i)
                        stackOfData.pop()
                    }
                    if (stackOfData.isEmpty() || stackOfData.peek().dir == 'L') stackOfData.add(z)
                    else if (stackOfData.peek().heal > z.heal) {
                        val y = stackOfData.pop()
                        stackOfData.add(DataOfRobots(y.pos, y.heal - 1, y.dir, y.i))
                    } else if (stackOfData.peek().heal == z.heal) {
                        stackOfData.pop()
                    }
                } else {
                    stackOfData.add(x)
                }
            }
        }
        stackOfData.forEach {
            requiredList.add(it)
        }
        Collections.sort(requiredList) { a, b ->
            a.i.compareTo(b.i)
        }
        val ans = requiredList.map { it.heal }
        return ans as ArrayList<Int>
    }
}

    fun main() {
        val lc = LC()
        val nums = intArrayOf(0, 1, 0, 0, 1)
        println(lc.numberOfGoodSubarraySplits(nums))
    }

