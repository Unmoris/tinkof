package ru.tinkoff.finteh.spring_homework.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jms.core.JmsTemplate
import org.springframework.stereotype.Service
import ru.tinkoff.finteh.spring_homework.configuration.NAME_QUEUE
import ru.tinkoff.finteh.spring_homework.dto.request.EventDtoRequest
import ru.tinkoff.finteh.spring_homework.entity.Event
import ru.tinkoff.finteh.spring_homework.entity.Status
import ru.tinkoff.finteh.spring_homework.repository.EventsRepository

@Service
class EventService(
    private val repository: EventsRepository,
    @Autowired private val jmsTemplate: JmsTemplate,
    private val mapper: ObjectMapper = jacksonObjectMapper()
) {


    fun addEvent(event: EventDtoRequest) {
        repository.save(Event(type = event.type, body = event.body, status = Status.NEW))
    }

    fun producerEvent() {
        val events = repository.findByStatusIs(Status.NEW)
        for (it in events) {
            it.status = Status.IN_PROCESS

            jmsTemplate.convertAndSend(NAME_QUEUE, mapper.writeValueAsString(it))
        }
    }
}