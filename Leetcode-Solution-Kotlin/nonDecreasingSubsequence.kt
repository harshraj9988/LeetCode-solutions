import java.util.stream.Collectors

fun findSubsequences(nums: IntArray): List<List<Int>> {
        var ans = ArrayList<ArrayList<Int>>()
        val st = ArrayList<Int>()
        recursion(nums, nums.size, 0, ans, st)
        ans = ans.stream().distinct().collect(Collectors.toList()) as ArrayList<ArrayList<Int>>
        return ans
    }

    private fun recursion(nums: IntArray, n: Int, i: Int, ans: ArrayList<ArrayList<Int>>, st: ArrayList<Int>) {
        if (i == n) {
            return
        }

        if (st.size > 0 && st.last() > nums[i]) {
            recursion(nums, n, i + 1, ans, st)
            return
        }

        st.add(nums[i]);
        if (st.size >= 2)
            ans.add(ArrayList(st))
        recursion(nums, n, i + 1, ans, st)

        st.removeAt(st.size-1)
        recursion(nums, n, i + 1, ans, st)
    }