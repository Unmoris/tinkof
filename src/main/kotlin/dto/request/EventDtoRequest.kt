package ru.tinkoff.finteh.spring_homework.dto.request

import ru.tinkoff.finteh.spring_homework.entity.Type

data class EventDtoRequest(
    val body: String,
    val type: Type
)
