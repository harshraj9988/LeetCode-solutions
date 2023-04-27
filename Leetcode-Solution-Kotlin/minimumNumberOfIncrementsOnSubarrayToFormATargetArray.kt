import java.util.*
import kotlin.collections.ArrayList

private fun uniqueSorted(arr: IntArray): ArrayList<Int> {
    val ts = TreeSet<Int>()
    for (num in arr) {
        ts.add(num)
    }
    return ArrayList(ts)
}

private fun countUniqueSections(target: IntArray, uniqueSorted: ArrayList<Int>): HashMap<Int, Int> {
    val hm = HashMap<Int, Int>()
    val hm2 = HashMap<Int, Stack<Pair<Int, Int>>>()
    uniqueSorted.forEach {
        hm[it] = 0
        hm2[it] = Stack()
    }

    val left = IntArray(target.size)
    val right = IntArray(target.size)
    val st = Stack<Int>()

    for (i in target.indices) {
        while (st.isNotEmpty() && target[st.peek()] >= target[i]) {
            st.pop()
        }
        if (st.isEmpty()) {
            left[i] = -1
        } else {
            left[i] = st.peek()
        }
        st.add(i)
    }

    st.clear()

    for (i in target.size - 1 downTo 0) {
        while (st.isNotEmpty() && target[st.peek()] >= target[i]) {
            st.pop()
        }
        if (st.isEmpty()) {
            right[i] = target.size
        } else {
            right[i] = st.peek()
        }
        st.add(i)
    }

    for (i in target.indices) {
        if (hm2[target[i]]!!.isEmpty()) {
            hm2[target[i]]!!.add(Pair(left[i], right[i]))
        } else {
            val pair = hm2[target[i]]!!.peek()
            if (pair.first == left[i] && pair.second == right[i]) continue
            else hm2[target[i]]!!.add(Pair(left[i], right[i]))
        }
    }

    for (key in hm2.keys) {
        print("$key : ")
        for (pair in hm2[key]!!) {
            print("[${pair.first}, ${pair.second}] ")
        }
        println()
    }

    for (key in hm2.keys) {
        hm[key] = hm2[key]!!.size
    }
    return hm
}

fun minNumberOperations(target: IntArray): Int {
    var ans = 0
    var prev = 0
    val us = uniqueSorted(target)
    val cus = countUniqueSections(target, us)

    for (key in us) {
        ans += (key - prev) * cus[key]!!
        prev = key
    }

    return ans
}

fun main() {
    val target = intArrayOf(3, 1, 1, 2)
    println(minNumberOperations(target))
}