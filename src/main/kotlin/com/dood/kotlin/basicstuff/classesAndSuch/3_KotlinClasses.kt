package com.dood.kotlin.basicstuff.classesAndSuch

/**
 * This declares a class called UserClass, that has 3 properties: name (immutable, not nullable),
 * age (mutable, with a default value of 21, and address (mutable, and nullable string).  You get default getters
 * and setters.  In java the val properties are final, and this would be a lot of LOC in java, and a big java
 * constructor with this.name = name, etc.  Note that immutable properties (declared with val) do not get setters
 *
 * One article I read claimed that using default values eliminates the need of the builder pattern with method
 * chaining, as it's not needed in kotlin.  TODO experiment with this hypothesis
 *
 * Kotlin allows positional and named notation when constructing a class instance, but you cannot mix the 2
 */
class UserClass(val name: String, var age: Int = 21, var address: String?)

/**
 * a data class is typically used for DTO's/reponse/request objects.  In addition to default getter/setters it adds
 * a default toString(), equals(), hashcode(), and copy() methods
 */
data class UserDataClass(val name: String, var age: Int = 21, var address: String?)

fun main(args: Array<String>) {
//    val userClass = UserClass("name", age=20) //invalid since no value passed for address (no default value for it)
    val userClassOne = UserClass("name", 20, null) //works (note it's all positional notation not named
//    val userClassOne = UserClass("name", age=20) //invalid since no address (no default value for it)
    println("user name ${userClassOne.address}") //note we call property direct, not getter and this prop is null
    println("userClass before ageChange = ${userClassOne.age}") //note no toString on the userClass
    userClassOne.age = 37
    println("userClass after age change = ${userClassOne.age}")


    val userDataClass = UserDataClass("name", 22, "somewhere in the world")
    val copyUserDataClass = userDataClass.copy()
    println("equals ${userDataClass == copyUserDataClass}") //"equals true"  intellin warns on .equals
    println(userDataClass.toString()) //"UserDataClass(name=name, age=22, address=somewhere in the world)"


}