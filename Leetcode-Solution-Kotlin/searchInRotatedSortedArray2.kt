fun search(nums: IntArray, target: Int): Boolean {
    var start = 0
    var end = nums.lastIndex
    while(start <= end) {
        val mid = start + (end - start) / 2
        if(nums[mid] == target) return true
        if(nums[start] == target) return true
        if(nums[end] == target) return true
        if(nums[mid] > target) {
            if(nums[start] < target) end = mid - 1
            else {

            }
        }
        if(nums[mid] < target) {

        }
    }
    return false
}