package ru.tinkoff.finteh.spring_homework.repository

import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import ru.tinkoff.finteh.spring_homework.entity.Event
import ru.tinkoff.finteh.spring_homework.entity.Status

@Repository
interface EventsRepository : CrudRepository<Event, Long> {

    fun findByStatusIs(status: Status): List<Event>

    @Transactional
    @Modifying
    @Query("update Event e set e.status = ?1 where e.id = ?2")
    fun updateStatusByIdIs(status: Status, id: Long): Int

}