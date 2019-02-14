package com.dood.kotlin.basicstuff.lambdas

import com.dood.kotlin.basicstuff.classesAndSuch.UserDataClass

/**
 * really nice blog here https://medium.com/@elye.project/kotlin-slow-list-and-lazy-sequence-61691fc974c5
 *
 * TODO - set up various examples, then add some big collections and compare seqeunce vs non-sequence operations
 */

fun main() {
    veryBasicSequence()
    intermediateOpsAreLazy()
}

/**
 * Since this is a sequence, there is no intermediate staging of stuff between stesps.  This is more like a
 * java 8 stream.
 *
 * Sequences support all of the Collection API operations
 *
 * The more I read it is much like a java 8 stream, ie the result of an intermediate opreation is a sequence, and
 * a terminal opreation returns a result (collection, number, etc. )
 */
private fun veryBasicSequence() {
    val users = listOf(UserDataClass("Snarp", 33, address = null), UserDataClass("horkle", address = null))
    val processedUsers = users.asSequence()
        .map(UserDataClass::name)
        .filter { it.startsWith("h") }
        .toList()
    println("ProcessUsers: $processedUsers")
}

/**
 * This function has prints in each stage to show order of execution between a normal collection processing
 * and a sequence.
 *
 * Note the terminal 'toList' operation causes everything to happen, there is no intermediate collection

map (1) filter(1) map (2) filter(4) map (3) filter(9) map (4) filter(16)
collection processing (nonsequence) Accumulates east step into intermediate collection
map (1) map (2) map (3) map (4) filter(1) filter(4) filter(9) filter(16)

 * note that all operations are applied for each entry in the sequence, ie the first element is mapped then
 * filtered
 */
private fun intermediateOpsAreLazy() {
    println("Usinga a sequence causes Itermediate steps are lazy")
    val showLazySteps = listOf(1, 2, 3, 4).asSequence()
        .map { print("map ($it) "); it * it }
        .filter { print("filter($it) "); it % 2 == 0 }
        .toList()

    println("\ncollection processing (nonsequence) buffers intermediate collections")
    val showNonLazy = listOf(1, 2, 3, 4)
        .map { print("map ($it) "); it * it }
        .filter { print("filter($it) "); it % 2 == 0 }
}