import java.util.*
import kotlin.collections.HashMap

class LC {
    fun lastVisitedIntegers(words: List<String>): List<Int> {
        val ans = ArrayList<Int>()
        val ints = ArrayList<Int>()
        var last = -1
        for (word in words) {
            if (word != "prev") {
                last = -1
                ints.add(getInt(word))
                continue
            }
            last++
            val prev = ints.lastIndex - last
            if (prev < 0) ans.add(-1)
            else ans.add(ints[prev])
        }
        return ans
    }

    private fun getInt(str: String): Int {
        var x = 0
        for (i in str.indices) {
            x = x * 10 + (str[i] - '0')
        }
        return x
    }

    fun getWordsInLongestSubsequence(
        n: Int,
        words: Array<String>,
        groups: IntArray
    ): List<String> {
        val zeros = formSubseq( groups, words, n, 1)
        val ones = formSubseq( groups, words, n, 0)


        if(zeros.size > ones.size) return zeros
        return ones
    }

    private fun formSubseq( groups: IntArray, words: Array<String>, n: Int, last: Int): ArrayList<String> {
        val arr = ArrayList<String>()
        var prev = last
        for(i in 0 until n) {
            if(groups[i]!=prev) {
                prev = groups[i]
                arr.add(words[i])
            }
        }
        return arr
    }

    fun getWordsInLongestSubsequence_(
        n: Int,
        words: Array<String>,
        groups: IntArray
    ): List<String> {

        var a = ArrayList<String>()
        var m = 0
        for(i in 0 .. n) {
            val x = formHamming(formSubseq(groups, words, n, i))
            if(x.size > m) {
                m = x.size
                a = x
            }
        }
        return a
    }

    private fun formHamming(arr: ArrayList<String>) : ArrayList<String> {
        val hm = ArrayList<String>()
        val adj = HashMap<Int, ArrayList<Int>>()
        for(i in arr.indices) {
            adj[i] = ArrayList()
            for(j in i+1 until arr.size) {
                if(feasible(arr[i], arr[j])) {
                    adj[i]!!.add(j)
                }
            }
        }
        val pathDist = Array(arr.size) { intArrayOf(1, it) }
        var mm = 0
        var l = -1
        for(i in arr.lastIndex downTo 0) {
            var max = 0
            var prev = i
            for(j in adj[i]!!) {
                if(pathDist[j][0] >= max) {
                    max = pathDist[j][0]
                    prev = pathDist[j][1]
                }
            }
            pathDist[i][0] += max
            pathDist[i][1] = prev
            if(pathDist[i][0] >= mm) {
                mm = max
                l = i
            }
        }
        while(pathDist[l][1] != l) {
            hm.add( arr[l] )
            l = pathDist[l][1]
        }
        return hm
    }


    private fun feasible(a: String, b: String): Boolean {
        if(a.length != b.length) return false
        var count = 0
        for(i in a.indices) {
            if(a[i] != b[i]) count++
        }
        return count == 1
    }
}

fun main() {
}

