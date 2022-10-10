private fun main(){
    runTestCases()
}

private fun codelandUsernameValidation(str: String): String {
    /*
        It must start with a letter -> [A-Za-z]
        It cannot end with an underscore character -> [^_]
        Any alphanumeric or underscore character between the first and the last character -> \w{2,23} (2 or more, 23 or less)
     */
    val rules = Regex(pattern = "^[A-Za-z]\\w{2,23}[^_]$")
    return rules.matches(str).toString()
}

private fun runTestCases() {
    checkCase(mustReturn = "false", returnValue = codelandUsernameValidation(""))
    checkCase(mustReturn = "false", returnValue = codelandUsernameValidation("abc"))
    checkCase(mustReturn = "true", returnValue = codelandUsernameValidation("abcd"))
    checkCase(mustReturn = "true", returnValue = codelandUsernameValidation("Abcd"))
    checkCase(mustReturn = "false", returnValue = codelandUsernameValidation("abcd_"))
    checkCase(mustReturn = "false", returnValue = codelandUsernameValidation("0abcd"))
    checkCase(mustReturn = "true", returnValue = codelandUsernameValidation("abcd0"))
    checkCase(mustReturn = "false", returnValue = codelandUsernameValidation("abcdabcdabcdabcdabcdabcdab"))
}
