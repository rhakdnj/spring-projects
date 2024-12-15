package com.example.config.autoconfig

import com.example.config.ConditionalMyOnClass
import com.example.config.MyAutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean

@MyAutoConfiguration
@ConditionalMyOnClass(value = "org.eclipse.jetty.server.Server")
class JettyWebServerConfig {

    @Bean("jettyWebServerFactory")
    @ConditionalOnMissingBean
    fun servletWebServerFactory(): ServletWebServerFactory {
        return JettyServletWebServerFactory()
    }

}
