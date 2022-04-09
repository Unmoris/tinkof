package ru.tinkoff.finteh.spring_homework


import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import ru.tinkoff.finteh.spring_homework.client.Warehouse
import ru.tinkoff.finteh.spring_homework.model.DTO.CountDto
import ru.tinkoff.finteh.spring_homework.model.DTO.ProductDto
import ru.tinkoff.finteh.spring_homework.model.Product
import ru.tinkoff.finteh.spring_homework.service.ProductService


class ProductTest {


    private val warehouse: Warehouse = mockk()
    private val productService: ProductService = ProductService(warehouse)

    @BeforeEach
    fun mockkCreate() {
        every { warehouse.getCountProduct(any()) } returns CountDto(0)
    }

    @AfterEach
    fun mockClear() {
        clearAllMocks()
    }

    @Test
    fun addProduct() {
        val newProduct = Product(Long.MAX_VALUE, "IDEA", 321.0, 321432)

        Assertions.assertEquals(productService.addProduct(newProduct), true)
    }

    @Test
    fun badAddProduct() {

        val newProduct = Product(1, "IDEA", 321.0, 321432)
        productService.addProduct(newProduct)

        Assertions.assertEquals(productService.addProduct(newProduct), false)
    }

    @Test
    fun getProduct() {
        val newProduct = Product(5, "IDEA", 321.0, 321432)

        productService.addProduct(newProduct)

        Assertions.assertEquals(productService.getProduct(5), ProductDto(newProduct, 0))
    }

    @Test
    fun badGetProduct() {
        Assertions.assertEquals(productService.getProduct(5), null)
    }


    @Test
    fun searchProduct() {

        val productExist = ProductDto(id = 1, name = "TELEPHONE", price = 321.0, article = 423123, count = 0)

        val searchProduct = productService.searchProductByName("TELE",1)[0]

        Assertions.assertEquals(searchProduct, productExist)
    }

    @Test
    fun badSearchProduct() {

        val searchProduct = productService.searchProductByName("asdadsads",1)

        Assertions.assertEquals(searchProduct, listOf<ProductDto>())
    }


}
