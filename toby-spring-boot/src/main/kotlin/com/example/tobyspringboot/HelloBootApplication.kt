package com.example.tobyspringboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HelloBootApplication

fun main(args: Array<String>) {
	runApplication<HelloBootApplication>(*args)
}
