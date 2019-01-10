package com.dood.kotlin.basicstuff.classesAndSuch

/**
 * kotlin by default adds getter/setters for props defined in the primary constructor.  If we want to override that
 * there is a trick called backing fields (used to avoid recursion due to convention of property access calling
 * the getter
 *
 * TODO complete this, add examples of usages of acking fields
 */

class User(val name: String) {
    var address: String = "unspecified"
        set(value: String) {
            println(
                """
                address was changed for $name:
                    "$field" -> $"$value
            """.trimIndent()
            )
        }
}