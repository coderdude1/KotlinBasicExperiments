package com.dood.kotlin.basicstuff.collections

fun main(args: Array<String>) {
    createBasicCollections()
}

/**
 * TODO add mutable vs immutable collections https://kotlinlang.org/docs/reference/collections.html
 */
private fun createBasicCollections() {
    //note the add works even tho using a val declration
    val set = hashSetOf("one", "two", "two", "three") //note duplicate "two"
    set.add("four")
    println("create a set $set")
    println("  set is ${set.javaClass}")
    println("  kotlin adds max to set lastElement: ${set.max()}")

    val list = arrayListOf("one", "two", "two", "three")
    list.add("seventeen")
    println("\ncreate a list $list")
    println("  list is type ${list.javaClass}")
    println("  kotlin adds last to list meaxElement: ${list.last()}")

    list.add("blah")
    println("added a new element: $list") //note no {}

    val map = hashMapOf(1 to "one", 7 to "seven", 33 to "88")
    map.put(837, "largh")
    println("\ncreate map $map")
    println("  map is type ${map.javaClass}")

    val mutableList = mutableListOf("one", "two", "two", "three")
    mutableList.add("seventeen")
    println("\ncreate mutableList $mutableList")
    println(" mutableList is type ${mutableList.javaClass}")

    var immutableList = listOf("one", "two", "two", "three")
//    immutableList.add //no add method, the listOf returns a readOnly view
    println("\ncreate immutableList $immutableList")
    println(" immutableList is type ${immutableList.javaClass}")
}