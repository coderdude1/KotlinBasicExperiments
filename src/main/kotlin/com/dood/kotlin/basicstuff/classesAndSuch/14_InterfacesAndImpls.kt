package com.dood.kotlin.basicstuff.classesAndSuch

interface Clickable {
    fun click()
    fun showOff() = println("this is the default impl")
}

class Button : Clickable {
    override fun click() =
        println("I was clicked") //override is required when overriding a superclass or interface method
}

fun main(args: Array<String>) {
    Button().click()
    Button().showOff()
}

//TODO add properties to an interface
