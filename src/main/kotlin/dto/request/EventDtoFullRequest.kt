package ru.tinkoff.finteh.spring_homework.dto.request

import ru.tinkoff.finteh.spring_homework.entity.Status
import ru.tinkoff.finteh.spring_homework.entity.Type

data class EventDtoFullRequest(
    val id:Long,
    val body: String,
    val type: Type,
    val status: Status
)
