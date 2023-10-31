    fun singleNumber(nums: IntArray): Int {
        var ones = 0
        var twos = 0
        for(x in nums) {
            ones = (ones xor x) and (twos.inv())
            twos = (twos xor x) and (ones.inv())
        }
        return ones
    }