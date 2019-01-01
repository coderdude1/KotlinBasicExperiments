package com.dood.kotlin.basicstuff.classesAndSuch

/**
 * note the use of enum color for a enum
 */
enum class SimpleColor {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

//note the primary constructor
enum class ColorWithProps(
    val r: Int, val g: Int, val b: Int //declare some properties for this enum
) { //this is the body of the enum
    RED(255, 0, 0), ORANGE(255, 165, 0), YELLOW(255, 255, 0),
    GREEN(0, 255, 0), BLUE(0, 0, 255), INDIGO(75, 0, 130),
    VIOLET(238, 130, 238); //semicolon required

    fun rgb() = (r * 256 + g) * 256 + b //adding a function to the enum expression body style

    fun getMnemonic(color: ColorWithProps) =
        when (color) {
            RED -> "Richard"
            ORANGE -> "Of"
            YELLOW -> "York"
            GREEN -> "Gave"
            BLUE -> "Battle"
            INDIGO -> "In"
            VIOLET -> "Vain"
        }

    /**
     * Note creating a set for each invocation is not efficient, but this still is a good example
     */
    fun mix(c1: ColorWithProps, c2: ColorWithProps) =
        when (setOf(c1, c2)) {
            setOf(RED, YELLOW) -> ORANGE
            setOf(YELLOW, BLUE) -> GREEN
            setOf(BLUE, VIOLET) -> INDIGO
            else -> throw Exception("Blargh")
        }
}

fun main(args: Array<String>) {
    println("RGB BLUE: ${ColorWithProps.BLUE.rgb()}") //"RBG BLUE: 255"
    println("Mnemonic for blue: ${ColorWithProps.BLUE.getMnemonic(ColorWithProps.BLUE)}") //"Mnemonic for blue: Battle"
}