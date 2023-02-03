    fun minFlips(mat: Array<IntArray>): Int {
        val temp = dfs(mat, 0, 0, mat.size, mat[0].size, 0)
        return if (temp == Int.MAX_VALUE) -1 else temp
    }

    private fun dfs(mat: Array<IntArray>, i: Int, j: Int, m: Int, n: Int, steps: Int): Int {
        if (i == m) return if (allZeros(mat)) steps else Int.MAX_VALUE
        val del = arrayOf(-1, 0, 1, 0, -1)
        var ni = i
        var nj = j + 1
        if (nj == n) {
            ni++
            nj = 0
        }
        val notFlip = dfs(mat, ni, nj, m, n, steps)
        flipThem(i, del, j, m, n, mat)
        val flip = dfs(mat, ni, nj, m, n, steps + 1)
        flipThem(i, del, j, m, n, mat)

        return flip.coerceAtMost(notFlip)
    }

    private fun flipThem(i: Int, del: Array<Int>, j: Int, m: Int, n: Int, mat: Array<IntArray>) {
        for (k in 0 until 4) {
            val x = i + del[k]
            val y = j + del[k + 1]
            if (valid(x, y, m, n)) mat[x][y] = 1 - mat[x][y]
        }
        mat[i][j] = 1 - mat[i][j]
    }

    private fun allZeros(mat: Array<IntArray>): Boolean {
        for (x in mat) {
            for (y in x) {
                if (y != 0) return false
            }
        }
        return true
    }

    private fun valid(x: Int, y: Int, m: Int, n: Int) = (x in 0 until m && y in 0 until n)
