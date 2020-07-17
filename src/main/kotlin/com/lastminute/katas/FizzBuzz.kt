package com.lastminute.katas

import arrow.core.Option
import arrow.core.getOrElse

fun word(divisor: Int, word: String): Rule = { n: Int ->
    when {
        n == 0            -> Option.empty()
        n % divisor == 0  -> Option.just(word)
        else              -> Option.empty()
    }
}

val fizz: Rule = word(3, "Fizz")
val buzz: Rule = word(5, "Buzz")

val rules: List<Rule> = listOf(fizz, buzz)

fun createFizzBuzz(rules: List<Rule>): (Int) -> String {
    val applyAllRulesTo = rules.combined()
    return { n: Int ->
        applyAllRulesTo(n).getOrElse { "$n" }
    }
}

val fizzBuzz: (Int) -> String = createFizzBuzz(rules)
