package ru.tinkoff.finteh.spring_homework.model.dto

import ru.tinkoff.finteh.spring_homework.model.Product

data class ProductDto(
    val id: Long,
    val name: String,
    val price: Double,
    val article: Int,
    val count: Int,
) {
    constructor(product: Product, count: Int) : this(product.id, product.name, product.price, product.article, count)
}