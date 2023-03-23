    fun canArrange(arr: IntArray, k: Int): Boolean {
        val map = HashMap<Int, ArrayList<Int>>()
        for (i in 0 until k) map[i] = ArrayList()
        arr.forEach { map[((it % k + k) % k)]?.add(it) }
        for (i in 0 until k) {
            if (i == 0 && map[i]!!.size % 2 != 0) return false
            else if (i > 0 && map[i]!!.size != map[k - i]!!.size) return false
        }
        return true
    }