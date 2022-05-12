package ru.tinkoff.finteh.spring_homework.client

import ru.tinkoff.finteh.spring_homework.entity.Event

interface EventTypeClient {

    abstract fun printInfo(event: Event)

}