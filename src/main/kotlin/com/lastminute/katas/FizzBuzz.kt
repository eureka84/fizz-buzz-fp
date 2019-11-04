package com.lastminute.katas

fun fizzBuzz(number: Int): String {

    var res = ""

    if (number % 3 == 0) {
        res += "Fizz"
    }

    if (number % 5 == 0) {
        res += "Buzz"
    }

    return if (res == "") {
        number.toString()
    } else {
        res
    }

}
