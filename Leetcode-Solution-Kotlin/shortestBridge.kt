    fun shortestBridge(grid: Array<IntArray>): Int {
        for (a in grid.indices) {
            for (b in grid.indices) {
                if (grid[a][b] == 1) {
                    paint(grid, a, b)
                    var color = 2
                    while (color <= 3000) {
                        for (i in grid.indices) {
                            for (j in grid.indices) {
                                if (grid[i][j] == color && (expand(grid, i - 1, j, color) || expand(grid,i + 1,j,color) || expand(grid, i, j - 1, color) || expand(grid, i, j + 1, color))
                                ) {
                                    return color - 2
                                }
                            }
                        }
                        color++
                    }
                }
            }
        }
        return -1
    }

    private fun paint(grid: Array<IntArray>, x: Int, y: Int) {
        if (x !in grid.indices || y !in grid.indices || grid[x][y] == 0 || grid[x][y] != 1) {
            return
        }
        grid[x][y] = 2
        paint(grid, x + 1, y)
        paint(grid, x - 1, y)
        paint(grid, x, y + 1)
        paint(grid, x, y - 1)
    }

    private fun expand(grid: Array<IntArray>, x: Int, y: Int, color: Int): Boolean {
        if (x !in grid.indices || y !in grid.indices) return false
        grid[x][y] = if (grid[x][y] == 0) color + 1 else grid[x][y]
        return grid[x][y] == 1
    }
