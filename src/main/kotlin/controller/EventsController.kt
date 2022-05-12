package ru.tinkoff.finteh.spring_homework.controller


import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.tinkoff.finteh.spring_homework.dto.request.EventDtoRequest
import ru.tinkoff.finteh.spring_homework.service.EventService

@RestController
@RequestMapping("/event")
class EventsController(private val eventService: EventService) {

    @PostMapping("/add")
    fun addEvent(@RequestBody event: EventDtoRequest): ResponseEntity<String> {
        return try {
            eventService.addEvent(event)
            ResponseEntity<String>(MESSAGE_CREATED, HttpStatus.CREATED)
        } catch (e: Exception) {
            ResponseEntity<String>(MESSAGE_EXCEPTION, HttpStatus.CONFLICT)
        }
    }

    @GetMapping()
    fun toProduce(): ResponseEntity<String> {
        return try {
            eventService.producerEvent()
            ResponseEntity<String>(MESSAGE_OK, HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity<String>(MESSAGE_EXCEPTION, HttpStatus.CONFLICT)
        }
    }
}

const val MESSAGE_OK = "OK"
const val MESSAGE_CREATED = "CREATED"
const val MESSAGE_EXCEPTION = "EXCEPTION"