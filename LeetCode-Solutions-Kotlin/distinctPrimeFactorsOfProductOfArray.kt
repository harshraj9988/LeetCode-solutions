private fun primesTillOneThousand(): IntArray {
    val primes = Array(1001) { true }
    var i = 2
    while (i * i <= 1000) {
        if (primes[i]) {
            var j = i * i
            while (j <= 1000) {
                primes[j] = false
                j += i
            }
        }
        i++
    }
    val temp = ArrayList<Int>()
    for (i in 2..1000) if (primes[i]) temp.add(i)
    return temp.toIntArray()
}

fun distinctPrimeFactors(nums: IntArray): Int {
    val primes = primesTillOneThousand()
    val hashSet = HashSet<Int>()
    for (num in nums) {
        for (prime in primes) {
            if (prime > num) break
            if (num % prime == 0) hashSet.add(prime)
        }
    }
    return hashSet.size
}

