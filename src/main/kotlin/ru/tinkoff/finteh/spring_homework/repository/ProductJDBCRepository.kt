package ru.tinkoff.finteh.spring_homework.repository

import org.springframework.context.annotation.Primary
import org.springframework.data.domain.Pageable
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.query
import org.springframework.stereotype.Service
import ru.tinkoff.finteh.spring_homework.entity.Product

@Primary
@Service
class ProductJDBCRepository(private val jdbcTemplate: JdbcTemplate) : ProductRepository {
    override fun getById(id: Long): Product? {
        return jdbcTemplate.query("select * from product where ? = id", id) { rs, _ ->
            Product(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getDouble("price"),
                rs.getInt("article"),
            )
        }[0]
    }

    override fun save(newProduct: Product) {
        jdbcTemplate.update(
            "insert into product(name,price,article) values (?, ?, ?)",
            newProduct.name,
            newProduct.price,
            newProduct.article
        )
    }

    override fun findByNameStartingWith(name: String, pageable: Pageable): List<Product> {
        val securityName: String = name.splitToSequence("").filter { it.isNotEmpty() }.map { "[$it]" }
            .joinToString(separator = "", postfix = "", prefix = "")
        return jdbcTemplate.query(
            "select * from product where name like ?  ORDER BY id DESC LIMIT ? OFFSET ?",
            "$securityName%",
            pageable.pageSize,
            pageable.pageNumber * pageable.pageSize,
        ) { rs, _ ->
            Product(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getDouble("price"),
                rs.getInt("article"),
            )
        }
    }
}