import java.util.LinkedList
import java.util.Queue

    fun maxDistance(grid: Array<IntArray>): Int {
        val n = grid.size
        var countZeros = 0
        var steps = 0
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (grid[i][j] == 1) {
                    queue.add(Pair(i, j))
                } else {
                    countZeros++
                }
            }
        }

        val del = arrayOf(-1, 0, 1, 0, -1)

        while (countZeros > 0) {
            var x = queue.size
            steps++
            while (x-- > 0) {
                val curr = queue.poll()
                for (i in 0 until 4) {
                    val nx = curr.first + del[i]
                    val ny = curr.second + del[i + 1]
                    if (nx in 0 until n && ny in 0 until n && grid[nx][ny] == 0) {
                        grid[nx][ny] = 1
                        queue.add(Pair(nx, ny))
                        countZeros--
                    }
                }
            }

        }
        return steps
    }

