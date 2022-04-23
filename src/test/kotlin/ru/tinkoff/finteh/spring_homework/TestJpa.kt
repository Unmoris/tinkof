package ru.tinkoff.finteh.spring_homework

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.domain.PageRequest
import ru.tinkoff.finteh.spring_homework.entity.Product
import ru.tinkoff.finteh.spring_homework.repository.ProductSpringRepository

@DataJpaTest
class TestJpa {

    @Autowired
    private lateinit var repo: ProductSpringRepository

    @Test
    fun testSave() {
        val product: Product = Product()
        repo.save(product)

        var result =repo.getById(4)

        Assertions.assertEquals(4, result?.id)
    }

    @Test
    fun testGetById() {
        var result = repo.getById(1)

        Assertions.assertEquals("Telephone", result?.name)
    }

    @Test
    fun testSearch() {
        var result = repo.findByNameStartingWith("Tele", PageRequest.of(0, 3))

        Assertions.assertEquals(1, result.size)
    }


}