package com.lastminute.katas

import arrow.core.Option

typealias Rule = (Int) -> Option<String>

val ruleMonoid: Monoid<Rule> = object: Monoid<Rule> {

    val monoid: Monoid<Option<String>> = monoidOption(semigroupOption(semigroupString))

    override fun empty(): Rule  = { _ -> Option.empty()}

    override fun combine(a: Rule, b: Rule): Rule = { number: Int ->
            monoid.combine(a(number), b(number))
    }

}

fun List<Rule>.combineAll(): Rule = this.combineAll(ruleMonoid)