package com.example.config.autoconfig

import com.example.config.ConditionalMyOnClass
import com.example.config.EnableMyConfigurationProperties
import com.example.config.MyAutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean

@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
@EnableMyConfigurationProperties(ServerProperties::class)
class TomcatWebServerConfig {

    @Bean("tomcatWebServerFactory")
    @ConditionalOnMissingBean
    fun servletWebServerFactory(properties: ServerProperties): ServletWebServerFactory {
        val factory = TomcatServletWebServerFactory()
        factory.contextPath = properties.contextPath
        factory.port = properties.port
        return factory
    }

}
