    fun minCost(basket1: IntArray, basket2: IntArray): Long {
        val freq1 = HashMap<Int, Int>()
        val freq2 = HashMap<Int, Int>()
        val unique1 = ArrayList<Int>()
        val unique2 = ArrayList<Int>()
        var ans = 0L

        var mini = Int.MAX_VALUE
        basket1.forEach {
            freq1[it] = (freq1[it] ?: 0) + 1
            mini = mini.coerceAtMost(it)
        }
        basket2.forEach {
            freq2[it] = (freq2[it] ?: 0) + 1
            mini = mini.coerceAtMost(it)
        }

        basket1.forEach {
            if (freq2.containsKey(it)) {
                freq2[it] = freq2[it]!! - 1
                if (freq2[it] == 0) freq2.remove(it)
            } else {
                unique1.add(it)
            }
        }

        basket2.forEach {
            if (freq1.containsKey(it)) {
                freq1[it] = freq1[it]!! - 1
                if (freq1[it] == 0) freq1.remove(it)
            } else {
                unique2.add(it)
            }
        }

        val m = unique1.size
        val n = unique2.size
        if (n != m || n % 2 != 0) return -1L

        unique1.sort()
        unique2.sort()

        for (i in 0 until n step 2) {
            if (
                unique1[i] != unique1[i + 1] ||
                unique2[i] != unique2[i + 1]
            ) return -1L
        }

        var start1 = 0
        var start2 = 0
        var end1 = n - 1
        var end2 = n - 1

        while (start1 < end1 && start2 < end2) {
            if (unique1[start1] < unique2[start2]) {
                if (2 * mini < unique1[start1]) {
                    ans += 2 * mini
                    end1 -= 2
                    end2 -= 2
                } else {
                    ans += unique1[start1]
                    start1 += 2
                    end2 -= 2
                }
            } else {
                if (2 * mini < unique2[start2]) {
                    ans += 2 * mini
                    end1 -= 2
                    end2 -= 2
                } else {
                    ans += unique2[start2]
                    start2 += 2
                    end1 -= 2
                }
            }
        }

        return ans
    }