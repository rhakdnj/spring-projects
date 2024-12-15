package com.example.tobyspringboot

import org.springframework.stereotype.Service

@Service
class SimpleHelloService(
    private val helloRepository: HelloRepository,
) : HelloService {

    override fun sayHello(name: String): String {
        this.helloRepository.increaseCount(name)
        return "Hello $name"
    }

}
