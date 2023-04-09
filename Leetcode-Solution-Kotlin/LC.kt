import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class LC {

    private fun isPrime(value: Int): Boolean {
        var test = 2
        while (test * test <= value) {
            if (value % test == 0) return false
            test++
        }
        return true
    }

    fun diagonalPrime(nums: Array<IntArray>): Int {
        val n = nums.size
        var ans = 0
        for (i in 0 until n) {
            if (nums[i][n - 1 - i] > 1 && isPrime(nums[i][n - 1 - i]))
                ans = ans.coerceAtLeast(nums[i][n - 1 - i])

            if (nums[i][i] > 1 && isPrime(nums[i][i]))
                ans = ans.coerceAtLeast(nums[i][i])

        }
        return ans
    }

    fun distance(nums: IntArray): LongArray {
        val prefixSum = HashMap<Int, ArrayList<Long>>()
        val intIndex = HashMap<Int, ArrayList<Int>>()
        val n = nums.size
        val result = LongArray(n)
        for (i in 0 until n) {
            if (!intIndex.containsKey(nums[i])) {
                prefixSum[nums[i]] = ArrayList()
                intIndex[nums[i]] = ArrayList()
            }
            intIndex[nums[i]]!!.add(i)
            val size = prefixSum[nums[i]]!!.size
            if (size == 0) prefixSum[nums[i]]!!.add(i.toLong())
            else prefixSum[nums[i]]!!.add(i.toLong() + prefixSum[nums[i]]!![size - 1])
        }

        for (i in 0 until n) {
            val index = intIndex[nums[i]]!!
            if (index.size == 1) continue
            val prefix = prefixSum[nums[i]]!!
            val temp = index.binarySearch(i)
            var sum = 0L
            if (temp > 0)
                sum += i.toLong() * temp - prefix[temp - 1]
            if (temp < index.size - 1)
                sum += prefix[index.size - 1] - prefix[temp] - i.toLong() * (index.size - 1 - temp)
            result[i] = sum
        }
        return result
    }


    fun minimizeMax(nums: IntArray, p: Int): Int {
        var low = 0
        var high = 1e9.toInt()
        var result = 0
        Arrays.sort(nums)

        while(low <= high) {
            val mid = low + (high - low) / 2
            if(valid(nums, p, mid)) {
                result = mid
                high = mid - 1
            }else{
                low = mid + 1
            }
        }
        return result
    }

    private fun valid(nums: IntArray, p: Int, mid: Int) : Boolean {
        var ind = 0
        var temp = p
        while(ind < nums.size-1) {
            if(nums[ind+1] - nums[ind] <= mid){
                ind += 2
                temp--
            }else{
                ind++
            }
            if(temp == 0) return true
        }
        return false
    }

}

fun main() {
    val lc = LC()
    val arr = intArrayOf(10,1,2,7,1,3)
    val p = 2
    println(lc.minimizeMax(arr, p))

}

// 883