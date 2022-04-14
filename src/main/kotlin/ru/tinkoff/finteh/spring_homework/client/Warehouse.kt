package ru.tinkoff.finteh.spring_homework.client

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject
import ru.tinkoff.finteh.spring_homework.model.DTO.CountDto

@Service
class Warehouse(val restTemplate: RestTemplate, @Value("\${warehouse.address}") private val warehouseAddress: String) {

    fun getCountProduct(article: Int?): CountDto = CountDto(0)
      //  restTemplate.getForObject("$warehouseAddress/{article}", article.toString())
}

