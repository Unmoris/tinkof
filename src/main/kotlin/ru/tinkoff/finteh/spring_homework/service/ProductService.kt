package ru.tinkoff.finteh.spring_homework.service

import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException
import ru.tinkoff.finteh.spring_homework.client.Warehouse
import ru.tinkoff.finteh.spring_homework.model.DTO.ProductDto
import ru.tinkoff.finteh.spring_homework.model.DTO.request.ProductDtoRequest
import ru.tinkoff.finteh.spring_homework.repository.ProductRepository
import ru.tinkoff.finteh.spring_homework.repository.ProductSpringRepository

@Service
class ProductService(val warehouse: Warehouse, val productRepo: ProductRepository) {

    fun addProduct(product: ProductDtoRequest) {
        productRepo.save(
            ru.tinkoff.finteh.spring_homework.entity.Product(
                name = product.name,
                price = product.price,
                article = product.article
            )
        )
    }

    fun getProduct(id: Long): ProductDto? {
        val product = productRepo.getById(id)
        return if (product != null) {
            ProductDto(
                id = product.id,
                name = product.name,
                price = product.price,
                article = product.article,
                count = warehouse.getCountProduct(product.article).count
            )
        } else null
    }

    fun searchProductByName(name: String, page: Int): List<ProductDto> {
        return productRepo.findByNameStartingWith(name, PageRequest.of(page, COUNT_PRODUCT_ON_ONE_PAGE))
            .map {
                ProductDto(
                    it,
                    warehouse.getCountProduct(it.article).count
                )
            }
    }
}

const val COUNT_PRODUCT_ON_ONE_PAGE = 3