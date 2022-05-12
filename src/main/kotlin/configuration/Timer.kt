package ru.tinkoff.finteh.spring_homework.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import ru.tinkoff.finteh.spring_homework.service.EventService


@Configuration
@EnableScheduling
class Timer(private val eventService: EventService) {

    @Scheduled(fixedDelay = 3600000)
    fun produceEvents() {
        eventService.producerEvent()
    }
}