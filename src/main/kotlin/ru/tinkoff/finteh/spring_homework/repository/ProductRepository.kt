package ru.tinkoff.finteh.spring_homework.repository

import org.springframework.data.domain.Pageable
import ru.tinkoff.finteh.spring_homework.entity.Product

interface ProductRepository {
    fun save(newProduct: Product)
    fun getById(id: Long): Product?
    fun findByNameStartingWith(name: String, pageable: Pageable): List<Product>

}