package com.dood.kotlin.basicstuff.classesAndSuch

interface UserBackingField { //User had red lines, since in same module as another interface?  TODO look into this
    val email: String //remember can define props on an interface
    val nickname: String
        get() = email.substringBefore('@') // getter for nickname, interface so no backing field calculated each time get is called
}


/**
 * Kotlin appears to use the getter/setter whenever you access a property, ie User.name = something would invoke the
 * setter.  This can cause recursion gone amok
 */
class UserClassWithBackingField(val name: String) {
    var address: String = "     unspecified" //default value for address property, not part of constructor
        set(value) {
            println(
                """
                Address was changed for $name:
                "$field" -> "$value".""".trimIndent()
            ) //read the backing field, $field is a ref to address's current value in this case
            field = value //sets the backing field to new value, hover over it with intellij
        }
}

fun main() {
    backingFields()
}

private fun backingFields() {
    val user = UserClassWithBackingField("snarp")
    user.address = "this is calling the setter even tho it looks like assignment"
}