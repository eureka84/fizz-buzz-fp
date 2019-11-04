package com.lastminute.katas

import arrow.core.Option

interface Semigroup<A> {
    fun combine(a: A, b: A): A
}

val semigroupString: Semigroup<String> = object : Semigroup<String> {
    override fun combine(a: String, b: String): String = a + b
}

fun <A> semigroupOption(semigroupA: Semigroup<A>): Semigroup<Option<A>> =
    object : Semigroup<Option<A>> {
        override fun combine(a: Option<A>, b: Option<A>): Option<A> =
            a.fold(
                { b },
                { valA: A ->
                    b.fold(
                        { a },
                        { valB: A ->
                            Option.just(semigroupA.combine(valA, valB))
                        }
                    )
                }
            )
    }

fun <A> monoidOption(semigroupOption: Semigroup<Option<A>>): Monoid<Option<A>> =
    object : Monoid<Option<A>>, Semigroup<Option<A>> by semigroupOption {
        override fun empty(): Option<A> = Option.empty()
    }

interface Monoid<A> : Semigroup<A> {
    fun empty(): A
}

// This can be abstracted for all structure that supports fold
fun <A, B> List<A>.foldMap(m: Monoid<B>, f: (A) -> B): B = this.fold(m.empty()) { acc, curr -> m.combine(acc, f(curr)) }