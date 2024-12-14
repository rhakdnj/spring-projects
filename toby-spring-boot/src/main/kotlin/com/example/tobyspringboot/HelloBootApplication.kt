package com.example.tobyspringboot

import com.example.config.MySpringBootApplication
import org.springframework.boot.runApplication

@MySpringBootApplication
class HelloBootApplication

fun main(args: Array<String>) {
    runApplication<HelloBootApplication>(*args)
}
