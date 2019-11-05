package com.lastminute.katas

fun fizzBuzz(number: Int): String {
    val rules = listOf(fizz, buzz)

    val combinedRule = rules.fold(empty) { acc, rule -> combine(acc, rule) }

    val appliedCombinedRules = combinedRule(number)

    return if(appliedCombinedRules != "") appliedCombinedRules else "$number"
}

typealias Rule = (Int) -> String

private fun createRule(divisor: Int, word: String): Rule = { n: Int ->
    if (n % divisor == 0)
        word
    else
        ""
}

val buzz: Rule = createRule(5, "Buzz")
val fizz: Rule = createRule(3, "Fizz")
val empty: Rule = { _: Int -> "" }

private fun combine(aRule: Rule, anotherRule: Rule): Rule = { n: Int ->
    aRule(n) + anotherRule(n)
}
