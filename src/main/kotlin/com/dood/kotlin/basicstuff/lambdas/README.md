# Lambdas

* [Kotlin Lambdas](https://kotlinlang.org/docs/reference/lambdas.html)
* [medium article on higher order functions and function types](https://medium.com/tompee/idiomatic-kotlin-higher-order-functions-and-function-types-adb59172796)

Some terms from that link
1.  Functions in kotlin are first class citizens, which means they can be treated as data, ie stored in a variable
 passed as a param to another function, returned from a function call, etc
1.  Higher order functions are functions that either accept a function as a param, return a function
or both
1. Function types are similar to java 8 functional interfaces.  (inParams) -> (outParams) = {body}
    1. (Type, OtherType) -> returnType
    1. (Type) -> Unit (ie no return object like void?)