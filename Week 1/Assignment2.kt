private fun main(){
    print("Enter an integer array: ")
    val input = readLine() ?: ""

    val intArray = input.split(" ").toLongArray()

    print(aVeryBigSum(intArray))
}

fun aVeryBigSum(intArray: LongArray): Long {
    return intArray.fold(0){ sum, value -> sum + value }
}
