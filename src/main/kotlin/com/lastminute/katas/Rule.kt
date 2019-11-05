package com.lastminute.katas

import arrow.core.Option
import arrow.core.extensions.list.foldable.combineAll
import arrow.core.extensions.option.monoid.monoid
import arrow.core.extensions.semigroup
import arrow.typeclasses.Monoid

typealias Rule = (Int) -> Option<String>

val ruleMonoid: Monoid<Rule> = object: Monoid<Rule> {

    val monoid: Monoid<Option<String>> = Option.monoid(String.semigroup())

    override fun empty(): Rule  = { _ -> Option.empty()}

    override fun (Rule).combine(b: Rule): Rule = { number: Int ->
        val self = this
        monoid.run {
            self(number).combine(b(number))
        }
    }

}

fun List<Rule>.combineAll(): Rule = this.combineAll(ruleMonoid)