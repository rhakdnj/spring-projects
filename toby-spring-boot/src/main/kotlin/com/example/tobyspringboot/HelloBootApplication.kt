package com.example.tobyspringboot

import com.example.config.MySpringBootApplication
import jakarta.annotation.PostConstruct
import org.springframework.boot.runApplication
import org.springframework.jdbc.core.JdbcTemplate

@MySpringBootApplication
class HelloBootApplication(
    private val jdbcTemplate: JdbcTemplate,
) {
    @PostConstruct
    fun init() {
        jdbcTemplate.execute("create table if not exists hello_boot(name varchar(50) primary key, count int)")
    }
}

fun main(args: Array<String>) {
    runApplication<HelloBootApplication>(*args)
}
