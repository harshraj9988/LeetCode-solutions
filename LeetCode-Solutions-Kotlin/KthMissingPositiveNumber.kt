    fun findKthPositive(arr: IntArray, k: Int): Int {
        val temp = Array(1001) { false }
        temp[0] = true
        for(a in arr) temp[a] = true
        var x = k
        for(i in 1 until 1001) {
            if(!temp[i]) x--
            if(x==0) return i
        }
        return 1000+x
    }