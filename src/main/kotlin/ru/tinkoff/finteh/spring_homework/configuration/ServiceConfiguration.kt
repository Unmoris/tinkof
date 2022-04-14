package ru.tinkoff.finteh.spring_homework.configuration

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.web.client.RestTemplate
import java.time.Duration
import javax.sql.DataSource

@Configuration
class ServiceConfiguration {

    @Bean
    fun jdbcTemplate(dataSource: DataSource): JdbcTemplate = JdbcTemplate(dataSource)

    @Bean
    fun restTemplate(builder: RestTemplateBuilder): RestTemplate = builder
        .setConnectTimeout(Duration.ofSeconds(CONNECT_TIMEOUT_IN_SECONDS))
        .setReadTimeout(Duration.ofSeconds(READ_TIMEOUT_IN_SECONDS))
        .build()
}

private const val CONNECT_TIMEOUT_IN_SECONDS = 30L
private const val READ_TIMEOUT_IN_SECONDS = 60L
