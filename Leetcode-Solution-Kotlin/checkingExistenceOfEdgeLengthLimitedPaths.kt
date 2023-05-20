import java.util.Arrays

private fun findParent(u: Int, parents: IntArray): Int {
    if (u == parents[u]) {
        return u
    }
    parents[u] = findParent(parents[u], parents)
    return parents[u]
}

private fun union(u: Int, v: Int, parents: IntArray, ranks: IntArray) {
    val parU = findParent(u, parents)
    val parV = findParent(v, parents)
    if (parU == parV) {
        return
    }
    if (ranks[parU] < ranks[parV]) {
        parents[parU] = parV
    } else if (ranks[parU] > ranks[parV]) {
        parents[parV] = parU
    } else {
        parents[parU] = parV
        ranks[parV]++
    }
}

fun distanceLimitedPathsExist(n: Int, edgeList: Array<IntArray>, queries: Array<IntArray>): BooleanArray {
    val resultArray = BooleanArray(queries.size)

    edgeList.sortWith { a, b ->
        a[2] compareTo b[2]
    }

    val nQueries =
        queries.mapIndexed { index, ints -> intArrayOf(ints[0], ints[1], ints[2], index) } as ArrayList<IntArray>

    nQueries.sortWith { a, b ->
        a[2] compareTo b[2]
    }

    val parents = IntArray(n) { it }
    val ranks = IntArray(n) { 0 }

    var index = 0
    nQueries.forEach { query ->
        while (index < edgeList.size && edgeList[index][2] < query[2]) {
            union(edgeList[index][0], edgeList[index][1], parents, ranks)
            index++
        }
        resultArray[query[3]] = findParent(query[0], parents) == findParent(query[1], parents)
    }

    return resultArray
}