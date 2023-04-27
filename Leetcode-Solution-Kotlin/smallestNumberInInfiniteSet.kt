class SmallestInfiniteSet() {
    val nums = Array(1001){ 0 }

    fun popSmallest(): Int {
        for(i in 1..1000) {
            if(nums[i] == 0){
                nums[i] = -1
                return i
            }
        }
        return -1
    }

    fun addBack(num: Int) {
        nums[num] = 0
    }

}
