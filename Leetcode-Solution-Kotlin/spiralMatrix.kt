fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    var m1 = 0
    var n1 = 0
    var m2 = matrix.size - 1
    var n2 = matrix[0].size - 1
    val ans = ArrayList<Int>()
    var items = matrix.size * matrix[0].size

    while (items > 0) {
        for (j in n1..n2) {
            if (items <= 0) break
            items--
            ans.add(matrix[m1][j])
        }
        for (i in m1 + 1..m2) {
            if (items <= 0) break
            items--
            ans.add(matrix[i][n2])
        }
        for (j in n2 - 1 downTo n1) {
            if (items <= 0) break
            items--
            ans.add(matrix[m2][j])
        }
        for (i in m2 - 1 downTo m1 + 1) {
            if (items <= 0) break
            items--
            ans.add(matrix[i][n1])
        }
        m2--
        n2--
        m1++
        n1++
    }
    return ans
}