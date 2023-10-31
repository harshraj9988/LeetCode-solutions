    import java.util.*

    fun maximumScore(nums: IntArray, k: Int): Int {
        val n = nums.size
        val left = IntArray(n) { -1 }
        val right = IntArray(n) { n }
        var ans = 0
        val st = Stack<Int>()
        for (i in nums.indices) {
            while (st.isNotEmpty() && nums[st.peek()] > nums[i]) {
                right[st.pop()] = i
            }
            st.push(i)
        }
        st.clear()
        for(i in nums.lastIndex downTo 0 ) {
            while(st.isNotEmpty() && nums[st.peek()] > nums[i]) {
                left[st.pop()] = i
            }
            st.push(i)
        }
        for(i in nums.indices) {
            if(left[i] < k && right[i] > k) {
                ans = ans.coerceAtLeast(
                    nums[i] * (right[i] - left[i] - 1)
                )
            }
        }
        return ans
    }
