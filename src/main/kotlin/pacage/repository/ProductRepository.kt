package pacage.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import pacage.entity.Product

@Repository
interface ProductRepository : CrudRepository<Product,Long>{
}