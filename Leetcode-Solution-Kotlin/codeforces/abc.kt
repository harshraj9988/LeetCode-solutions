import java.io.File
import java.io.PrintWriter
import java.util.*

private fun solve(input: Scanner, output: PrintWriter) {
    var t = input.nextInt()
    while (t-- > 0) {



    }
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


