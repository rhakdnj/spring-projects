package com.example.tobyspringboot

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration(proxyBeanMethods = false)
class WebServerConfig {

    @Bean
    fun webServerFactory(): ServletWebServerFactory {
        val serverFactory = TomcatServletWebServerFactory()
        serverFactory.port = 9090
//        serverFactory.contextPath = "/api"
        return serverFactory
    }

}
