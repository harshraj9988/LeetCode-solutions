fun bulbSwitch(n: Int): Int {
    if (n <= 1) {
        return n
    }
    var low = 1
    var high = 31633
    var ans = 0
    while (low <= high) {
        val mid = low + (high - low) / 2
        if (mid * (mid + 2) < n) {
            low = mid + 1
        } else {
            ans = mid
            high = mid - 1
        }
    }
    return ans

}
