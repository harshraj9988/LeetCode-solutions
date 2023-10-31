    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        var m = nums1.size
        var n = nums2.size
        if(m < n) return findMedianSortedArrays(nums2, nums1)
        var s = 0
        var e = m * 2
        while (s <= e) {
            val mid2 = (s + e) / 2
            val mid1 = m + n - mid2
            val x1 = if (mid1 == 0) Int.MIN_VALUE else nums1[(mid1 - 1) / 2]
            val x2 = if (mid2 == 0) Int.MIN_VALUE else nums2[(mid2 - 1) / 2]
            val y1 = if (mid1 == m * 2) Int.MAX_VALUE else nums1[mid1 / 2]
            val y2 = if (mid2 == n * 2) Int.MAX_VALUE else nums2[mid2 / 2]
            if (x1 > y2) s = mid1 + 1
            else if (x2 > y1) e = mid1 - 1
            else return Math.max(x1, x2).toDouble() / 2.0 + Math.min(y1, y2).toDouble() / 2.0

        }
        return -1.0
    }