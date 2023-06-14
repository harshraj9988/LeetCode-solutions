import jdk.internal.org.jline.utils.Colors.s

    fun summaryRanges(nums: IntArray): List<String> {
        val ans = ArrayList<String>()
        var i = 0
        var j = 0
        for(j in 0 until nums.lastIndex) {
            if(nums[j] + 1 != nums[j+1]) {
                ans.add("${nums[i]}->${nums[j]}")
                i = j+1
            }
        }
        ans.add("${nums[i]}->${nums[j]}")
        return ans
    }