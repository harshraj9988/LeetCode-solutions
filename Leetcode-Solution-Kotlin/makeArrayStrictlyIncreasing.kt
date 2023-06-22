fun makeArrayIncreasing(arr1: IntArray, arr2: IntArray): Int {
    arr2.sort()
    val x = recursion(arr1, arr2, -1, 0)
    return if(x < 2001) x else -1
}

private val map = HashMap<Pair<Int, Int>, Int>()

private fun recursion(arr1: IntArray, arr2: IntArray, prev: Int, i: Int): Int {
    if (i == arr1.size) return 0
    if(map.containsKey(Pair(i, prev))) return map[Pair(i, prev)]!!
    var cost = 2001

    if (arr1[i] > prev) {
        cost = recursion(arr1, arr2, arr1[i], i + 1)
    }
    val idx = findGreater(arr2, prev)

    if (idx < arr2.size) {
        cost = cost.coerceAtMost(
            1 + recursion(arr1, arr2, arr2[idx], i + 1)
        )
    }
    map[Pair(i, prev)] = cost
    return cost
}

private fun findGreater(arr: IntArray, x: Int): Int {
    var left = 0
    var right = arr.size
    while (left < right) {
        val mid = (left + right) / 2
        if (arr[mid] <= x) {
            left = mid + 1
        } else {
            right = mid
        }
    }
    return left
}