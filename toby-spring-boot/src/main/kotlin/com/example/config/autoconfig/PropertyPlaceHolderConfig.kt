package com.example.config.autoconfig

import com.example.config.MyAutoConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer

@MyAutoConfig
class PropertyPlaceHolderConfig {

    @Bean
    fun propertySourcesPlaceholderConfigurer(): PropertySourcesPlaceholderConfigurer {
        return PropertySourcesPlaceholderConfigurer()
    }

}
