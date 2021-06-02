/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package com.example

import java.util.Arrays
import java.util.regex.Pattern

class App {
    val greeting: String
        get() {
            return "Hello world."
        }
}

fun runIntroduction() {
    println(App().greeting)
    println(start())
    println(listOf("a", "b", "c"))
    println(useFoo())
    println("containsEven(listOf(1, 3, 5)) ${containsEven(listOf(1, 3, 5))}")
    println("containsEven(listOf(1, 2, 5)) ${containsEven(listOf(1, 2, 5))}")
    println("""Pattern.matches(getPattern(), "13 JUN 1992") ${Pattern.matches(getPattern(), "13 JUN 1992")}""")
    println(getPeople())

    //Nullable types
    sendMessageToClient(Client(PersonalInfo("mail@example")), "hello world", SimpleMailer())
    sendMessageToClient(Client(PersonalInfo(null)), "hello world", SimpleMailer())
    sendMessageToClient(Client(null), "hello world", SimpleMailer())
    sendMessageToClient(null, "hello world", SimpleMailer())
    sendMessageToClient(Client(PersonalInfo("mail@example")), null, SimpleMailer())

    println("isMale(UserInfo(1)) ${isMale(UserInfo(1))}")
    println("isMale(UserInfo(2)) ${isMale(UserInfo(2))}")
    println("isMale(null) ${isMale(null)}")

    //Smart cast
    println(eval(Num(1)))
    println(eval(Sum(Num(1), Num(2))))
    try {
        println(eval(Minus(Num(1), Num(2))))
    } catch(e: Exception) {
        e.printStackTrace()
    }

    //Extension functions
    println(1.r())
    println(Pair(1, 2).r())

    println(sortList(listOf(1, 3, 2)))
    println(sortList(listOf(3, 1, 2)))
    println(sortListSAM(listOf(3, 1, 2)))
    println(sortListExtensionsCollections(listOf(1, 3, 2)))
}

fun runConventions() {
    println("2020-10-30 > 2019-11.30 ${compare(MyDate(2020, 10, 30), MyDate(2019, 11, 30))}")
    println("2020-10-30 > 2020-11.30 ${compare(MyDate(2020, 10, 30), MyDate(2020, 11, 30))}")

    println("2020-10-30 ${
        if (checkRange(
            MyDate(2020, 10, 30),
            MyDate(2020, 9, 30),
            MyDate(2020, 11, 30)
        )) "in" else "not in" } 2020-9-30 - 2020-11.30 ")

    println("2020-12-30 ${
        if (checkRange(
            MyDate(2020, 12, 30),
            MyDate(2020, 9, 30),
            MyDate(2020, 11, 30)
        )) "in" else "not in" } 2020-9-30 - 2020-11.30 ")

    println("2020-10-30 ${
        if (checkInRange(
            MyDate(2020, 10, 30),
            MyDate(2020, 9, 30),
            MyDate(2020, 11, 30)
        )) "in" else "not in" } 2020-9-30 - 2020-11.30 ")

    println("2020-12-30 ${
        if (checkInRange(
            MyDate(2020, 12, 30),
            MyDate(2020, 9, 30),
            MyDate(2020, 11, 30)
        )) "in" else "not in" } 2020-9-30 - 2020-11.30 ")

    iterateOverDateRange(
            MyDate(2020, 9, 28),
            MyDate(2020, 9, 30),
            { println(it) }
    )

    println(task1(MyDate(2020, 10, 21)))
    println(task2(MyDate(2020, 10, 21)))
    println(isLeapDay(MyDate(2020, 10, 21)))
    println(isLeapDay(MyDate(2020, 2, 29)))

    var invokable = Invokable()
    invokeThrice(invokable)
    println(invokable.numbersOfInvocations)
}

fun runCollections() {
    println(shop.getSetOfCustomers())
    println(shop.getCitiesCustomersAreFrom())
    println(shop.getCustomersFrom(Canberra))
    println(shop.checkAllCustomersAreFrom(Canberra))
    println(shopAtCanberra.checkAllCustomersAreFrom(Canberra))

    println("shopAtCanberra.hasCustomerFrom(Canberra) ${shopAtCanberra.hasCustomerFrom(Canberra)}")
    println("shopAtCanberra.hasCustomerFrom(Tokyo) ${shopAtCanberra.hasCustomerFrom(Tokyo)}")

    println("shop.countCustomersFrom(Tokyo) ${shop.countCustomersFrom(Tokyo)}")
    println("shop.countCustomersFrom(Canberra) ${shop.countCustomersFrom(Canberra)}")

    println("shop.findAnyCustomerFrom(Tokyo) ${shop.findAnyCustomerFrom(Tokyo)}")
    println("shopAtCanberra.findAnyCustomerFrom(Tokyo) ${shopAtCanberra.findAnyCustomerFrom(Tokyo)}")

    println("customerWith3Orders.orderedProducts ${customerWith3Orders.orderedProducts}")
    println("shopAtCanberra.allOrderedProducts ${shopAtCanberra.allOrderedProducts}")

    println(shop.getCustomerWithMaximumNumberOfOrders())
    println(shop.getMostExpensiveOrderedProduct())
    println(shop.getCustomersSortedByNumberOfOrders())
    println(shop.getTotalOrderPrice())
    println(shop.groupCustomersByCity())

    println(shop.getCustomersWithMoreUndeliveredThenDelivered())

    println(shop.getSetOfProductsOrderedByAllCustomer())
    println(customerWith3Orders.getOrderedProducts())
    println(customerWithNoOrders.getOrderedProducts())

    println(findMostExpensiveProductBy(customerWith3Orders))
    println(findMostExpensiveProductBy(customerWithNoOrders))

    println(shop.getNumbersOfTimesProductWasOrdered(idea))
    println(shop.getNumbersOfTimesProductWasOrdered(reSharper))

    println(findMostExpensiveProductBy2(customerWith3Orders))
    println(findMostExpensiveProductBy2(customerWithNoOrders))

    println(shop.getNumbersOfTimesProductWasOrdered2(idea))
    println(shop.getNumbersOfTimesProductWasOrdered2(reSharper))
}

fun main(args: Array<String>) {
    //runIntroduction()
    //runConventions()
    runCollections()
}
