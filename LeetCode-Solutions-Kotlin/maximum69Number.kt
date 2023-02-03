import java.util.Stack

fun maximum69Number(num: Int): Int {
    var n = num
    val stack = Stack<Int>()
    while (n > 0) {
        stack.add(n % 10)
        n /= 10
    }
    var ans = 0
    var change = true
    stack.forEach {
        ans = if(change && it==6) {
            change = false
            ans*10+9
        } else {
            ans*10+it
        }
    }
    return ans
}