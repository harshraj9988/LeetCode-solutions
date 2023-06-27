    fun tallestBillboard(rods: IntArray): Int {
        var dp = hashMapOf(0 to 0)
        for (r in rods) {
            val newDp = HashMap(dp)
            for (entry in dp) {
                val diff = entry.key
                val taller = entry.value
                val shorter = taller - diff

                val nDiff = diff + r
                val nTaller = (taller + r).coerceAtLeast(newDp[nDiff] ?: 0)
                newDp[nDiff] = nTaller

                val nDiff1 = Math.abs(diff - r)
                val nTaller1 = taller.coerceAtLeast(shorter + r).coerceAtLeast(newDp[nDiff1] ?: 0)
                newDp[nDiff1] = nTaller1

            }
            dp = newDp
        }
        return dp[0] ?: 0
    }
