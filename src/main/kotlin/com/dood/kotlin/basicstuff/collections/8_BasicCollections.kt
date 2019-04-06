package com.dood.kotlin.basicstuff.collections

fun main(args: Array<String>) {
    createBasicCollections()
}

/**
 * TODO add mutable vs immutable collections https://kotlinlang.org/docs/reference/collections.html
 *
 * Looks like the listOf, setOf, mapOf return mutable collections
 */
private fun createBasicCollections() {
    //note the add works even tho using a val declration
    val set = hashSetOf("one", "two", "two", "three") //note duplicate "two"
    set.add("four")
    println("create a set $set")
    println("  set is ${set.javaClass}")
    println("  kotlin adds max to set lastElement: ${set.max()}")//these are implemented via extensions to the java collections api

    val list = arrayListOf("one", "two", "two", "three")
    println("  list is ${list.javaClass}")

    list.add("seventeen") //note it is mutable
    println("\ncreate a nutable list $list")
    println("  list is type ${list.javaClass}")
    println("  kotlin adds last to list meaxElement: ${list.last()}") //these are implemented via extensions to the java collections api

    list.add("blah")
    println("added a new element: $list") //note no {}

    list.remove("blah")
    println("removed new value: $list")

    val map = hashMapOf(1 to "one", 7 to "seven", 33 to "88")
    map.put(837, "largh")
    println("\ncreate map $map")
    println("  map is type ${map.javaClass}")

    val mutableList = mutableListOf("one", "two", "two", "three")
    println("  mutableLet is ${mutableList.javaClass}")

    mutableList.add("seventeen")
    println("\ncreate mutableList $mutableList")
    println(" mutableList is type ${mutableList.javaClass}")

    var immutableList = listOf("one", "two", "two", "three")
//    immutableList.add //no add method, the listOf returns a readOnly view
    println("\ncreate immutableList $immutableList")
    println("  \n immutableList is of ${immutableList.javaClass}")
    println(" immutableList is type ${immutableList.javaClass}")
}