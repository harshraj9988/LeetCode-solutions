    import java.util.*

    fun latestDayToCross(row: Int, col: Int, cells: Array<IntArray>): Int {

        var start = 0
        var end = cells.size
        var ans = 0

        while (start <= end) {
            val mid = start + (end - start) / 2
            if (canWalk(row, col, mid, cells)) {
                ans = mid
                start = mid + 1
            } else {
                end = mid - 1
            }
        }

        return ans
    }

    private fun canWalk(row: Int, col: Int, mid: Int, cells: Array<IntArray>): Boolean {
        if (mid == 0) return true
        val grid = Array(row) { IntArray(col) { 0 } }
        for (i in 0 until mid) {
            val it = cells[i]
            grid[it[0] - 1][it[1] - 1] = 1
        }
        val q: Queue<Pair<Int, Int>> = LinkedList()
        for (i in grid[0].indices) {
            if (grid[0][i] == 0) {
                q.add(Pair(0, i))
            }
        }
        val moves = intArrayOf(-1, 0, 1, 0, -1)
        while (q.isNotEmpty()) {
            val cell = q.poll()
            if (cell.first == grid.lastIndex) return true
            grid[cell.first][cell.second] = 1
            for (i in 0 until 4) {
                val nx = cell.first + moves[i]
                val ny = cell.second + moves[i + 1]
                if (nx in grid.indices && ny in grid[0].indices && grid[nx][ny] == 0) {
                    q.add(Pair(nx, ny))
                }
            }
        }
        return false
    }

