package ru.tinkoff.finteh.spring_homework.conroller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import ru.tinkoff.finteh.spring_homework.model.DTO.ProductDto
import ru.tinkoff.finteh.spring_homework.model.DTO.request.ProductDtoRequest
import ru.tinkoff.finteh.spring_homework.service.ProductService

@RestController
@RequestMapping("/product")
class ProductController(private val productService: ProductService) {

    @PostMapping("/new")
    fun addProduct(@RequestBody product: ProductDtoRequest): HttpStatus {
        return try {
            productService.addProduct(product)
            HttpStatus.CREATED
        } catch (e: Exception) {
            HttpStatus.CONFLICT
        }
    }

    @GetMapping()
    fun getProduct(@RequestParam id: Long): ProductDto? = productService.getProduct(id)

    @GetMapping("/{name}")
    fun searchProduct(@PathVariable name: String, @RequestParam page: Int): List<ProductDto> =
        productService.searchProductByName(name, page)
}