fun distributeCookies(cookies: IntArray, k: Int): Int {
        return recursion(cookies, IntArray(k), cookies.lastIndex)
    }

    private fun recursion(cookies: IntArray, kids: IntArray, bag: Int) : Int {
        if(bag < 0) {
            return kids.reduce { a, b -> a.coerceAtLeast(b) }
        }
        var maxUnfairness = Int.MAX_VALUE
        for(i in kids.indices) {
            kids[i] += cookies[bag]
            maxUnfairness = maxUnfairness.coerceAtMost(recursion(cookies, kids, bag-1))
            kids[i] -= cookies[bag]
        }

        return maxUnfairness
    }
