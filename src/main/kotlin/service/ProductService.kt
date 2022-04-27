package service

import dto.request.ProductDtoRequest
import dto.response.ProductDtoResponse
import entity.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import repository.ProductRepository

class ProductService(private val productRepository: ProductRepository) {
    suspend fun addProduct(product: ProductDtoRequest) {
        withContext(Dispatchers.IO) {
            productRepository.save(Product(product))
        }
    }

    fun getProduct(id: Long): ProductDtoResponse {
        val product = productRepository.findById(id).get()
        return ProductDtoResponse(product.id, product.name, product.price, product.article)
    }
}