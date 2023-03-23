fun partition(s: String): List<List<String>> {
    val ans = ArrayList<ArrayList<String>>()
    rec(s, 0, StringBuilder(), ArrayList(), ans)
    return ans
}

private fun rec(s: String, i: Int, sb: StringBuilder, list: ArrayList<String>, ans: ArrayList<ArrayList<String>>) {
    if (i >= s.length) {
        if (sb.isNotEmpty() && sb.isPalindrome()) {
            val temp = ArrayList(list)
            temp.add(sb.toString())
            ans.add(temp)
        }
        return
    }

    sb.append(s[i])
    if (sb.isPalindrome()) {
        val temp = ArrayList(list)
        temp.add(sb.toString())
        rec(s, i + 1, StringBuilder(), temp, ans)
    }
    rec(s, i + 1, sb, list, ans)
}

private fun StringBuilder.isPalindrome(): Boolean {
    var i = 0
    var j = this.length - 1
    while (i < j) {
        if (this[i++] != this[j--]) return false
    }
    return true
}

fun main() {
    val s = "abcccddeegefdfd"
    partition(s).forEach { list ->
        println(list)
    }
}