package com.lastminute.katas

import arrow.core.Option
import arrow.core.getOrElse

fun createRule(divisor: Int, word: String): Rule = { n: Int ->
    when {
        n == 0           -> Option.empty()
        n % divisor == 0 -> Option.just(word)
        else             -> Option.empty()
    }
}

val fizz = createRule(3, "Fizz")
val buzz = createRule(5, "Buzz")

fun createFizzBuzz(rules: List<Rule>): (Int) -> String = { number: Int ->
    rules.combineAll()(number).getOrElse { "$number" }
}

val fizzBuzz = createFizzBuzz(listOf(fizz, buzz))
