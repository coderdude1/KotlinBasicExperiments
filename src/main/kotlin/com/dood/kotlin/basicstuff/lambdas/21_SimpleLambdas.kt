package com.dood.kotlin.basicstuff.lambdas

import com.dood.kotlin.basicstuff.classesAndSuch.UserDataClass

//note you can do this in java too, just requires more code
//(Int) -> (Boolean)
var divisibleByTwo: (Int) -> Boolean = { it % 2 == 0 }
var lessThanTwo: (Int) -> Boolean = { it < 2 }

//note you don't have to specify input type if compiler can infer it
val altLessThanTwo = { x: Int -> x < 2 }

//anonymous function ie no name
val anonFunLessThanTwo = fun(x: Int): Boolean = x < 2

//using an existing function (filter takes a predicate).  figure this out
val stringFilter = String::filter
val stringLength = String::length

val sum = { x: Int, y: Int -> x + y }

fun main(args: Array<String>) {
//    note missing age for the first user, named param for 3rd param
    val users = listOf(
        UserDataClass("Snarple", address = null), UserDataClass("fark", 22, null),
        UserDataClass("Hargh", 3, null)
    )
    findTheOldestPerson(users)
    //lots of examples of it.blah, ie autogenerated param in a lambda  don't use it on nested lambdas
    println("heres a better way: ${users.maxBy { it.age }}")
    //kotlin allows moving the lambda out of an arg list if it is the last arg, note parens
    println("yet another way ${users.maxBy() { u: UserDataClass -> u.age }}")
    //if lambda is only arg, you can remove parens
    println("when the lambda is the only arg to a fun note no parens for maxBy ${users.maxBy { u: UserDataClass -> u.age }}")
    println("when the lambda is the only arg to a fun note no parens for maxBy ${users.maxBy { u: UserDataClass -> u.age }}")
    println("not concise: ${users.maxBy { p: UserDataClass -> p.age }}") //param type explicit
    println("concise: ${users.maxBy { it.age }}") //param type inferred

    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println("evenNumbers ${numbers.filter(divisibleByTwo)}")
    println("less than two: ${numbers.filter(lessThanTwo)}")
    println("altless than two: ${numbers.filter(altLessThanTwo)}")
    println("anonless than two: ${numbers.filter(anonFunLessThanTwo)}")

    println("sum ${sum(1, 3)}")
    passingLambdaAsNamedArg(users)
    val listOfStrings = listOf("400", "403", "501")
    printMessagesWithPrefix(listOfStrings, "prefix")
    printProblemCounts(listOfStrings)
    printMaxUserAgeAndSalute(users)
    boundRefence()
}

private fun passingLambdaAsNamedArg(people: List<UserDataClass>) {
    val names = people.joinToString(
        separator = " ",
        transform = { p: UserDataClass -> p.name }) //uses a named arg, ie transform
    println("names= $names")

    val namesWithLambdaOutsideOfParams =
        people.joinToString(" ") { p: UserDataClass -> p.name } //extract lambda out of parens
    println("lambdaout of params = $namesWithLambdaOutsideOfParams")
}

private fun findTheOldestPerson(people: List<UserDataClass>) {
    println("finding the olderst person the old school loopy way")
    var maxAge = 0
    var theOldest: UserDataClass? = null
    for (user in people) {
        if (user.age > maxAge) {
            maxAge = user.age
            theOldest = user
        }
    }
    println(theOldest)
}

private fun printMessagesWithPrefix(messages: Collection<String>, prefix: String) {
    println("accessing a locally scoped param from inside a lambda")
    messages.forEach {
        println("$prefix $it") //accessing a local scoped var from the lambda
    }
}

//in kotlin you can access non final variables (Unlike java).  you can mutate vars that are declared outside of the lambda but in scope
private fun printProblemCounts(responses: Collection<String>) {
    var clientErrors = 0 //these are 'captured' by the lambda
    var serverErrors = 0
    responses.forEach {
        if (it.startsWith("4")) { //TODO rewrite with a when?
            clientErrors++
        } else if (it.startsWith("5")) {
            serverErrors++
        }
    }
    println("clientErrorCount: $clientErrors serverErrorCounts: $serverErrors")
}

private fun printMaxUserAgeAndSalute(user: Collection<UserDataClass>) {
    val oldestUser = user.maxBy(UserDataClass::age)
    println("Oldest user is $oldestUser")
    run(::salute) //invoke by method reference a top level fun
}

private fun boundRefence() {
    val p = UserDataClass("blarname", 28, null)
    val boundReferenceFunction = p::age //kotlin 1.1 and newer
    println("age is $boundReferenceFunction")
}

private fun salute() = println("salute")