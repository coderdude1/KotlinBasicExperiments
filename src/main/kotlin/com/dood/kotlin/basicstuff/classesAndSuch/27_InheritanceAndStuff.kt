package com.dood.kotlin.basicstuff.classesAndSuch

//by default classes cannot be extended unless it is open.  same for properties
//open and abstract are redundant
open class Beverage(var color: String) {
    open var maxSize = 12
    var currentSize = 0
    open val name = "Generic Beverage"
    val empty = false  //not overridable in subclasses

    open fun drink() : String {
//        println("glug glug")  //originale
        return "glug glug"
    }

    fun refill() {
        currentSize = maxSize
    }

    //intellij generated this alt-insert
    override fun toString(): String {
        return "Beverage(color='$color', maxSize=$maxSize, currentSize=$currentSize, name='$name', empty=$empty)"
    }

}

//extending a class.  if the parent class has a primary constructor, the subclass have the same as an inut, and call that
//for the super, ie colorParam
//note you can override a val in the parent and make it a var in the subcliass.  not the other way (comile time error)
//overriden fun or props must remain open, unless it' declared final
class Beer(var colorParam: String): Beverage(colorParam) {
    override var maxSize = 24  //override the parent maxSize property and change it's value
    override val name = "Beer"
        get() = field.toUpperCase() //override default getter with custom getter, using the backing field of name

    init { //alternate way of setting parent values instead of override
        currentSize = 18
    }

//    rules for overriding functions
    //fun params in the overrider must match tue super class fun
    //return type must be same as parent, or a subtype
    override fun drink(): String {
        return super.drink()
    }

    //not overriding results in teh bevereage toString getting called.
    override fun toString(): String {
        return "Beer(colorParam='$colorParam', maxSize=$maxSize)" + super.toString() //I added the super.tostring otherwise
    }


}

class WifesWine(var colorParam: String) : Beverage(colorParam) {

}

fun main() {
    val genericBeverage = Beverage("red")
    println("new $genericBeverage")
    println("drnink: ${genericBeverage.drink()}")

    val beer = Beer("amber")
    println("beer: $beer")
    println("name: ${beer.name}")

    beer.currentSize = 2
    println("currentBeeerSize: ${beer.currentSize}")

    beer.refill()
    println("refiled: ${beer.currentSize}")
    println("gonna drink!  $beer.drink()")
}