package com.dood.kotlin.basicstuff.nullsafety

/**
 * Several things going on here.  kotlin classes have a primary constructor which defines the properties at the same time
 * and by default are not nullable.  you can declare a property nullable by adding a ? after the type definition.
 *
 * the var means it is a mutable property (vs a val, which is not mutable after setting it).  followed by the property
 * name and : type
 *
 * you automatically get getters and setters.  data classes add more (discuss later)
 *
 * note two class defs in a kotlin file.  also note how not verbose these things are.  future experiment
 */
class User(var name: String) //declare a class witha single mutable, non-null property
class UserNullable(var name: String?) //class with a single mutable, nullable property

fun main(args: Array<String>) {
    //note the return of two things, this is using a kotlin Pair and I think destructuring.  intellij extract to func did this
    val (userNullableNullName, userNullableWithName) = nullSafeOperator() //note double return, this is a Pair that is native to kotlin

    letOperatorExamples(userNullableNullName, userNullableWithName)
}

private fun letOperatorExamples(userNullableNullName: UserNullable, userNullableWithName: UserNullable) {
    println("\n******* Let operator *********")
    printUsingTheLetOperator(null)  //does not print anything, blocked by the let operator
    printUsingTheLetOperator(userNullableNullName) //'username length is null'
    printUsingTheLetOperator(userNullableWithName) //'username length is 6'
}

private fun nullSafeOperator(): Pair<UserNullable, UserNullable> { //returns a pair
    println("********* null safe operator examples ********")
    val userNullableNullName = UserNullable(null)
    printUserNameNullSafe(userNullableNullName) //'username length is null'

    val userNullableWithName = UserNullable("blargh") //'username length is 6'
    printUserNameNullSafe(userNullableWithName)
    return Pair(userNullableNullName, userNullableWithName) //note Pair is native in kotlin
}

/**
 * Note this function is declared outside of a class.  It uses the safe call operator (?) that prevents an NPE if the
 * property with the ? is null, ie name?.  If name is null it won't throw an NPE but just return null.
 * it shows the usage of the a string template too
 */
fun printUserNameNullSafe(user: UserNullable) { //accepts a UserNullable, no nulls are allowed
    println("username length is ${user.name?.length}") //prints the lenght if name is not null, otherwise prints 'null'
}

/**
 * the let operator will 'let' the closer get called if the user is not null
 */
fun printUsingTheLetOperator(user: UserNullable?) {
    user?.let { printUserNameNullSafe(user) }
}