package entity

import dto.request.ProductDtoRequest
import javax.persistence.*

@Table(name = "product")
@Entity
class Product(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null,
    @Column(name = "name")
    var name: String? = null,
    @Column(name = "price")
    var price: Double? = null,
    @Column(name = "article")
    var article: Int? = null,
)
{
    constructor(productDtoRequest: ProductDtoRequest) : this() {
        name = productDtoRequest.name
        price = productDtoRequest.price
        article = productDtoRequest.article
    }
}