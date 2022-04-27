package pacage.service

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service
import pacage.dto.request.ProductDtoRequest
import pacage.dto.response.ProductDtoResponse
import pacage.entity.Product
import pacage.repository.ProductRepository

@Service
class ProductService(private val productRepository: ProductRepository) {
    suspend fun addProduct(product: ProductDtoRequest) {
        withContext(Dispatchers.IO) {
            delay(10000)
            productRepository.save(Product(name = product.name, price = product.price, article = product.article))

        }
    }

    fun getProduct(id: Long): ProductDtoResponse {
        val product = productRepository.findById(id).get()
        return ProductDtoResponse(product.id, product.name, product.price, product.article)
    }
}