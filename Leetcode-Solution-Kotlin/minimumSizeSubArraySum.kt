    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var sum = 0
        var ans = nums.size + 1
        var i = 0
        var j = 0
        while(i< nums.size && j < nums.size) {
            sum += nums[j]
            while(i < nums.size && sum >= target) {
                ans = ans.coerceAtMost(j-i+1)
                sum -= nums[i++]
            }
            j++
        }
        return if(ans > nums.size) 0 else ans
    }