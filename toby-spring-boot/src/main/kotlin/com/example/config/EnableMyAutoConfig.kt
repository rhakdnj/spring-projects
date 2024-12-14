package com.example.config

import com.example.config.autoconfig.DispatcherServletConfig
import com.example.config.autoconfig.TomcatWebServerConfig
import org.springframework.context.annotation.Import

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@Import(DispatcherServletConfig::class, TomcatWebServerConfig::class)
annotation class EnableMyAutoConfig
