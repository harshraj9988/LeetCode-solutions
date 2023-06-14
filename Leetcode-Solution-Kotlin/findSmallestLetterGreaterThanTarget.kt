    fun nextGreatestLetter(letters: CharArray, target: Char): Char {
        var start = 0
        var end = letters.lastIndex
        var des = 0

        while (start < end) {
            val mid = start + (end - start) / 2
            if (letters[mid] <= target) {
                des = mid
                start = mid + 1
            } else {
                end = mid - 1
            }
        }

        return if (des >= letters.lastIndex) letters[0] else letters[des + 1]
    }