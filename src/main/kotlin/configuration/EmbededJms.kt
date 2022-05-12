package ru.tinkoff.finteh.spring_homework.configuration

import org.apache.activemq.command.ActiveMQQueue
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jms.annotation.EnableJms
import javax.jms.Queue


@Configuration
@EnableJms
class EmbededJms {
    @Bean
    fun createQueue(): Queue? {
        return ActiveMQQueue("NAME_QUEUE")
    }
}

const val NAME_QUEUE = "events"