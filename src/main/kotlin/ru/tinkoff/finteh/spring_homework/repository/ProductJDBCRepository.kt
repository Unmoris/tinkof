package ru.tinkoff.finteh.spring_homework.repository

import jdk.incubator.foreign.MemorySegment
import kotlinx.coroutines.selects.select
import org.hibernate.loader.plan.exec.query.internal.QueryBuildingParametersImpl
import org.springframework.context.annotation.Primary
import org.springframework.data.domain.Pageable
import org.springframework.jdbc.`object`.MappingSqlQuery
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.PreparedStatementSetter
import org.springframework.jdbc.core.SqlParameter
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.query
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import ru.tinkoff.finteh.spring_homework.entity.Product
import java.sql.PreparedStatement
import java.sql.Types
import javax.management.Query
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

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
        return jdbcTemplate.query("select * from product where name like ?", "$securityName%") { rs, rowIndex ->
            if (rowIndex < (pageable.pageNumber) * pageable.pageSize) rs.next()
            if (rowIndex >= (pageable.pageNumber + 1) * pageable.pageSize) rs.close()
            Product(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getDouble("price"),
                rs.getInt("article"),
            )
        }
    }
}