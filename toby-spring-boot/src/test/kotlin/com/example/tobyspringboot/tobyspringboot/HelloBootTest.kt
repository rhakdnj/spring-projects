package com.example.tobyspringboot.tobyspringboot

import com.example.tobyspringboot.HelloBootApplication
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean
import org.springframework.core.env.PropertiesPropertySource
import org.springframework.core.env.PropertySource
import org.springframework.core.io.support.EncodedResource
import org.springframework.core.io.support.PropertySourceFactory
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.transaction.annotation.Transactional

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [HelloBootApplication::class])
@TestPropertySource(locations = ["classpath:/application.yml"], factory = YamlPropertySourceFactory::class)
@Transactional
annotation class HelloBootTest

class YamlPropertySourceFactory : PropertySourceFactory {
    override fun createPropertySource(
        name: String?,
        encodedResource: EncodedResource,
    ): PropertySource<*> {
        val resource = encodedResource.resource

        val factory =
            YamlPropertiesFactoryBean().apply {
                setResources(resource)
            }

        return PropertiesPropertySource(resource.filename!!, factory.`object`!!)
    }
}
