package com.example.config.autoconfig

import com.example.config.ConditionalMyOnClass
import com.example.config.MyAutoConfig
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean

@MyAutoConfig
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
class TomcatWebServerConfig {

    @Value("\${server.servlet.context-path}")
    lateinit var contextPath: String

    @Bean("tomcatWebServerFactory")
    @ConditionalOnMissingBean
    fun servletWebServerFactory(): ServletWebServerFactory {
        val factory = TomcatServletWebServerFactory()
        factory.contextPath = this.contextPath
        return factory
    }

}
