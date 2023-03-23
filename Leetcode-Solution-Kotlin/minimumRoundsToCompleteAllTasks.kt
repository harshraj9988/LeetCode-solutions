    fun minimumRounds(tasks: IntArray): Int {
        return tasks.groupBy { it }.map {
            val freq = it.value.size
            if (freq == 1) return -1
            else if (freq % 3 == 0) freq / 3
            else freq / 3 + 1
        }.sum()
    }

    fun main() {
        val tasks = arrayOf(2, 2, 3, 2, 4, 4, 4, 4, 4).toIntArray()
        minimumRounds(tasks)
    }