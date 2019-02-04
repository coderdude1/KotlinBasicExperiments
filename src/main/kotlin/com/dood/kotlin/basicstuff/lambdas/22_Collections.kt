package com.dood.kotlin.basicstuff.lambdas

import com.dood.kotlin.basicstuff.classesAndSuch.UserDataClass

/**
 * There are a TON of functions on collectiosn, this demos just a couple
 * check here https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/index.html
 */
val listONums = listOf(1, 2, 3, 4, 5, 6)

val listOPeople = listOf(
    UserDataClass("Alice", 31, null), UserDataClass("Blob", 20, null),
    UserDataClass("OldFart", 53, null), UserDataClass("Boro", 20, null)
)

val books = listOf(
    Book("Thursday Next", listOf("jasper Fforde")),
    Book("Mort", listOf("Terry Pratchett")),
    Book("Good Omens", listOf("Terry Pratchett", "Neil Gaiman"))
)

fun main(args: Array<String>) {
    simpleFiltering()
    simpleMap()
    predicatesOnCollections()
    groupBy()
    flatStuff()
}

private fun simpleFiltering() {
    println("\nsimple filtering")
    println("even numbers: ${listONums.filter { it % 2 == 0 }}")

    println("users older than 30 ${listOPeople.filter { it.age > 30 }}")
}

private fun simpleMap() {
    println("\nsimpleMaps")
    val listONums = listOf(1, 2, 3, 4, 5, 6)
    println("squares are : ${listONums.map { it * it }}")
    println("name using method ref: ${listOPeople.map(UserDataClass::name)}") //note could just use the prop ref (get) but this shows map

    println("names over 30: ${listOPeople.filter { it.age > 30 }.map(UserDataClass::name)}")

    val numbers = mapOf(0 to "zero", 1 to "one")
    println(numbers.mapValues { it.value.toUpperCase() })
}

private fun predicatesOnCollections() {
    println("\npredicateOnCollections")
    val canBeInClub27 = { p: UserDataClass -> p.age <= 27 }
    val users = listOf(UserDataClass("Snarp", 33, address = null), UserDataClass("horkle", address = null))
    println("can all enter: ${users.all(canBeInClub27)}")
    println("can any enter: ${users.any(canBeInClub27)}")

    //conventions with !
    println("uses a ! operator which can be easy to miss ${!listONums.all { it == 3 }}") //not all == 3
    println("this can be a bit more clear ${listONums.any { it != 3 }}")

    //note count() can be more efficiant tha size (ie filter a list then size() marshals a temp collection, count does not
    println("use find: ${users.find(canBeInClub27)}")
}

//convert a list to a map of lists (keyed by groupBy)
private fun groupBy() {
    println("\ngroup by age: ${listOPeople.groupBy { it.age }}")
    val listOfStrings = listOf("a", "ab", "b")
    println("stringlength group: ${listOfStrings.groupBy(stringLength)}")
    println("first char group: ${listOfStrings.groupBy(String::first)}")
}

/**
 * flatMap transforms/maps each element to a collection according to the function passed in.  then it combines (or flattens)
 * all of the lists into a single list
 */
private fun flatStuff() {
    println("\nflat stuff")
    val strings = listOf("abc", "def")
    println("Flatten: ${strings.flatMap { it.toList() }}") //String.toList returns a list of all the chars

    //flatmap returns a list of all compbined authors, toSet uniquifys it
    println("book authors (unique): ${books.flatMap { it.authors }.toSet()}") //flatten the author collection for each book into a list, which converts to a Set

    val listOfList = listOf(listOf("abc", "def"), listOf("xyx", "yyz"))
    println("shortucut flatten list of lists ${listOfList.flatten()}")
}

class Book(val title: String, val authors: List<String>)
