import java.util.*
import kotlin.collections.ArrayList
import kotlin.contracts.Returns

    fun fullBloomFlowers(flowers: Array<IntArray>, people: IntArray): IntArray {
        val bloomedFlowers = IntArray(people.size)
        var bloomTime = getBloomTime(flowers)
        sortBloomTime(bloomTime)
        bloomTime = mergeCoincidingBloomTime(bloomTime)
        performBloom(bloomTime)
        people.forEachIndexed { i, person ->
            bloomedFlowers[i] = findBloomedFlowers(bloomTime, person)
        }
        return bloomedFlowers
    }

    private fun mergeCoincidingBloomTime(bloomTime: ArrayList<Pair<Int, Int>>): ArrayList<Pair<Int, Int>> {
        val mergedBloomTime = ArrayList<Pair<Int, Int>>()
        bloomTime.forEach { bloom ->
            var prev = Pair(0, 0)
            if (mergedBloomTime.isNotEmpty() && mergedBloomTime.last().first == bloom.first) {
                prev = mergedBloomTime.removeLast()
            }
            mergedBloomTime.add(Pair(bloom.first, bloom.second + prev.second))
        }
        return mergedBloomTime
    }

    private fun findBloomedFlowers(bloomTime: ArrayList<Pair<Int, Int>>, person: Int): Int {
        var start = 0
        var end = bloomTime.lastIndex
        while (start <= end) {
            val mid = start + (end - start) / 2
            val time = bloomTime[mid].first
            if (person == time) return bloomTime[mid].second
            else if (person < time) {
                end = mid - 1
            } else {
                start = mid + 1
            }
        }
        if (start == 0) return 0
        return bloomTime[start - 1].second
    }

    private fun getBloomTime(flowers: Array<IntArray>): ArrayList<Pair<Int, Int>> {
        val bloomTime = ArrayList<Pair<Int, Int>>()
        flowers.forEach { flower ->
            bloomTime.add(Pair(flower[0], 1))
            bloomTime.add(Pair(flower[1] + 1, -1))
        }
        return bloomTime
    }

    private fun sortBloomTime(bloomTime: ArrayList<Pair<Int, Int>>) {
        Collections.sort(bloomTime) { a, b ->
            a.first.compareTo(b.first)
        }
    }

    private fun performBloom(bloomTime: ArrayList<Pair<Int, Int>>) {
        for (i in 1 until bloomTime.size) {
            val prev = bloomTime[i - 1]
            val curr = bloomTime[i]
            bloomTime[i] = Pair(curr.first, curr.second + prev.second)
        }
    }

fun main() {
    val flowers = arrayOf(
        intArrayOf(1, 6),
        intArrayOf(3, 7),
        intArrayOf(9, 12),
        intArrayOf(4, 13)
    )
    val people = intArrayOf(2, 3, 7, 11)
    println(fullBloomFlowers(flowers, people).contentToString())
}