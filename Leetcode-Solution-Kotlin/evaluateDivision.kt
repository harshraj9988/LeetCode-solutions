fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
    val stoi = HashMap<String, Int>()
    var ind = 0
    equations.forEach { eq ->
        eq.forEach {
            if (!stoi.containsKey(it)) {
                stoi[it] = ind
                ind++
            }
        }
    }
    val mat = Array(ind) { DoubleArray(ind) { (-1).toDouble() } }
    equations.forEachIndexed { i, eq ->
        mat[stoi[eq[0]]!!][stoi[eq[1]]!!] = values[i]
        mat[stoi[eq[1]]!!][stoi[eq[0]]!!] = 1.toDouble() / values[i]
        mat[stoi[eq[1]]!!][stoi[eq[1]]!!] = 1.toDouble()
        mat[stoi[eq[0]]!!][stoi[eq[0]]!!] = 1.toDouble()
    }
    for (k in 0 until ind) {
        for (i in 0 until ind) {
            for (j in 0 until ind) {
                if (mat[i][k] >= 0 && mat[k][j] >= 0)
                    mat[i][j] = mat[i][k] * mat[k][j]
            }
        }
    }

    val ans = DoubleArray(queries.size)
    queries.forEachIndexed { i, it ->
        if (!stoi.containsKey(it[0]) || !stoi.containsKey(it[1])) {
            ans[i] = (-1).toDouble()
        } else {
            ans[i] = mat[stoi[it[0]]!!][stoi[it[1]]!!]
        }
    }
    return ans
}