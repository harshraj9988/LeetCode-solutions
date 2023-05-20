    private fun recursion(questions: Array<IntArray>, i: Int): Long {
        if (i >= questions.size) {
            return 0L
        }
        val solve = questions[i][0].toLong() + recursion(questions, i + questions[i][1] + 1)
        val notSolve = recursion(questions, i + 1)
        return solve.coerceAtLeast(notSolve)
    }

    private fun memoization(questions: Array<IntArray>, i: Int, dp: LongArray): Long {
        if (i >= questions.size) {
            return 0L
        }
        if (dp[i] != -1L) {
            return dp[i]
        }
        val solve = questions[i][0].toLong() + memoization(questions, i + questions[i][1] + 1, dp)
        val notSolve = memoization(questions, i + 1, dp)
        dp[i] = solve.coerceAtLeast(notSolve)
        return dp[i]
    }

    private fun tabulation(questions: Array<IntArray>): Long {
        val dp = LongArray(questions.size)
        for (i in questions.lastIndex downTo 0) {
            val solve =
                questions[i][0].toLong() + (if (i + questions[i][1] + 1 < questions.size) dp[i + questions[i][1] + 1] else 0)
            val notSolve = (if (i + 1 < questions.size) dp[i + 1] else 0)
            dp[i] = solve.coerceAtLeast(notSolve)
        }
        return dp[0]
    }

    fun mostPoints(questions: Array<IntArray>): Long {
    //    return recursion(questions, 0)

    //    val dp = LongArray(questions.size) { -1L }
    //    return memoization(questions, 0, dp)

        return tabulation(questions)
    }