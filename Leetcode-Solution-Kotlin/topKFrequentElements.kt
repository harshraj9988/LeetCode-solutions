    import java.util.*

    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val min = Arrays.stream(nums).min().asInt
        val freq = IntArray(Arrays.stream(nums).max().asInt - min + 1) { 0 }

        nums.forEach {
            freq[it - min]++
        }


        val elements = Array(Arrays.stream(freq).max().asInt + 1) { Stack<Int>() }
        repeat(elements.size) {
            elements[it] = Stack()
        }

        freq.forEachIndexed { i, x ->
            elements[x].add(i + min)
        }

        var j = elements.lastIndex

        val ans = IntArray(k)
        repeat(k) {
            while (elements[j].isEmpty()) j--
            ans[it] = elements[j].pop()
        }

        return ans
    }