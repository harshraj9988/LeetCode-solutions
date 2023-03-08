fun maxSet(A: IntArray): IntArray {
    val n = A.size
    var i =0
    var maxm = 0
    var count = 0
    var start = 0
    var end = -1
    var fStart = -1
    var fEnd = -1
    var sum = 0L
    var maxSum = 0L
    while (i<n) {
        if(A[i]>=0) {
            sum+=A[i].toLong()
            count++
            end++
        }
        if(sum > maxSum) {
            maxSum = sum
            fStart = start
            fEnd = end
        } else if(sum == maxSum && count > maxm) {
            maxm = count
            fStart = start
            fEnd = end
        }
        if(A[i] < 0) {
            count = 0
            start = i+1
            end = i
            sum = 0L
        }
        i++
    }
    val ans = IntArray(end-start+1)
    for(i in start..end) {
        ans[i-start] = A[i]
    }
    return ans
}

fun main() {
    val A = arrayOf(10,-2,2,3,-4,100).toIntArray()
    println(maxSet(A).contentToString())
}