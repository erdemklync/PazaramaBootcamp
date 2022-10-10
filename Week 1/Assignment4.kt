private fun main(){
    runTestCases()
}

private fun questionsMarks(str: String): String{
    var returnValue = false

    var previousDigit = 0
    var questionMarks = 0

    for (char in str){
        // If char is a letter, continue
        if(char.isLetter()) continue
      
        if (char.isDigit()){
            val currentDigit = char.digitToInt()
            val sum = previousDigit + currentDigit

            if(sum == 10) {
              
                // The loop must not break at this point as the value of returnValue might change later
                if(questionMarks == 3){
                    returnValue = true
                }else{
                    returnValue = false
                    // It is enough for the loop to break in the event that there is one single case that violates the rule.
                    break
                }
            }

            previousDigit = currentDigit
            questionMarks = 0
        }

        if (char == '?') questionMarks++

    }

    return returnValue.toString()
}

private fun runTestCases(){
    checkCase(mustReturn = "true", returnValue = questionsMarks("arrb6???4xxbl5???eee5"))
    checkCase(mustReturn = "false", returnValue = questionsMarks("aa6?9"))
    checkCase(mustReturn = "true", returnValue = questionsMarks("acc?7??sss?3rr1??????5"))
    checkCase(mustReturn = "false", returnValue = questionsMarks("aaaaaaarrrrr??????"))
    checkCase(mustReturn = "true", returnValue = questionsMarks("9???1???9???1???9  "))
    checkCase(mustReturn = "false", returnValue = questionsMarks("9???1???9??1???9"))
    checkCase(mustReturn = "false", returnValue = questionsMarks("4?5?4?aaccc9"))
    checkCase(mustReturn = "false", returnValue = questionsMarks("5??aaaaabcgaaaaaaaaaa?5?5"))
    checkCase(mustReturn = "true", returnValue = questionsMarks("5??aaaaaaaaaaaaaaaaaaa?5?a??5"))
    checkCase(mustReturn = "false", returnValue = questionsMarks("mbbv???????????4??????ddsdsdcc9?"))
}
