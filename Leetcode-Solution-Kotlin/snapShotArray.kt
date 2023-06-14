class SnapshotArray(length: Int) {
    val arr = Array<ArrayList<Pair<Int, Int>>>(length) { ArrayList() }
    var snapId = 0

    init {
        repeat(length) {
            arr[it] = ArrayList<Pair<Int, Int>>().also {
                it.add(Pair(0, 0))
            }
        }
    }

    fun set(index: Int, `val`: Int) {
        if (arr[index].isEmpty() || arr[index].last().second != snapId) {
            arr[index].add(Pair(`val`, snapId))
        } else {
            arr[index][arr[index].lastIndex] = Pair(`val`, snapId)
        }
    }

    fun snap(): Int {
        return snapId++
    }

    fun get(index: Int, snap_id: Int): Int {
        val x = arr[index]
        var l = 0
        var r = x.lastIndex
        while (l <= r) {
            val m = l + (r - l) / 2
            if (x[m].second == snap_id) return x[m].first
            else if (x[m].second < snap_id) {
                l = m + 1
            } else {
                r = m - 1
            }
        }
        return x[r].first
    }

}