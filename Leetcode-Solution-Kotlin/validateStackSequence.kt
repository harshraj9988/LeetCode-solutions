    import java.util.*

    fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
        val st = Stack<Int>()
        val n = pushed.size
        var p = 0
        for(num in pushed){
            st.add(num)
            while(st.isNotEmpty() && p<n && st.peek() == popped[p]){
                st.pop()
                ++p
            }
        }
        return st.isEmpty()
    }