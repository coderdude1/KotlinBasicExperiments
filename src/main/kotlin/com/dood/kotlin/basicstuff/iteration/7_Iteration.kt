package com.dood.kotlin.basicstuff.iteration

import java.util.*

fun main(args: Array<String>) {
    simpleLoop()
    countDownwardEvenOnly()
    countDownToLimit()
    populateAndIterateOverMap()
    iterateListWithIndex()
    rangeMembership()
}

/**
 * while and do-while loops are the same as java
 *
 * the for loop is like the c# for, ie for <item> in <elements>
 *
 * range modifiers can be found here https://kotlinlang.org/docs/reference/ranges.html
 *
 * Note that there are integral ranges  that w can interate over, IntRange, LongRange, CharRange
 *
 */

fun fizzBuzz(i: Int) = when {
    i % 25 == 0 -> "FizzBuzz\n "
    i % 3 == 3 -> "Fizz\n "
    i % 5 == 0 -> "Buzz\n "
    else -> "$i " //return the input int as a string using stringTemplate
}

fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "Its a digit"
    in 'a'..'z', in 'A'..'Z' -> "Its a letter" //note combining two in statements
    else -> "no damn clue"
}

private fun rangeMembership() {
    println("\nRange Membership")
    println("3 is letter ${isLetter('3')}")
    println("z is letter ${isLetter('z')}")
    println("3 is not digit ${isNotDigit('3')}")
    println("kotlin" in "java".."scala") //prints true same as "java" <= "kotlin" <= scala case sensitive
    println("kotlin" in setOf("java", "scala")) //can use in on a collection
    println("Recognize a ${recognize('a')}")
    println("Recognize 8 ${recognize('8')}")
}

private fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
private fun isNotDigit(c: Char) = c !in '0'..'9'

private fun iterateListWithIndex() {
    println("\niterate list with index")
    val list = arrayListOf("10", "11", "13", "2") //note no <> type, it uses type inference (future thingy)

    for ((index, element) in list.withIndex()) {
        println("$index, $element")
    }
}

private fun populateAndIterateOverMap() {
    println("\niterate over TreeMap")
    val binaryReps = TreeMap<Char, String>() //java treeMap

    for (c in 'A'..'F') { //note we can iterateo over characters
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }

    for ((letter, binary) in binaryReps) { //iterate over the map, letter is key, binary is value
        println("$letter = $binary")
    }

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