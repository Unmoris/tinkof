package ru.tinkoff.finteh.spring_homework.service

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import ru.tinkoff.finteh.spring_homework.client.Warehouse
import ru.tinkoff.finteh.spring_homework.model.dto.ProductDto
import ru.tinkoff.finteh.spring_homework.model.Product
import ru.tinkoff.finteh.spring_homework.repository.ProductRepository
import ru.tinkoff.finteh.spring_homework.repository.products

@Service
class ProductService(val warehouse: Warehouse) {
    fun addProduct(product: Product): HttpStatus {

        return if (!products.contains(product)) {
            if (products.add(product)) {
                HttpStatus.CREATED
            } else
                HttpStatus.BAD_REQUEST
        } else {
            HttpStatus.CONFLICT
        }
    }

    fun getProduct(id: Long): ProductDto? {
        val product = ProductRepository.getById(id)
        return if (product != null) {
            ProductDto(
                product,
                warehouse.getCountProduct(product.article).count
            )
        } else {
            null
        }
    }

    fun searchProductByName(name: String): List<ProductDto> {
        val listProducts = ProductRepository.searchByName(name)
        return listProducts.map { ProductDto(it, warehouse.getCountProduct(it.article).count) }
    }
}