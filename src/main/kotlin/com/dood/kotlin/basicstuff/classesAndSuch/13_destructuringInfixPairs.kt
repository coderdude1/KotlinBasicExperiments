package com.dood.kotlin.basicstuff.classesAndSuch

/**
 * TODO add this might change the prefix
 * note that these appear to be positional, ie tied to the constructor
 *
 * https://kotlinlang.org/docs/reference/multi-declarations.html
 *
 * returining Pairs, infix calls destructuring, spread operator, etc
 */

fun main(args: Array<String>) {

}

private fun infixOperator() {
    //to is invoking the infix operator.  this is a fun between two values, it returns a Pair
    // 1 to("one") is same as 1 to "one"
    val map = mapOf(1 to "one", 7 to "seven", 43 to "forty three")

    //make a function support infix
    //infix fun Any.to(other: Any) = Pair(this, other) //look at how this maps to above

    val (number, name) = 1 to "one" //destructing to set two vals at once
}