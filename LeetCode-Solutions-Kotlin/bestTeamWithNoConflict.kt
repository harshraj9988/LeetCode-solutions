    import java.util.Arrays

    fun bestTeamScore(scores: IntArray, ages: IntArray): Int {
        val n = scores.size
        val players = Array(n) { IntArray(2) }
        for (i in 0 until n) {
            players[i][0] = ages[i]
            players[i][1] = scores[i]
        }
        Arrays.sort(players) { a, b -> if (a[0] != b[0]) a[0] - b[0] else a[1] - b[1] }
        val cache = Array(n) { Array(n + 1) { -1 } }
        return choosePlayers(players, n - 1, n, n, cache)
    }

    private fun choosePlayers(
        players: Array<IntArray>,
        currentPlayer: Int,
        previousPlayer: Int,
        n: Int,
        cache: Array<Array<Int>>
    ): Int {
        if (currentPlayer < 0) {
            return 0
        } else if (cache[currentPlayer][previousPlayer] != -1) {
            return cache[currentPlayer][previousPlayer]
        } else if (
            previousPlayer == n ||
            players[previousPlayer][1] > players[currentPlayer][1]
        ) {
            val takeTheCurrentPlayer =
                players[currentPlayer][1] + choosePlayers(players, currentPlayer - 1, currentPlayer, n, cache)
            val doNotTakeTheCurrentPlayer = choosePlayers(players, currentPlayer - 1, previousPlayer, n, cache)
            cache[currentPlayer][previousPlayer] = takeTheCurrentPlayer.coerceAtLeast(doNotTakeTheCurrentPlayer)
            return cache[currentPlayer][previousPlayer]
        } else {
            cache[currentPlayer][previousPlayer] = choosePlayers(players, currentPlayer - 1, previousPlayer, n, cache)
            return cache[currentPlayer][previousPlayer]
        }
    }