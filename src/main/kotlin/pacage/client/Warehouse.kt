package pacage.client

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import pacage.dto.response.CountDto

@Service
class Warehouse(
    private val webClient: WebClient,
    @Value("\${warehouse.address}") private val warehouseAddress: String
) {

    fun getCountProduct(article: Int?): Int =
        webClient.get().uri("/").retrieve().bodyToMono(CountDto::class.java).block()?.count ?: 0


}