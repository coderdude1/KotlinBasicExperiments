package com.dood.kotlin.basicstuff.starters

/**
 Kotlin has 4 Integer types (Byte (8 bits), Short (16 bits), Int (32 Bits and default), and Long (64 Bits)),
 2 Floating point type (Float (32 bit) and Double (64 Bit and default)
 Boolean true/false
 Characters (use single quote) and strings (double quote, multiple chars)

 Note that vars/vals are all references, ie the property contains a reference to a value (really an object since kotlin
 does not have primitives)

 This means that all function params are pass by reference
 */

fun main() {
    basicTypes()
    assignment()
    arrays()
}

private fun basicTypes() {
    println("\nbasicTypes")
    var count = 12 //this is an Int by default, and the reference is mutable reference
    val name = "name is a string" //String mutable reference
    val percent = 12.83 //Double and mutable

    println("  count: $count is a ${count.javaClass}")
    println("  count: $name is a ${name.javaClass}")
    println("  count: $percent is a ${percent.javaClass}")
}

private fun assignment() {
    println("\nassignments")
    var a = 5 //intell highlights this since it is not used as a var ie we don't reassign it
    val b = a
    val c = b.toULong() //warning about using t@kotlin:EperientalUsageUnsignedTypes
//    var d : Long = a  //intellij compile error type mismatch mixing Int and Long
    println("  a=$a of type ${a.javaClass}\n  b=$b of type ${b.javaClass}\n  c=$c of type ${c.javaClass}")
}

//an array is a container of content references, s
private fun arrays() {
    //note anArray is immutable reference (can't be changed once assinged due to val), but the array contents are mutable,
//    since they are not the same reference as the anArray, ie anArray points to an array, not the contents
    val anArray = arrayOf(1, 4, 9, 16, 25) //anArray contains a ref to an array, which contains references to each of its content
    println("anArray contains ${anArray.size} elements and is of type ${anArray.javaClass}")
    println("3rd element is ${anArray[3]}")
}