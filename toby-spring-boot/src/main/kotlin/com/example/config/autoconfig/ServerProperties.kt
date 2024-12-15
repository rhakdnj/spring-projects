package com.example.config.autoconfig

import com.example.config.MyConfigurationProperties

@MyConfigurationProperties(prefix = "my-server")
class ServerProperties {
    lateinit var contextPath: String
    var port: Int = 8080
}
