package pacage.controller

import ERROR_PRODUCT_NOT_FOUND
import MESSAGE_ADD_PRODUCT_SUCCESSFUL
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import pacage.dto.request.ProductDtoRequest
import pacage.dto.response.MessageDtoResponse
import pacage.dto.response.ProductDtoResponse
import pacage.service.ProductService

@RestController
@RequestMapping("/product")
class ProductController(private val productService: ProductService) {

    @PostMapping
    fun addProduct(@RequestBody product: ProductDtoRequest): ResponseEntity<MessageDtoResponse> {
        CoroutineScope(Dispatchers.Default).launch {
            productService.addProduct(product)
        }
        return ResponseEntity<MessageDtoResponse>(MessageDtoResponse(MESSAGE_ADD_PRODUCT_SUCCESSFUL), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getProduct(@PathVariable id: Long): ResponseEntity<Any> {
        val product: ProductDtoResponse
        return try {
            product = productService.getProduct(id)
            ResponseEntity(product, HttpStatus.OK)
        } catch (e: RuntimeException) {
            ResponseEntity(ERROR_PRODUCT_NOT_FOUND, HttpStatus.NOT_FOUND)
        }

    }
}