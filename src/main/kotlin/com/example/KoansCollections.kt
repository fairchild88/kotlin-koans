package com.example

fun Shop.getSetOfCustomers(): Set<Customer> = customers.toSet()

//Filter map
fun Shop.getCitiesCustomersAreFrom(): Set<City> = customers.map{ it.city }.toSet()

fun Shop.getCustomersFrom(city: City): List<Customer> = customers.filter { it.city == city }

//All Any and other predicates
fun Shop.checkAllCustomersAreFrom(city: City): Boolean = customers.all { it.city == city}

fun Shop.hasCustomerFrom(city: City): Boolean = customers.any{ it.city == city }

fun Shop.countCustomersFrom(city: City): Int = customers.count{ it.city == city }

fun Shop.findAnyCustomerFrom(city: City): Customer? = customers.find{ it.city == city }

//FlatMap
val Customer.orderedProducts: Set<Product> get() {
    TODO()
}

val Shop.allOrderedProducts: Set<Product> get() {
    TODO()
}

