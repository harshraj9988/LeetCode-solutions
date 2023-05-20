    fun average(salary: IntArray): Double {
        var minSalary = Int.MAX_VALUE
        var maxSalary = Int.MIN_VALUE
        var total = 0.toDouble()
        for (s in salary) {
            total += s.toDouble()
            minSalary = minSalary.coerceAtMost(s)
            maxSalary = maxSalary.coerceAtLeast(s)
        }
        total -= (minSalary + maxSalary).toDouble()
        return total / (salary.size - 2).toDouble()
    }