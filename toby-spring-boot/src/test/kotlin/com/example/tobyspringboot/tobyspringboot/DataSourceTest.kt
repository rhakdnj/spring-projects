package com.example.tobyspringboot.tobyspringboot

import com.example.tobyspringboot.HelloBootApplication
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean
import org.springframework.core.env.PropertiesPropertySource
import org.springframework.core.env.PropertySource
import org.springframework.core.io.support.EncodedResource
import org.springframework.core.io.support.PropertySourceFactory
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit.jupiter.SpringExtension
import javax.sql.DataSource

@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [HelloBootApplication::class])
@TestPropertySource(locations = ["classpath:/application.yml"], factory = YamlPropertySourceFactory::class)
class DataSourceTest(
    @Autowired private val dataSource: DataSource,
) {

    @Test
    fun `데이터 베이스와의 connection을 검증한다`() {
        val connection = dataSource.connection
        connection.close()
    }

}

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
