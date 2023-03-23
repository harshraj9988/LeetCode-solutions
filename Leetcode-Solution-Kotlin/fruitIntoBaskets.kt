fun totalFruit(fruits: IntArray): Int {
    val map = HashMap<Int, Int>()
    var start = 0
    var end = 0
    var maxi = 0
    val n = fruits.size
    while (start < n && end < n) {
        map[fruits[end]] = (map[fruits[end]] ?: 0) + 1
        while (map.size > 2) {
            map[fruits[start]] = map[fruits[start]]!! - 1
            if (map[fruits[start]] == 0) {
                map.remove(fruits[start])
            }
            start++
        }
        maxi = maxi.coerceAtLeast(end - start + 1)
        end++
    }
    return maxi
}
    