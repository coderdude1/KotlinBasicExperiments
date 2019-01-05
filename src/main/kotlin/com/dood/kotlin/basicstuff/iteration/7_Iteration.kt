package com.dood.kotlin.basicstuff.iteration

fun main(args: Array<String>) {
    simpleLoop()
    countDownwardEvenOnly()
    countDownToLimit()
}

/**
 * while and do-while loops are the same as java
 *
 * the for loop is like the c# for, ie for <item> in <elements>
 *
 * range modifiers can be found here https://kotlinlang.org/docs/reference/ranges.html
 *
 */

fun fizzBuzz(i: Int) = when {
    i % 25 == 0 -> "FizzBuzz\n "
    i % 3 == 3 -> "Fizz\n "
    i % 5 == 0 -> "Buzz\n "
    else -> "$i " //return the input int as a string using stringTemplate
}

private fun countDownToLimit() {
    println("Count up to but not including the end limit")
    for (i in 1 until 10) { //count up to 10 but not inclding 10
        print(fizzBuzz(i))
    }
}

private fun countDownwardEvenOnly() {
    println("Count Down to by two's")
    for (i in 100 downTo 1 step 2) { //basic for loop couting down by 2s
        print(fizzBuzz(i))
    }
    println()
}

private fun simpleLoop() {
    println("Count up to limit")
    for (i in 1..100) { //here is a basic for loop
        print(fizzBuzz(i))
    }
    println()
}