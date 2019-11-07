package com.lastminute.katas

import arrow.core.Option
import arrow.core.getOrElse

fun word(divisor: Int, word: String): Rule = { n: Int ->
    if (n!=0 && n % divisor == 0)
        Option.just(word)
    else
        Option.empty()
}

val fizz: Rule = word(3, "Fizz")
val buzz: Rule = word(5, "Buzz")

val rules: List<Rule> = listOf(fizz, buzz)

fun createFizzBuzz(rules: List<Rule>): (Int) -> String = { n: Int ->
    rules.combined()(n).getOrElse { "$n" }
}

val fizzBuzz: (Int) -> String = createFizzBuzz(rules)
