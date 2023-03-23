import java.util.*

fun main(){
    val input = Scanner(System.`in`)
    val n = input.nextInt()
    val arr = LongArray(n)
    val brr = LongArray(n)
    for(i in 0 until n) arr[i] = input.nextLong()
    input.nextLong()
    for(i in 0 until n) brr[i] = input.nextLong()
    val m = input.nextInt()
    val crr = LongArray(m)
    for(i in 0 until m) crr[i] = input.nextLong()


}