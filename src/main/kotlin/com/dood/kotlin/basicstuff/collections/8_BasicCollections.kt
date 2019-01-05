package com.dood.kotlin.basicstuff.collections

fun main(args: Array<String>) {
    createBasicCollections()
}

/**
 * TODO add mutable vs immutable collections https://kotlinlang.org/docs/reference/collections.html
 */
private fun createBasicCollections() {
    val set = hashSetOf("one", "two", "two", "three") //note duplicate "two"
    println("create a set $set")
    println("  set is ${set.javaClass}")
    println("  kotlin adds max to set lastElement: ${set.max()}")

    val list = arrayListOf("one", "two", "two", "three")
    println("\ncreate a list $list")
    println("  list is type ${list.javaClass}")
    println("  kotlin adds last to list meaxElement: ${list.last()}")

    list.add("blah")
    println("added a new element: $list") //note no {}

    val map = hashMapOf(1 to "one", 7 to "seven", 33 to "88")
    println("\ncreate map $map")
    println("  map is type ${map.javaClass}")

}