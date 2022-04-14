package ru.tinkoff.finteh.spring_homework.repository

import org.springframework.context.annotation.Primary
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.tinkoff.finteh.spring_homework.entity.Product


@Repository
interface ProductSpringRepository : CrudRepository<Product,Long>,ProductRepository{

    override fun getById(id: Long): Product?

    override fun findByNameStartingWith(name: String, pageable: Pageable): List<Product>

}
