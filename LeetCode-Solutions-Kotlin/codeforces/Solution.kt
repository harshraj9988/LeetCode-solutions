package codeforces

class Solution {
    fun categorizeBox(length: Int, width: Int, height: Int, mass: Int): String {
        val l = length.toLong()
        val w = width.toLong()
        val h = height.toLong()
        val m = mass.toLong()
        val isBulky = (l >= 1e4.toLong() || h >= 1e4.toLong() || w >= 1e4.toLong() || (l * h * w) >= 1e9.toLong())
        val isHeavy = (m >= 100)
        if (isBulky && isHeavy) return "Both"
        if (isBulky && !isHeavy) return "Bulky"
        if (!isBulky && isHeavy) return "Heavy"
        return "Neither"
    }

    class DataStream(value: Int, M: Int) {
        val deque = ArrayDeque<Int>()
        val v =value
        val k = M
        var count = 0
        fun consec(num: Int): Boolean {
            deque.addLast(num)
            if(num != v) count++
            return if(deque.size < k) false
            else if(deque.size == k) count == 0
            else{
                if(deque.first() != v) count--
                deque.removeFirst()
                count==0
            }
        }
    }

}