import java.util.*

fun simplifyPath(path: String): String {
    val pathNames = path.split("/")
    val st = Stack<String>()
    for (p in pathNames) {
        if (p == "." || p.isBlank()) continue
        else if (p == "..") {
            if (st.isNotEmpty()) st.pop()
        }
        else st.add(p)
    }
    if (st.isEmpty()) return "/"
    val sb = StringBuilder()
    for (p in st) {
        sb.append("/$p")
    }
    return sb.toString()
}