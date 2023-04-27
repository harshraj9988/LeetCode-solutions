import java.util.*

    fun canSeePersonsCount(heights: IntArray): IntArray {
        val st = Stack<Int>()
        val n = heights.size
        val ans = IntArray(n)
        for(i in n-1 downTo 0) {
            var lastBig = 0
            var count = 0
            while(st.isNotEmpty() && st.peek() < heights[i] ){
                if(st.peek() > lastBig) {
                    lastBig = st.last()
                    count++
                }
                st.pop()
            }
            if(st.isNotEmpty()) {
                count++
            }
            st.add(heights[i])
            ans[i] = count
        }
        return ans
    }