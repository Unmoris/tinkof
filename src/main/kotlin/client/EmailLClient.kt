package ru.tinkoff.finteh.spring_homework.client

import org.springframework.stereotype.Service
import ru.tinkoff.finteh.spring_homework.entity.Event
import ru.tinkoff.finteh.spring_homework.entity.Status
import ru.tinkoff.finteh.spring_homework.repository.EventsRepository

@Service
class EmailLClient(private val repository: EventsRepository) : EventTypeClient {
    override fun printInfo(event: Event) {
        println("EMAIL")
        println(event.body)
        repository.updateStatusByIdIs(Status.DONE, event.id!!)
    }
}