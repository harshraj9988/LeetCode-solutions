private val cache = HashMap<Int, Int>()

class MountainArray(
    private val arr: IntArray
) {
    var count = 0
    fun length(): Int {
        count++
        return arr.size
    }

    fun get(ind: Int): Int {
        count++
        return arr[ind]
    }
}

fun findInMountainArray(target: Int, mountainArr: MountainArray): Int {
    val length = mountainArr.length()
    return binarySearch(target, mountainArr, 0, length - 1, length - 1)
}

private fun binarySearch(target: Int, mountain: MountainArray, start: Int, end: Int, last: Int): Int {
    if (start > end) return -1
    val mid = start + (end - start) / 2
    val curr = mountain.at(mid)
    val prev = if (mid == 0) curr else mountain.at(mid - 1)
    val next = if (mid == last) curr else mountain.at(mid + 1)
    if(prev < curr && curr > next) {
        if(target > curr) return -1
        val onLeft = binarySearch(target, mountain, start, mid - 1, last)
        if(onLeft != -1) return onLeft
        if(curr == target) return mid
        return binarySearch(target, mountain, mid+1, end, last)
    }
    if(prev <= curr && curr <= next) {
        if(curr >= target){
            val onLeft = if(prev == curr) -1 else binarySearch(target, mountain, start, mid-1, last)
            if(onLeft == -1 && curr == target) return mid
            return onLeft
        }
        if(curr < target) return if(curr == next) -1 else binarySearch(target, mountain, mid+1, end, last)
    }
    if(prev >= curr && curr >= next) {
        if(curr <= target){
            val onLeft = if(prev == curr) -1 else binarySearch(target, mountain, start, mid-1, last)
            if(onLeft == -1 && curr == target) return mid
            return onLeft
        }
        if(curr > target) return if(next == curr) -1 else binarySearch(target, mountain, mid+1, end, last)
    }

    return -1
}

private fun MountainArray.at(ind: Int): Int {
    if (ind !in cache) cache[ind] = this.get(ind)
    return cache[ind]!!
}


fun main() {
    val arr = intArrayOf(3,5,3,2,0)
    val ma = MountainArray(arr)
    val target = 3
    println(findInMountainArray(target, ma))
    println(ma.count)
}