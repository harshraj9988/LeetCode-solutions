    fun canMakeArithmeticProgression(arr: IntArray): Boolean {
        arr.sort()
        for (i in 1 until arr.lastIndex) {
            if (arr[i] - arr[i - 1] != arr[i + 1] - arr[i]) return false
        }
        return true
    }