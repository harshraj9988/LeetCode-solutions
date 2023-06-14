    fun countNegatives(grid: Array<IntArray>): Int {
        var x = 0
        var y = grid[0].lastIndex
        var count = 0
        while (x < grid.size && y >= 0) {
            while (x < grid.size && grid[x][y] >= 0) x++
            count += (grid.size - x)
            y--
        }
        return count
    }