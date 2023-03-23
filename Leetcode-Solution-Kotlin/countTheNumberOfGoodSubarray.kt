    fun countGood(nums: IntArray, k: Int): Long {
        var cnt: Long = 0L
        val n = nums.size
        val map = HashMap<Int, Long>()
        var i = 0
        var j = 0
        var temp = 0L
        while (j < n && i < n) {
            map[nums[j]] = 1 + (map[nums[j]] ?: 0)
            if (map[nums[j]]!! >= 2) {
                temp -= ((map[nums[j]]!! - 1) * (map[nums[j]]!! - 2) / 2)
                temp += ((map[nums[j]]!!) * (map[nums[j]]!! - 1) / 2)
            }

            while (i < j && temp >= k) {
                cnt += (n - j)
                if (map[nums[i]]!! >= 2) {
                    temp -= ((map[nums[i]]!!) * (map[nums[i]]!! - 1) / 2)
                }
                map[nums[i]] = (map[nums[i]] ?: 0) - 1
                if (map[nums[i]]!! >= 2) {
                    temp += ((map[nums[i]]!!) * (map[nums[i]]!! - 1) / 2)
                }
                if (map[nums[i]]!! <= 0) map.remove(nums[i])
                i++
            }
            j++
        }

        while (i < j && temp >= k) {
            cnt += (n - j + 1)
            if (map[nums[i]]!! >= 2) {
                temp -= ((map[nums[i]]!!) * (map[nums[i]]!! - 1) / 2)
            }
            map[nums[i]] = (map[nums[i]] ?: 0) - 1
            if (map[nums[i]]!! >= 2) {
                temp += ((map[nums[i]]!!) * (map[nums[i]]!! - 1) / 2)
            }
            if (map[nums[i]]!! <= 0) map.remove(nums[i])
            i++
        }
        return cnt
    }

    fun main() {
        val nums = arrayOf(1,1,3,1,2,1,2,2,1,2,1,2,3,3).toIntArray()
        val k = 14
        println(countGood(nums , k))
    }
