package com.example

import java.util.Calendar

import com.example.TimeInterval.* //like java static import

enum class TimeInterval { DAY, WEEK, YEAR }

data class TimeIntervalTimes(val timeInterval: TimeInterval, val times: Int)

operator fun TimeInterval.times(times:Int) = TimeIntervalTimes(this, times)

//Comparison
data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {

//    override
//    fun compareTo(other: MyDate):Int {
//        if( year == other.year) {
//            if(month == other.month) {
//                return dayOfMonth - other.dayOfMonth
//            } else {
//                return month - other.month
//            }
//        } else {
//            return year - other.year
//        }
//    }

     override
     fun compareTo(other: MyDate):Int = when {
         year != other.year -> year - other.year
         month != other.month -> month - other.month
         else -> dayOfMonth - other.dayOfMonth
     }

     override
     fun toString() = "${year}-${month}-${dayOfMonth}"
}

fun MyDate.nextDay() = addTimeIntervals(TimeInterval.DAY, 1)


fun MyDate.addTimeIntervals(timeInterval: TimeInterval, number: Int): MyDate {
    val c = Calendar.getInstance()
    c.set(year, month, dayOfMonth)
    when(timeInterval) {
        DAY -> c.add(Calendar.DAY_OF_MONTH, number)
        WEEK -> c.add(Calendar.WEEK_OF_MONTH, number)
        YEAR -> c.add(Calendar.YEAR, number)
    }
    return MyDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH))
}

fun compare(d1: MyDate, d2: MyDate) = d1 < d2

//Range
class DateRange(override val start:MyDate, override val endInclusive:MyDate): ClosedRange<MyDate>, Iterator<MyDate>{
    var curDate = start

    override
    operator //*
    fun contains(value: MyDate) = value >= start && value < endInclusive

    override
    operator
    fun hasNext() = curDate < endInclusive

    override
    operator
    fun next() : MyDate {
        curDate = curDate.nextDay()
        return curDate
    }
}

fun checkRange(d1: MyDate, start: MyDate, endInclusive:MyDate) = d1 in DateRange(start, endInclusive)

//Range to
operator fun MyDate.rangeTo(other: MyDate) = DateRange(this, other)

fun checkInRange(d: MyDate, first: MyDate, last: MyDate) = d in first..last

//For loop
fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for(date in firstDate..secondDate) {
        handler(date)
    }
}

//Operator overloading
operator fun MyDate.plus(timeInterval: TimeInterval) = addTimeIntervals(timeInterval, 1)

operator fun MyDate.plus(timeIntervalTimes: TimeIntervalTimes) = addTimeIntervals(timeIntervalTimes.timeInterval, timeIntervalTimes.times)

fun task1(date:MyDate) = date + YEAR + WEEK

fun task2(today:MyDate) = today + YEAR * 2  + WEEK * 3 + DAY * 10

//Destructuring declarations
fun isLeapDay(date:MyDate): Boolean {
    val (year, month, dayOfMonth) = date
    return year % 4 == 0 && month == 2 && dayOfMonth == 29 
}

//Invoke
class Invokable {
    var numbersOfInvocations: Int = 0
        private set
    operator fun invoke(): Invokable {
        numbersOfInvocations++
        return this
    }
}

fun invokeThrice(invokable: Invokable) = invokable()()()
