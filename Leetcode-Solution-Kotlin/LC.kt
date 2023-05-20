class LC {
    fun firstCompleteIndex(arr: IntArray, mat: Array<IntArray>): Int {
        val m = mat.size
        val n = mat[0].size
        val mapPosition = HashMap<Int, Pair<Int, Int>>()
        val countCols = IntArray(n) { 0 }
        val countRows = IntArray(m) { 0 }

        for (i in 0 until m) {
            for (j in 0 until n) {
                mapPosition[mat[i][j]] = Pair(i, j)
            }
        }

        for (i in arr.indices) {
            val currentRow = mapPosition[arr[i]]!!.first
            val currentCol = mapPosition[arr[i]]!!.second
            countRows[currentRow]++
            countCols[currentCol]++
            if(countRows[currentRow] == n || countCols[currentCol] == m) {
                return i
            }
        }

        return -1
    }

}

fun main() {
    val lc = LC()


}
