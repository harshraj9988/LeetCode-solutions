import java.util.*

class SummaryRanges() {
    val set = TreeSet<Int>()

    fun addNum(value: Int) {
        set.add(value)
    }

    fun getIntervals(): Array<IntArray> {
        val temp = ArrayList<IntArray>()
        var prev = -2
        var ints = IntArray(2)
        set.forEach {
            if(it-1 != prev) {
                if(prev != -2) {
                    temp.add(ints)
                }
                ints = arrayOf(it, it).toIntArray()
            }else{
                ints[1] = it
                prev = it
            }
        }
        if(prev != -2){ temp.add(ints) }
        return temp.toArray(Array(temp.size){IntArray(2)})
    }
}
