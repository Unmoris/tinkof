package ru.tinkoff.finteh.spring_homework.service.consumer

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Component
import ru.tinkoff.finteh.spring_homework.client.EmailLClient
import ru.tinkoff.finteh.spring_homework.client.PushClient
import ru.tinkoff.finteh.spring_homework.client.SMSClient
import ru.tinkoff.finteh.spring_homework.configuration.NAME_QUEUE
import ru.tinkoff.finteh.spring_homework.entity.Event
import ru.tinkoff.finteh.spring_homework.entity.Type

@Component
class EventConsumer(
    private val mapper: ObjectMapper = jacksonObjectMapper(),
    private val emailLClient: EmailLClient,
    private val pushClient: PushClient,
    private val smsClient: SMSClient
) {

    @JmsListener(destination = NAME_QUEUE)
    fun listener(eventString: String) {
        val event: Event = mapper.readValue(eventString, Event::class.java)
        when (event.type) {
            Type.SMS -> smsClient.printInfo(event)
            Type.EMAIL -> emailLClient.printInfo(event)
            Type.PUSH -> pushClient.printInfo(event)
        }
    }
}