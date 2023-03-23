    fun maxPoints(points: Array<IntArray>): Int {
        val n = points.size
        val flat = 1e8
        val arrayMap = Array(n) { HashMap<Double, Int>() }
        var maxi = 0
        for(i in 0 until n) {
            val x1 = points[i][0].toDouble()
            val y1 = points[i][1].toDouble()
            for(j in i+1 until n) {
                val x2 = points[j][0].toDouble()
                val y2 = points[j][0].toDouble()
                val slope = if(x2 != x1) {
                    Math.abs(y2-y1)/Math.abs(x2-x1)
                }else{
                    flat
                }
                if(!arrayMap[i].containsKey(slope)) arrayMap[i][slope] = 1
                arrayMap[i][slope] = arrayMap[i][slope]!!+1
                maxi = maxi.coerceAtLeast(arrayMap[i][slope]!!)
            }

        }
        return maxi
    }