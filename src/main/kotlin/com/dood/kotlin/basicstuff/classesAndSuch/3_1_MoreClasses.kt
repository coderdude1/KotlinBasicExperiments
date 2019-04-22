package com.dood.kotlin.basicstuff.classesAndSuch

/*
    /critterType should be an enum.  Note there is no default toString (see useAClass)

    Note you can declare the primary constructor without val/var, then you need to assign the
    instance props from the constructor props like java
 */
class Critter(val name: String, var weightInKilos: Int, val critterType: String) {
    fun annoyNeighbors() = println("snark snark snark")
}

fun main() {
    useAClass()
}

//verify what scope this is. private, vs nothing vs what?
private fun useAClass() {
    val critter = Critter("harzlepuff", 22, "miniDragon") //critter is a reference to a new Critter
    println("critter: $critter makes ${critter.annoyNeighbors()}")
    println("critter name is ${critter.name}")
    println("critter original weight is ${critter.weightInKilos}")
    critter.weightInKilos = 33 //it's a var we can reassign it
    println("critter new weight is ${critter.weightInKilos}")
}
