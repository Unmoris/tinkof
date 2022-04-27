package repository

import entity.Product
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : CrudRepository<Product,Long>{
    fun getById(id: Long): Product?
}