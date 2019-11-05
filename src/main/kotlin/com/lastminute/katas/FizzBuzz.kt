package com.lastminute.katas

val buzz: Rule = createRule(5, "Buzz")
val fizz: Rule = createRule(3, "Fizz")

val fizzBuzz = createFizzBuzz(listOf(fizz, buzz))

private fun createFizzBuzz(numberRules: List<Rule>): Rule = { number: Int ->
    combineAllRules(numberRules)(number).or("$number")
}

typealias Rule = (Int) -> String

private fun combineAllRules(rules: List<Rule>): Rule {
    val empty: Rule = { _: Int -> "" }
    return rules.fold(empty) { acc, rule -> combine(acc, rule) }
}

private fun String.or(default: String): String =
    if (this.isNotEmpty()) this else default

private fun createRule(divisor: Int, word: String): Rule = { n: Int ->
    if (n % divisor == 0)
        word
    else
        ""
}

private fun combine(aRule: Rule, anotherRule: Rule): Rule = { n: Int ->
    aRule(n) + anotherRule(n)
}
