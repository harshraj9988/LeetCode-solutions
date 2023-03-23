import java.util.*


fun minFlipsMonoIncr(s: String): Int {
    var ans = s.count { it == '1' }
    val zeros = s.length - ans
    ans = ans.coerceAtMost(zeros)
    var leftOnes = 0
    s.forEachIndexed { i, it ->
        if (it == '1') leftOnes++
        ans = ans.coerceAtMost(2 * leftOnes + zeros - i - 1)
    }
    return ans
}

/*
 fun minFlipsMonoIncr(s: String): Int {
        val ones = s.count { it == '1' }
        val zeros = s.length - ones
        var ans = ones.coerceAtMost(zeros)
        var leftOnes = 0
        var rightOnes = ones
        var leftZeros = 0
        var rightZeros = zeros
        s.forEachIndexed { i, it ->
            if (it == '1') leftOnes++
            rightOnes = ones - leftOnes
            leftZeros = (i + 1) - leftOnes
            rightZeros = zeros - leftZeros
            ans = ans.coerceAtMost((leftOnes + rightZeros))
            ans = ans.coerceAtMost((leftZeros + rightZeros))
        }
        return ans
    }
*/

fun findRemainingBalls(direction: Array<Int>, strength: Array<Int>): Array<Int> {
    val st = Stack<Int>()
    strength.forEachIndexed { i, str ->
        if (direction[i] == 1 || st.isEmpty()) {
            st.push(i)
        } else {
            while (
                st.isNotEmpty() &&
                direction[st.peek()] == 1 &&
                str > strength[st.peek()]
            ) {
                st.pop()
            }
            if (st.isEmpty() || direction[st.peek()] == -1) {
                st.push(i)
            } else if (strength[st.peek()] == str) {
                st.pop()
            }
        }
    }
    return st.toArray(Array(st.size) { 0 })
}

fun main() {
    val direction = arrayOf(1, -1, 1)
    val strength = arrayOf(5, 3, 1)
    println(
        findRemainingBalls(direction, strength).contentToString()
    )
}





