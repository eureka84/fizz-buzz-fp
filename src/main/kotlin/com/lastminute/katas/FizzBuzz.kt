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

fun createFizzBuzz(rules: List<Rule>): (Int) -> String = { number: Int ->
    val monoid: Monoid<Option<String>> = monoidOption(semigroupOption(semigroupString))

    val rulesApplied: Option<String> = rules.foldMap(monoid) { rule -> rule(number) }

    rulesApplied.getOrElse { number.toString() }
}

val fizzBuzz = createFizzBuzz(listOf(fizz, buzz))
