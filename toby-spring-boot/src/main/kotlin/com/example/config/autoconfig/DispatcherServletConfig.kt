package com.example.config.autoconfig

import com.example.config.MyAutoConfig
import org.springframework.context.annotation.Bean
import org.springframework.web.servlet.DispatcherServlet

@MyAutoConfig
class DispatcherServletConfig {

    @Bean
    fun dispatcherServlet(): DispatcherServlet {
        return DispatcherServlet()
    }

}
