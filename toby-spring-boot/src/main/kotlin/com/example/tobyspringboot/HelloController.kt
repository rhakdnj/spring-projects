package com.example.tobyspringboot

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController(
    private val helloService: HelloService,
) {

    @GetMapping("/hello")
    fun hello(name: String?): String {
        require(!(name == null || name.trim().isEmpty()))

        return helloService.sayHello(name)
    }

}
