    fun maxConsecutiveAnswers(answerKey: String, k: Int): Int {
        return change(answerKey.toCharArray(), k, 'T').coerceAtLeast(change(answerKey.toCharArray(), k, 'F'))
    }

    private fun change(arr: CharArray, k: Int, a: Char): Int {
        var len = 0
        var s = 0
        var e = 0
        var x = 0
        while (s < arr.size && e < arr.size) {
            len = len.coerceAtLeast(e - s + 1)
            if (arr[e] == a) {
                if (x < k) {
                    e++
                    x++
                } else {
                    if (arr[s] == a) {
                        x--
                    }
                    s++
                }
            } else {
                e++
            }
        }
        len = len.coerceAtLeast(e - s + 1)
        return len
    }

    fun main() {
        val a = "TTFF"
        val k = 2
        println(maxConsecutiveAnswers(a, k))
    }
