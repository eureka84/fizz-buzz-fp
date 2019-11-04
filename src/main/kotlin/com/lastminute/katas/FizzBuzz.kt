package com.lastminute.katas

import arrow.core.Option
import arrow.core.getOrElse

typealias Rule = (Int) -> Option<String>

fun createRule(divisor: Int, word: String): Rule = { n: Int ->
    if (n % divisor == 0)
        Option.just(word)
    else
        Option.empty()
}

val fizz = createRule(3, "Fizz")
val buzz = createRule(5, "Buzz")

fun fizzBuzz(number: Int): String {

    val rules = listOf(fizz, buzz)

    val monoid: Monoid<Option<String>> = monoidOption(semigroupOption(semigroupString))

    val rulesApplied: Option<String> = rules.foldMap(monoid) { rule -> rule(number) }

    return rulesApplied.getOrElse { number.toString() }
}

