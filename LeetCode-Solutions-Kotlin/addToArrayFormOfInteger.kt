import java.util.*

    fun addToArrayForm(num: IntArray, k: Int): List<Int> {
        val n = num.size
        val st = Stack<Int>()
        var carry = k
        for (i in n - 1 downTo 0) {
            carry += num[i]
            st.add(carry % 10)
            carry /= 10
        }
        while (carry != 0) {
            st.add(carry % 10)
            carry /= 10
        }
        return st.toList().reversed()
    }