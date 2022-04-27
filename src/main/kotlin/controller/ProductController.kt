package controller

import MESSAGE_ADD_PRODUCT_SUCCESSFUL
import dto.request.ProductDtoRequest
import dto.response.MessageDtoResponse
import dto.response.ProductDtoResponse
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.springframework.web.bind.annotation.*
import service.ProductService

@RestController
@RequestMapping("/product")
class ProductController(private val productService: ProductService) {

    @PostMapping
    fun addProduct(@RequestBody product: ProductDtoRequest): MessageDtoResponse {
        runBlocking {
            launch {
                productService.addProduct(product)
            }
        }
        return MessageDtoResponse(MESSAGE_ADD_PRODUCT_SUCCESSFUL)
    }

    @GetMapping("/{id}")
    fun getProduct(@PathVariable id: Long): ProductDtoResponse {
        return productService.getProduct(id)
    }
}