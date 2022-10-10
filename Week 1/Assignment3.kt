private fun main() {
    runTestCases()
}

fun firstFactorial(num: Int): Int {
    if (num == 0) return 1
    return num * firstFactorial(num - 1)
}

private fun runTestCases() {
    checkCase(mustReturn = "1", returnValue = firstFactorial(0))
    checkCase(mustReturn = "1", returnValue = firstFactorial(1))
    checkCase(mustReturn = "2", returnValue = firstFactorial(2))
    checkCase(mustReturn = "6", returnValue = firstFactorial(3))
    checkCase(mustReturn = "24", returnValue = firstFactorial(4))
    checkCase(mustReturn = "120", returnValue = firstFactorial(5))
}
