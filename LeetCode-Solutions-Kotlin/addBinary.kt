import java.lang.StringBuilder
import java.util.*

    fun addBinary(a: String, b: String): String {
        val aLen = a.length
        val bLen = b.length
        val n = aLen.coerceAtLeast(bLen)
        val arr = CharArray(n)
        val brr = CharArray(n)
        for (i in 0 until aLen) {
            arr[n - 1 - i] = a[aLen - 1 - i]
        }
        for (i in 0 until bLen) {
            brr[n - 1 - i] = b[bLen - 1 - i]
        }
        var carry = '0'
        val stack = Stack<Char>()
        for (i in n - 1 downTo 0) {
            if (arr[i] == '1' && brr[i] == '1') {
                if (carry == '1') {
                    stack.push('1')
                } else {
                    carry = '1'
                    stack.push('0')
                }
            } else if (arr[i] == '1' || brr[i] == '1') {
                if (carry == '1') {
                    stack.push('0')
                } else {
                    stack.push('1')
                }
            } else {
                if (carry == '1') {
                    carry = '0'
                    stack.push('1')
                } else {
                    stack.push('0')
                }
            }
        }
        if(carry=='1') stack.push('1')
        val sb = StringBuilder()
        while (stack.isNotEmpty()) sb.append(stack.pop())
        return sb.toString()
    }