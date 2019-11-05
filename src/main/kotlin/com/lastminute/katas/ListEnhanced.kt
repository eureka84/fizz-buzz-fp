package com.lastminute.katas

// This can be abstracted for all structure that supports fold
fun <A, B> List<A>.foldMap(m: Monoid<B>, f: (A) -> B): B = this.fold(m.empty()) { acc, curr -> m.combine(acc, f(curr)) }

// This can be abstracted for all structure that supports fold
fun <A> List<A>.combineAll(m: Monoid<A>): A = this.fold(m.empty()) { acc, curr -> m.combine(acc, curr)}