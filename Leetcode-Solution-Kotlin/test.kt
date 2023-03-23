import java.util.*

fun main() {
    val input = Scanner(System.`in`)
    var t = input.nextInt() / 2
    while (t-- > 0) {
        val n = input.nextInt()
        val m = input.nextInt()
        when (n) {
            1 -> println(2 * m - 2)
            2 -> println(6 * m - 4)
            else -> println(2 * (2 * n * m - n - m))
        }
    }
}