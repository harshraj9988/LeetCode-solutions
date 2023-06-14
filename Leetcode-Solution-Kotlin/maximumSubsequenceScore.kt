    import java.util.*

    fun maxScore(nums1: IntArray, nums2: IntArray, k: Int): Long {
        val arr = Array(nums1.size) { IntArray(2) }
        for (i in arr.indices) {
            arr[i][0] = nums1[i]
            arr[i][1] = nums2[i]
        }
        Arrays.sort(arr) { a, b ->
            b[1].compareTo(a[1])
        }

        var sum = 0L
        var min = Long.MAX_VALUE


        val pq = PriorityQueue<Long>(k)
        for (i in 0 until k) {
            sum += arr[i][0].toLong()
            pq.add(arr[i][0].toLong())
        }

        var ans = sum * arr[k - 1][1]

        for (i in k until arr.size) {
            sum += arr[i][0].toLong() - pq.poll()
            pq.add(arr[i][0].toLong())
            ans = ans.coerceAtLeast(sum * arr[i][1])
        }

        return ans
    }