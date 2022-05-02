package pacage.service

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service
import pacage.client.Warehouse
import pacage.dto.response.ProductDtoResponse
import pacage.dto.response.request.ProductDtoRequest
import pacage.entity.Product
import pacage.repository.ProductRepository

@Service
class ProductService(private val productRepository: ProductRepository, private val warehouse: Warehouse) {
    suspend fun addProduct(product: ProductDtoRequest) {
        withContext(Dispatchers.IO) {
            delay(10000)
            productRepository.save(
                Product(
                    name = product.name,
                    price = product.price,
                    article = product.article,
                    count = warehouse.getCountProduct(product.article)
                )
            )
        }
    }

    fun getProduct(id: Long): ProductDtoResponse {
        val product = productRepository.findById(id).get()
        return ProductDtoResponse(product.id, product.name, product.price, product.article)
    }
}