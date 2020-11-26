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
    return orders.flatMap{ it.products }.toSet()
}

val Shop.allOrderedProducts: Set<Product> get() {
    return customers.flatMap{ it.orderedProducts.toList() }.toSet()
}

//Max min
fun Shop.getCustomerWithMaximumNumberOfOrders(): Customer? = customers.maxBy{ it.orders.size }

fun Shop.getMostExpensiveOrderedProduct(): Product? = allOrderedProducts.maxBy{ it.price }

//Sort
fun Shop.getCustomersSortedByNumberOfOrders(): List<Customer> = customers.sortedBy{ it.orders.size }

//Sum
fun Shop.getTotalOrderPrice(): Double = orderedProducts.sumByDouble{ it.price }

//Group by
fun Shop.groupCustomersByCity(): Map<City, List<Customer>> = customers.groupBy{ it.city }

//Partition
fun Shop.getCustomersWithMoreUndeliveredThenDelivered():Set<Customer> = customers.partition {
		val (deliveredOrders, undeliveredOrders) = it.orders.partition { it.isDelivered }
    deliveredOrders.size < undeliveredOrders.size
}.first.toSet()
