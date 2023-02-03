    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) return s
        val n = s.length
        val numCols = Math.ceil(n.toDouble() / (numRows + numRows - 2).toDouble()) * (numRows - 1)
        val letters = Array(numRows) { Array(numCols.toInt()) { '*' } }
        val sb = StringBuilder()

        var i = 0
        var j = 0
        var down = true
        s.forEach {
            letters[i][j] = it
            if (i == 0) down = true
            if (i == numRows - 1) down = false
            if (down) {
                i++
            } else {
                i--
                j++
            }
        }

        letters.forEach {
            it.forEach { c ->
                if (c != '*') sb.append(c)
            }
        }
        return sb.toString()
    }

    fun main() {
        val s = "paypalishiring"
        val numRows = 4
        println(
            convert(s, numRows)
        )
    }