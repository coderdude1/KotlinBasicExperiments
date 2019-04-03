package com.dood.kotlin.basicstuff.nullsafety

/**
 * types without a ? are not allowed to be null.  ie everything is nonnull by default.  you need to
 * explicitly allow nullable types
 */

fun main() {
    printAllCaps("this is a small string") //prints all capps
    printAllCaps(null) //prints null
    basicSafeCalls()
    elvisOperatorAkaNullCoalescingOperator("this is not null")
    elvisOperatorAkaNullCoalescingOperator(null)
    usingTheLetFUuction()
    bangBangOperator()
}

//this is invalid since s is nullable, can't call it without a null check
//fun strLenSafe(s: String?) = s.length

fun strLenSafe(s: String?) = {
    if (s != null) s.length else 0 //valid since we do a null check.  intellj wanrs should replace with elvis
}

fun printAllCaps(s: String?)  { //? means s is nullable string
    val allCaps: String? = s?.toUpperCase() //s? is safeCallOperator
    println(allCaps)
}

/*
example of compile time null checks.  commented out to prevent the errors from breaking this file
val x: String? = null
var y: String = x  //invalid y is not nullable
 */

/**
 * Some other intersting links on run, let, also and apply
     * https://medium.com/@elye.project/mastering-kotlin-standard-functions-run-with-let-also-and-apply-9cd334b0ef84
     * https://android.jlelse.eu/lets-talk-about-kotlin-s-let-extension-function-5911213cf8b9
     * https://www.baeldung.com/kotlin-null-safety
 */
//safe calls to access nullable properits of a class
data class Person(val country: Country?)

data class Country(val code: String?)

private fun basicSafeCalls() {
    println("\nbasic safe calls")
    val p: Person? = Person(Country("ENG")) //p s nullable Person
    val res = p?.country?.code //if p or country is null, it returns null vs an NOE.  chainnig safecall operator
    println("not null res: $res")

    var nullableThing = Person(null) //intellij warns that can be val since not reassigned
    //nullableThing doesn't need the safe call since it is not null (we create it on the line above), country can be null tho thus the ?
    val nullCountryCode = nullableThing.country?.code //intellij warns if you do not use safecalls since it is nullable
    println("null country ${nullableThing.country}")
    println("null country code $nullCountryCode")

//    nullableThing = null //not valid since it has been declared of type Person
}

//variant of safe call operator, if input is null return a value vs returning null (rather than NPE).  It's a tldr
//if else block
private fun elvisOperatorAkaNullCoalescingOperator(nullableString: String?) {
    val nullSafeValue: String = nullableString ?: "I AM NULL!!!"
    println("string t is $nullSafeValue")
}

val someString: String? = "blah blah blah"
val king: Person? = Person(null)
val queen: Person? = null

/**
 * Let appears to offer a type of threadsafety, ie if a value can be mutated externally between the nullcheck
 * and the null risky operation.  it's a safe block
 */
private fun usingTheLetFUuction() {
    someString?.let {
        println("somestring $it") //somestring is declared exteranl scope, and can be modified by another thread/fun.  Not sure how it locks?
    }
    king?.let { println("king of ${it.country}") }
    queen?.let{println("queen of: $it")} //not printed

    val someThings = listOf("one", "Two", null) //note the list can contain null values!
    for ((index, thing) in someThings.withIndex()) {
        thing?.let { println("$index: $it") }
        println("Index: $index")  //prints Index:2 when let blocks null value
    }
}

//From what I read, this is a bad smell.  typically no need for it
private fun bangBangOperator() {
    var x = queen!!.country
    println("did not get here since !! throws NPE $x")
}