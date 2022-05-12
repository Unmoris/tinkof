package ru.tinkoff.finteh.spring_homework.entity

import javax.persistence.*


@Entity
@Table(name = "Events")
class Event(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null,

    @Column(name = "type")
    var type: Type? = null,

    @Column(name = "body")
    var body: String? = null,

    @Column(name = "status")
    var status: Status? = null,

    )
