import java.util.*

class Solution {
    fun makeGood(s: String): String {
        val st = Stack<Char>()
        val c = s.toCharArray()
        c.forEach {
            if (st.isNotEmpty() &&
                (it - 'a' == st.peek() - 'A' || it - 'A' == st.peek() - 'a')
            ) {
                st.pop()
            } else {
                st.push(it)
            }
        }
        val sb = StringBuilder()
        st.forEach { sb.append(it) }
        return sb.toString()
    }
}