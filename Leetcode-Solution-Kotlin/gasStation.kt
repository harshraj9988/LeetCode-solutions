fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
    val n = gas.size
    val requiredAtBeginning = IntArray(n + 2)
    val availableAtEnd = IntArray(n + 2)

    for (i in 1..n) {
        requiredAtBeginning[i] = requiredAtBeginning[i - 1] + (gas[i - 1] - cost[i - 1])
    }
    for (i in n downTo 1) {
        availableAtEnd[i] = availableAtEnd[i + 1] + (gas[i - 1] - cost[i - 1])
    }
    requiredAtBeginning[0] = requiredAtBeginning[n]
    availableAtEnd[n + 1] = availableAtEnd[1]
    if (requiredAtBeginning[1] + availableAtEnd[2] < 0) return -1
    var startingGasStation = 1
    for (i in 1..n) {
        if (
            requiredAtBeginning[i] < requiredAtBeginning[startingGasStation - 1] &&
            requiredAtBeginning[i] + availableAtEnd[i + 1] >= 0
        ) {
            startingGasStation = i + 1
        }
    }
    return (startingGasStation - 1) % n
}