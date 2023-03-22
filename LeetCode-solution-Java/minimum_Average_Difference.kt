class Solution {
    fun minimumAverageDifference(nums: IntArray): Int {
        val n = nums.size
        val prefixSum = LongArray(n)
        var minAvgDiff = Long.MAX_VALUE
        var minAvgDiffInd = 0
        var temp = 0L
        prefixSum[0] = nums[0].toLong()
        for(i in 1 until n) {
            prefixSum[i] = nums[i].toLong() + prefixSum[i-1].toLong()
        }
        for(i in 0 until n-1) {
            temp = Math.abs(prefixSum[i]/(i+1) - (prefixSum[n-1]-prefixSum[i])/(n-i-1))
            if(temp < minAvgDiff){
                minAvgDiff = temp
                minAvgDiffInd = i
            }
        }
        temp = Math.abs(prefixSum[n-1]/n)
        if(temp<minAvgDiff){
            minAvgDiffInd = n-1
        }
        return minAvgDiffInd
    }
}