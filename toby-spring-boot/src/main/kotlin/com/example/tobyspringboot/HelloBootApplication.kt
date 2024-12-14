package com.example.tobyspringboot

import org.springframework.boot.runApplication

@MySpringBootApplication
class HelloBootApplication

fun main(args: Array<String>) {
    runApplication<HelloBootApplication>(*args)
}
