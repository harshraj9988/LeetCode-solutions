    import java.util.*

    fun asteroidCollision(asteroids: IntArray): IntArray {
        val st = Stack<Int>()
        for (a in asteroids) {
            if (st.isEmpty() || (st.peek() < 0 && a < 0) || (st.peek() >= 0 && a >= 0) || a >= 0) {
                st.add(a)
            } else {
                var x = a
                while (st.isNotEmpty() && st.peek() >= 0 && x < 0) {
                    val y = st.pop()
                    if (Math.abs(x) == Math.abs(y)) {
                        x = 1001
                        break
                    }
                    if (Math.abs(x) < Math.abs(y)) x = y
                }
                if (x != 1001) st.add(x)
            }
        }
        val ans = IntArray(st.size)
        st.forEachIndexed { i, a -> ans[i] = a }
        return ans
    }