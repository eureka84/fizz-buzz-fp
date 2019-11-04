package com.lastminute.katas

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class FizzBuzzTest {

    @Test
    fun `number divisible by 3`() {
        assertThat(fizzBuzz(3), equalTo("Fizz"))
        assertThat(fizzBuzz(6), equalTo("Fizz"))
        assertThat(fizzBuzz(9), equalTo("Fizz"))
    }

    @Test
    fun `number divisible by 5`() {
        assertThat(fizzBuzz(5), equalTo("Buzz"))
        assertThat(fizzBuzz(10), equalTo("Buzz"))
        assertThat(fizzBuzz(20), equalTo("Buzz"))
    }

    @Test
    fun `number divisible by 3 and 5`() {
        assertThat(fizzBuzz(15), equalTo("FizzBuzz"))
        assertThat(fizzBuzz(30), equalTo("FizzBuzz"))
        assertThat(fizzBuzz(45), equalTo("FizzBuzz"))
    }


    @Test
    fun `number not divisible by 3 or 5`() {
        assertThat(fizzBuzz(4), equalTo("4"))
    }
}
