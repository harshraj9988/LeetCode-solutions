import java.util.*

class LC {

    fun minOperations(n: Int): Int {
        var count = 0
        var move =false
        var i = 32
        var x = n
        val arr = IntArray(33)
        while(x>0) {
            if(x and 1 == 1) {
                arr[i--] = 1
            }else{
                arr[i--] = 0
            }
            x = x shr 1
        }
        for(a in 0..33){
            for (b in 32 downTo 0) {
                if ((b >= 1 && arr[b - 1] == 1 && arr[b] == 1) || (arr[b] == 1 && move)) {
                    arr[b] = 0
                    move = true
                } else if (arr[b] == 0 && move) {
                    arr[b] = 1
                    move = false
                    count++
                    break
                }
            }
        }
        for(ind in 0 until 33) {
            if(arr[ind]==1) count++
        }
        return count
    }

    fun mergeArrays(nums1: Array<IntArray>, nums2: Array<IntArray>): Array<IntArray> {
        val treeMap = TreeMap<Int, Int>()
        nums1.forEach{
            treeMap[it[0]] = it[1]
        }
        nums2.forEach{
            treeMap[it[0]] = (treeMap[it[0]]?:0) + it[1]
        }
        val mapSize = treeMap.size
        val result = Array(mapSize) {IntArray(2)}
        var index = 0
        treeMap.forEach{
            result[index++] = arrayOf(it.key, it.value).toIntArray()
        }
        return result
    }


    private val mod = 1e9.toLong() + 7.toLong()
    private lateinit var sq: ArrayList<Int>
    fun squareFreeSubsets(nums: IntArray): Int {
        sq = ArrayList<Int>()
        for(i in 2 until 30000){
            if(i*i > 30000) break
            sq.add(i*i)
        }
        return (find(nums, nums.size-1, 0)%mod).toInt()
    }
    private fun find(nums: IntArray, i: Int, set: HashSet<Int>): Long{
        if(i<0) return 0L

        var pick = 0L
        var notPick = 0L

        if(set.contains(nums[i])){
            
        }
        val nSet = HashSet(set)

        return (pick%mod + notPick%mod)%mod
    }
}

fun main() {
    val lc = LC()
    println(lc.squareFreeSubsets(IntArray(5)))
}