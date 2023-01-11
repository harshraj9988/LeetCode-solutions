import java.io.File
import java.io.PrintWriter
import java.util.*

private fun solve(input: Scanner, output: PrintWriter) {
    var t = input.nextInt()
    while (t-- > 0) {
        val n = input.nextInt()
        val arr = IntArray(n)
        val vis = Array(n) { -1 }
        for (i in 0 until n) arr[i] = input.nextInt() - 1
        val cycles = findNumberOfCycle(arr, vis)
        var ans = Int.MAX_VALUE
        for(i in 0 until n-1) {
            if(vis[i] == vis[i+1]) {
                ans = ans.coerceAtMost( n - (cycles + 1) )
            }else{
                ans = ans.coerceAtMost( n - (cycles - 1) )
            }
        }
       output.println(ans)
    }
}

private fun findNumberOfCycle(arr: IntArray, vis: Array<Int>): Int {
    var cycles = 0
    for(i in arr.indices) {
        if(vis[i] != -1) continue
        var temp = arr[i]
        vis[i] = i
        cycles++
        while(vis[temp] == -1) {
            vis[temp] = i
            temp = arr[temp]
        }
    }
    return cycles
}


fun main() {
    var input = Scanner(System.`in`)
    var output = PrintWriter(System.out)
    try {
        val inputFile = File("/home/harsh/Documents/Codes/LeetCode-solutions/LeetCode-Solutions-Kotlin/io/input.txt")
        input = Scanner(inputFile.inputStream())
        val outputFile = File("/home/harsh/Documents/Codes/LeetCode-solutions/LeetCode-Solutions-Kotlin/io/output.txt")
        output = PrintWriter(outputFile)
        output.flush()
    } catch (_: Exception) {
    }

    solve(input, output)

    output.close()
    input.close()
}


