package ru.tinkoff.finteh.spring_homework.repository

import ru.tinkoff.finteh.spring_homework.model.Product

object ProductRepository {
    fun getById(id: Long): Product? = products.find { it.id == id }
    fun searchByName(name: String): List<Product> = products.asSequence().filter { it.name.contains(name,ignoreCase = true) }.toList()
}

var products: MutableList<Product> = mutableListOf<Product>(
    Product(1, "TELEPHONE", 321.0, 423123),
    Product(2, "NOTEBOOK", 432.0, 321421)
)

