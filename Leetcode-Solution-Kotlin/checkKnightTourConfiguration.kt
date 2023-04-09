    fun checkValidGrid(grid: Array<IntArray>): Boolean {
        val n = grid.size
        val nextMoves = listOf(2, 1, 2, -1, -2, 1, -2, -1, 1, 2, -1, 2, 1, -2, -1, -2)
        if(grid[0][0] != 0){
            return false
        }
        var x = 0
        var y = 0
        val finalMove = n*n-1
        var moved = 0

        while(true) {
            var notChanged = true
            for(i in nextMoves.indices step 2){
                val nx = x + nextMoves[i]
                val ny = y + nextMoves[i+1]
                if(nx in 0 until n && ny in 0 until n){
                    if(grid[nx][ny] == moved+1){
                        moved++
                        x = nx
                        y = ny
                        notChanged = false
                        break
                    }
                }
            }

            if(notChanged){
                return moved == finalMove
            }
        }
    }