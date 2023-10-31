import java.util.*

//    fun minOperations(nums: IntArray, x: Int): Int {
//        val preSum = LongArray(nums.size) { nums[it].toLong() }
//        for(i in 1 until preSum.size) {
//            preSum[i] += preSum[i-1]
//        }
//        var ans = Int.MAX_VALUE
//        var temp = Arrays.binarySearch(preSum, x.toLong())
//        if(temp >= 0) {
//            ans = ans.coerceAtMost(temp + 1)
//        }
//        var found = 0L
//        for(i in preSum.lastIndex downTo 0) {
//            found += nums[i].toLong()
//            if(found == x.toLong()) {
//                ans = ans.coerceAtMost(preSum.size - i)
//                break
//            }
//            val toFind = x.toLong() - found
//            val ind = binarySearch(preSum, 0, i, toFind)
//            if(ind < 0) continue
//            val moves = ind + 1 + preSum.size - i
//            ans = ans.coerceAtMost(moves)
//        }
//        return if(ans == Int.MAX_VALUE) -1 else ans
//    }
//
//    private fun binarySearch(arr: LongArray, start: Int, end: Int, target: Long) : Int {
//        if(start == end) return -1
//        var s = start
//        var e = end
//        var ind = -1
//        var temp = 0
//        while (temp != -1) {
//            temp = Arrays.binarySearch(arr, s, e, target)
//            if(temp >= 0 ) {
//                ind = temp
//                e = temp
//            }
//        }
//        return ind
//    }

fun main() {
    val a = intArrayOf(1, 2, 3, 4, 5, 6)
    println(
        Arrays.binarySearch(a, 0, 5, 6)
    )
}