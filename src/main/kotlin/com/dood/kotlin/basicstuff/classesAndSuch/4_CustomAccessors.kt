package com.dood.kotlin.basicstuff.classesAndSuch

/**
 * declare a class with 2 properties, and add a custom accessor (isSquare) method.  This example uses an accessor
 * (get) vs a function on the class itself.
 */
class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() {
            return height == width
        }
}