package com.example

import java.util.*

//Hello world
fun start() = "hello world"

//Named arguments
fun joinOptions(options: Collection<String>) = options.joinToString(prefix="[", postfix="]")

//Default arguments
fun foo(name: String, number:Int = 42, toUpperCase: Boolean = false) = 
(if (toUpperCase) name.toUpperCase() else name) + number

fun useFoo() = listOf(
    foo("a"),
    foo("b", number = 1),
    foo("c", toUpperCase = true),
    foo("d", number = 2, toUpperCase = true)
)

//Lambdas
fun containsEven(collection: Collection<Int>): Boolean = collection.any { it % 2 == 0 }

//Strings
val month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"
fun getPattern(): String = """\d{2} ${month} \d{4}"""

//Data Classes
//Data class primary constructor must have only property(val / var) parameters
//data class Person(var name: String, var age: Int)
data class Person(val name: String, val age: Int)
fun getPeople(): List<Person> {
    return listOf(Person("Alice", 29), Person("Bob", 31))
}

//Nullable types
class Client (val personalInfo: PersonalInfo?)
class PersonalInfo(val email: String?)
interface Mailer {
    fun sendMessage(email: String, message: String)
}

class SimpleMailer : Mailer {
    override
    fun sendMessage(email: String, message: String) {
        println("send ${message} to ${email}")
    }
}

data class UserInfo(val userGender:Int)

fun isMale(user: UserInfo?) = user?.userGender ?: 2 == 1

//fun sendMessageToClient(client: Client?, message: String?, mailer: Mailer) {
//    if (client?.personalInfo?.email == null || message == null) {
//        return
//    }
//
//    mailer.sendMessage(client!!.personalInfo!!.email!!, message!!)
//}

fun sendMessageToClient(client: Client?, message: String?, mailer: Mailer) {
    val email = client?.personalInfo?.email

    if (email != null && message != null) {
        mailer.sendMessage(email, message)
    }
}

//Smart casts
fun eval(expr: Expr): Int = 
    when(expr) {
        is Num -> expr.value
        is Sum -> eval(expr.left) + eval(expr.right)
        else -> throw IllegalArgumentException("Unknown expression")
    }

interface Expr
class Num(val value: Int): Expr
class Sum(val left: Expr, val right: Expr): Expr
class Minus(val left: Expr, val right: Expr): Expr

//Extension functions
fun Int.r(): RationalNumber = RationalNumber(this, 1)
fun Pair<Int, Int>.r(): RationalNumber = RationalNumber(first, second)

data class RationalNumber(val numerator: Int, val denominator: Int)

//Object expressions

fun sortList(nums:List<Int>) : List<Int> {
    Collections.sort(nums, object: Comparator<Int> {
        override
        fun compare(o1:Int, o2:Int):Int {
            return o2 - o1
        }
    })
    return nums
}

fun sortListSAM(nums: List<Int>) : List<Int> {
    Collections.sort(nums, { x, y -> y - x })
    return nums
}

//Extension on collections
fun sortListExtensionsCollections(nums: List<Int>): List<Int> {
    return nums.sortedDescending()
}
