package com.example.config.autoconfig

import com.example.config.MyAutoConfig
import org.springframework.boot.context.properties.bind.Binder
import org.springframework.context.annotation.Bean
import org.springframework.core.env.Environment

@MyAutoConfig
class ServerPropertiesConfig {

    @Bean
    fun serverProperties(env: Environment): ServerProperties {
        return Binder.get(env).bind("my-server", ServerProperties::class.java).get()
    }

}
