fun kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
    val ans = ArrayList<ArrayList<Int>>()
    val pq = PriorityQueue<Pair<Int, Int>> { a, b -> a.first.compareTo(b.first) }
    for (num in nums1) {
        pq.add(Pair(num + nums2[0], 0))
    }

    var x = k
    while (x-- > 0 && pq.isNotEmpty()) {
        val temp = pq.poll()
        ans.add(arrayListOf(temp.first - nums2[temp.second], nums2[temp.second]))

        if (temp.second + 1 < nums2.size) {
            pq.add(Pair(temp.first - nums2[temp.second] + nums2[temp.second + 1], temp.second + 1))
        }
    }
    return ans
}