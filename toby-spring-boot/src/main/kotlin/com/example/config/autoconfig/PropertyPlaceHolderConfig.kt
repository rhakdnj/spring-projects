package com.example.config.autoconfig

import com.example.config.MyAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer

@MyAutoConfiguration
class PropertyPlaceHolderConfig {

    @Bean
    fun propertySourcesPlaceholderConfigurer(): PropertySourcesPlaceholderConfigurer {
        return PropertySourcesPlaceholderConfigurer()
    }

}
