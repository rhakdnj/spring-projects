package com.example.config.autoconfig

import com.example.config.MyAutoConfig
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean

@MyAutoConfig
class JettyWebServerConfig {

    @Bean("jettyWebServerFactory")
    fun servletWebServerFactory(): ServletWebServerFactory {
        return JettyServletWebServerFactory()
    }

}
