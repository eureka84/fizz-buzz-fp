package com.lastminute.katas

import arrow.core.Option
import arrow.core.extensions.option.monoid.monoid
import arrow.core.extensions.semigroup
import arrow.core.getOrElse
import arrow.typeclasses.Monoid

typealias Rule = (Int) -> Option<String>

fun word(divisor: Int, word: String): Rule = { n: Int ->
    if (n % divisor == 0)
        Option.just(word)
    else
        Option.empty()
}

val fizz: Rule = word(3, "Fizz")
val buzz: Rule = word(5, "Buzz")

val rules = listOf(fizz, buzz)

fun createFizzBuzz(rules: List<Rule>): (Int) -> String = { n: Int ->
    val monoid: Monoid<Option<String>> = Option.monoid(String.semigroup())
    monoid.run {
        val rulesApplied = rules.fold(monoid.empty(), { acc, curr ->acc.combine(curr(n)) })
        rulesApplied.getOrElse { n.toString() }
    }
}

val fizzBuzz: (Int) -> String = createFizzBuzz(rules)
