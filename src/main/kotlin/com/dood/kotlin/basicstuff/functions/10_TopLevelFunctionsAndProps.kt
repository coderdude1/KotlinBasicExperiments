//package com.dood.kotlin.basicstuff.functions
package strings

//note I overrode the package name so it doesn't match file path.  note intellij warns on this but legit
/**
 * IN java we do a lot of util classes that contain statuc functions and such.  Extra code that is not really needed
 * in kotlin, classes. just create the props/functions, and name the file something that makes sense.  To use it in java
 * you refrecnet the file like a classname (it gets compiled to java bytecode as a staic class/method
 *
 * TODO add the @file.JvnMame stuff
 */


/**
 * TOp level properties are directly importable in kotlin.  in java they show up as a getter method (for val) and a
 * getter/setter method for vars
 */
var doodCount = 0 //top level property
val UNIX_LINE_SEPERATOR = "\n" //crlf

/**
 * In kotlin this can be imorted directly, ie import Strings.joinToString.  In java this shows up as a static class
 * strings.TopLevelFunctionsAndProps.joinToString
 */
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