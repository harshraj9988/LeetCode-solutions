    fun longestSubarray(nums: IntArray): Int {
        val arr = ArrayList<Int>()
        var count = 0
        for(i in nums.indices) {
            if(nums[i] == 0) {
                arr.add(count)
                count = 0
            }
            else{
                count++
            }
        }
        arr.add(count)
        var ans = 0
        for(i in 0 until arr.lastIndex) {
            ans = ans.coerceAtLeast(arr[i] + arr[i+1])
        }
        if(arr.size == 1) return arr[0] - 1
        return ans
    }