package com.dood.kotlin.basicstuff.classesAndSuch

interface Expr
//the : Expr means that num implements Expr
class Num(val value: Int) : Expr

class Sum(val left: Expr, val right: Expr) : Expr

fun evalWithLogging(e: Expr): Int =
    when (e) {
        is Num -> { //branch in when statement
            println("num: ${e.value}") //this is a smartCast, autocast to Num due to is Num
            e.value //this is an implied return as it is last statement in this block
        }
        is Sum -> { //branch in when statement
            val left = evalWithLogging(e.left) //recurse
            val right = evalWithLogging(e.right)
            println("sum: $left + $right")
            left + right
        }
        else -> throw IllegalArgumentException("Unknown expression")
    }

fun main(args: Array<String>) {
    println(evalWithLogging(Sum(Sum(Num(1), Num(2)), Num(4))))
}