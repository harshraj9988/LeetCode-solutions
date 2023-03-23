
    fun restoreIpAddresses(s: String): List<String> {
        val n = s.length
        val ans = ArrayList<String>()

        for (i in 1 until n - 2) {
            for (j in i + 1 until n - 1) {
                for (k in j + 1 until n) {
                    val a = getInt(s, 0, i)
                    val b = getInt(s, i, j)
                    val c = getInt(s, j, k)
                    val d = getInt(s, k, n)
                    if(validIpNums(a, b, c, d)) {
                        ans.add("$a.$b.$c.$d")
                    }
                }
            }
        }

        return ans
    }

    private fun getInt(s: String, a: Int, b: Int): Int {
        val num = s.substring(a, b).toInt()
        return if (num > 0 && s[a] == '0') -1
        else num
    }

    private fun validIpNums(a: Int, b: Int, c: Int, d: Int): Boolean {
        return (a in 0..255) && (b in 0..255) && (c in 0..255) && (d in 0..255)
    }

fun main() {
    val s = "101023"
    restoreIpAddresses(s).forEach {
        println(it.toString())
    }

}