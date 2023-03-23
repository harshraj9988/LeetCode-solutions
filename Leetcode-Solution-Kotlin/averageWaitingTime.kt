    fun averageWaitingTime(customers: Array<IntArray>): Double {
        val n = customers.size
        val waitTime = IntArray(n)
        var chef = 0
        for (customer in 0 until n) {
            val arrival = customers[customer][0]
            val time = customers[customer][1]
            chef = if (chef <= arrival) {
                arrival + time
            } else {
                chef + time
            }
            val wait = chef - arrival
            waitTime[customer] = wait
        }
        var avgWaitTime: Double = 0.toDouble()
        waitTime.forEach { avgWaitTime += (it.toDouble()/n.toDouble()) }

        return avgWaitTime
    }