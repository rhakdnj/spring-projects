package com.example.config.autoconfig

import com.example.config.MyConfigurationProperties

@MyConfigurationProperties(prefix = "data-source")
class DataSourceProperties {
    lateinit var driverClassName: String
    lateinit var url: String
    lateinit var username: String
    lateinit var password: String
}
