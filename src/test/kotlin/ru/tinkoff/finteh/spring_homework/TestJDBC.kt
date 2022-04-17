package ru.tinkoff.finteh.spring_homework

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.jdbc.core.JdbcTemplate
import ru.tinkoff.finteh.spring_homework.entity.Product
import ru.tinkoff.finteh.spring_homework.repository.ProductJDBCRepository
import javax.sql.DataSource

@JdbcTest
class TestJDBC {
    @Autowired
    private lateinit var ds: DataSource

    @Test
    fun testSave() {
        val product: Product = Product()
        ProductJDBCRepository(JdbcTemplate(ds)).save(product)

        var result = ProductJDBCRepository(JdbcTemplate(ds)).getById(4)

        Assertions.assertEquals(4, result?.id)
    }

    @Test
    fun testGetById() {
        var result = ProductJDBCRepository(JdbcTemplate(ds)).getById(1)

        Assertions.assertEquals("Telephone", result?.name)
    }

    @Test
    fun testSearch() {
        var result = ProductJDBCRepository(JdbcTemplate(ds)).findByNameStartingWith("%t", PageRequest.of(0, 3))

       Assertions.assertEquals(0, result.size)
    }


}