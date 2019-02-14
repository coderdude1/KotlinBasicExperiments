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
    
# Some General observations.
1.  chaining collection operation s can result in intermediate collections being created and 
destroyed (such as map and filter, as by default they both return a list ).  This can affect memory and speed.  It is important to be aweare of basic
order of operations that can make this problem worse.  This is sometimes called eager evaluation results in multiple
 creation of intermediate collections.  note sometimes this can still be performant
    1. example is user.map(User::fullName).filter{it.startsWith("b") will create two intermediate lists
1.  On some operations sequences outperform collection chaining.  This appears to be very
similar to the terminal operation on java 8 streaming.  This is sometimes called lazy collection evaluation
1.  Sequences and collection chaining vary in performance, ie depending on the situation one may outperform the other
wither speed vs memory.  Suquences appear to be a different name for a java 8 collection stream