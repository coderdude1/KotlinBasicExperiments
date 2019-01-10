package com.dood.kotlin.basicstuff.classesAndSuch

/**
 * Kotlin enforces Joshua Bloch 'Effective Java' reccomendation "design and document for inheritance or else prohibit it".
 * This is to identify the 'fragile class problem', when modifications of a baseclass can cause incorrect behavior of
 * subclasses because the changes to the parent no longer support the assumptions of the chidldren
 *
 * Pg 71 Kotlin in action
 *
 * Kotlin classes and methods are Final by default
 * visibility is public by default
 *
 * https://kotlinlang.org/docs/reference/visibility-modifiers.html
 * kotlin visiblity mods are
 *          public (default) visible everywhere in for class members, top level items are visible everyhere
 *          internal (classes members are visible within a module), top level members are visible in the module
 *          protected (visiblie in subclasses) - top level members do not have this
 *          private visible in the class its defined; top level members are visible in the file it's defined
 */

open class RichButton : Clickable { //class is open (since it implements an inteface)
    fun disable() {} //this function is final  you can't override it in a subclass
    open fun animate() {} //is open, can be overridden by subclasses
    override fun click() {} //overrides an open fun and is open as a result for being overridde
}

open class RichButtonTwo : Clickable {
    final override fun click() {} //orverrides an open fun, but is closed for subclasse overriding it, so not redundant in this case
}

abstract class Animated {
    abstract fun animate() //abstract fun, subclass must override
    open fun stopAnimating() {}//open for subclass override, concrete fun
    fun animateTwice() {} //cloased for
}

/**
TODO - nested classes
Sealed classes
 */