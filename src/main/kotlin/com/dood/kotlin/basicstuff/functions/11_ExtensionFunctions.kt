package com.dood.kotlin.basicstuff.functions

/**
 * Extension functions allow us to add functions/methods to existing code, ie 3rd party libs jdk whatever without modifyig
 * the original code  Kotlin uses this to add a crapton of stuff to teh java collections api as an example.
 *
 * An extension function is simply a function thac can be called as a member of a class, but is defined outside of it
 *
 * you cannot override an extension function
 */

/**
 * The receiver type is the type on which the extension is defined, and the receiver object is the instance of that type
 */
//   ! String is the receiver type
//   !                          ! this is the receiver object
fun String.lastChar(): Char = this.get(this.length - 1)

fun main(args: Array<String>) {
    println("Kotlin".lastChar()) // prints "n" String is the receiver type, and "Kotlin" is the reveiver object

    val listOfNums = listOf(1, 2, 3, 4, 5)
    val listOStrings = listOf("one", "two", "three")
    println(listOfNums.joinToString())
    println(listOStrings.joinToString())
//    listOfNums.join()//compile time error typeMismatch
    println(listOStrings.join())
}

//extension fucntion joinToString added to any collection of type T
fun <T> Collection<T>.joinToString(seperator: String = ", ", prefix: String = "", postfix: String = ""): String {
    val result = StringBuffer(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0)
            result.append(seperator) //don't append seperator on first element
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

//narrow to a more speciifc reciever type, ie only add it to a collection of strings
fun Collection<String>.join(
    seperator: String = ", ",
    prefix: String = "",
    postfix: String = ""
) = joinToString(seperator, prefix, postfix)

