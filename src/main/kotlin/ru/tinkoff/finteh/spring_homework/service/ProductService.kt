package ru.tinkoff.finteh.spring_homework.service

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import ru.tinkoff.finteh.spring_homework.client.Warehouse
import ru.tinkoff.finteh.spring_homework.model.DTO.ProductDto
import ru.tinkoff.finteh.spring_homework.model.Product
import ru.tinkoff.finteh.spring_homework.repository.ProductRepository
import ru.tinkoff.finteh.spring_homework.repository.products

@Service
class ProductService(val warehouse: Warehouse) {
    fun addProduct(product: Product): Boolean {
        return if (!products.contains(product)) {
            products.add(product)
        } else {
            false
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

    fun searchProductByName(name: String, page: Int): List<ProductDto> {
        return ProductRepository.searchByName(name)
            .map { ProductDto(it, warehouse.getCountProduct(it.article).count) }
            .filterIndexed { index, _ -> index < page * COUNT_PRODUCT_ON_ONE_PAGE }
    }
}

const val COUNT_PRODUCT_ON_ONE_PAGE = 3