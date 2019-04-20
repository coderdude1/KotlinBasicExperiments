package com.dood.kotlin.basicstuff.functions

fun main(args: Array<String>) {
    println("addNoReturnType 3 + 4 = ${addNoReturnType(3, 4)}")
    println("addReturnType 3 + 4 = ${addReturnType(3, 4)}")
    namedArguments()
    defaultValues()
    anotherWayToSayNoReturnValue()
}

//normal functional body
private fun typeInference() { //important for functions (and not functions
    val bean = ArrayIndexOutOfBoundsException() // type automatically inferred, no new operator unlike java
}

//single expression body, aka expression body, note the =
private fun addNoReturnType(a: Int, b: Int) = a + b //inferred return type note no 'return', expresion body style fun

private fun addReturnType(a: Int, b: Int): Int {  //: Int is return type (outside of paren, before {
    return a + b
}

//note you can't use named args when calling from java
//intellij rename is smart with named params
private fun namedArguments() {
    println("namedArguments")
    val list = arrayListOf("one", "two", "two", "three")
    println("list = $list")
    println(
        "using named params to make arg list clearer ${joinToString(
            list,
            seperator = "__",
            prefix = "*",
            postfix = "#"
        )}"
    )
    println("out of order named params ${joinToString(list, prefix = "&&&", seperator = "-", postfix = "@")}")
}

//this is intended to reduce the number of overloaded methods for different args.  look at java.lang.Thread and it's 8 constructors
//note that when not using named properties, you have to set values for predeisors params, ie prefix requires seperator and collection
private fun defaultValues() { //note this is one way of having no return value, ie nothing between ) and {
    val list = arrayListOf("one", "two", "two", "three")
    println("just the list ${joinToString(list)}")
    println("the list and prefix ${joinToString(list, prefix = "snarp")}")
}

//note this has default values for stuff, nothing is nullable.  This is block body style function
private fun <T> joinToString(
    collection: Collection<T>, seperator: String = ", ",
    prefix: String = "", postfix: String = ""
): String {
    val result = StringBuffer(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0)
            result.append(seperator) //don't append seperator on first element
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

private fun anotherWayToSayNoReturnValue() : Unit {
    println("note the return type 'Unit' means returns nothing or void")
}