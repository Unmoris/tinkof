package ru.tinkoff.finteh.spring_homework.client

import org.springframework.stereotype.Service
import ru.tinkoff.finteh.spring_homework.entity.Event
import ru.tinkoff.finteh.spring_homework.entity.Status
import ru.tinkoff.finteh.spring_homework.repository.EventsRepository

@Service
class PushClient(private val repository: EventsRepository) : EventTypeClient {
    override fun printInfo(event: Event) {
        println("PUSH")
        println(event.body)
        repository.updateStatusByIdIs(Status.DONE, event.id!!)
    }
}