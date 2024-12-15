package com.example.config.autoconfig

import com.example.config.ConditionalMyOnClass
import com.example.config.EnableMyConfigurationProperties
import com.example.config.MyAutoConfiguration
import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate
import org.springframework.context.annotation.Bean
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.SimpleDriverDataSource
import org.springframework.jdbc.support.JdbcTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import java.sql.Driver
import javax.sql.DataSource

@MyAutoConfiguration
@ConditionalMyOnClass("org.springframework.jdbc.core.JdbcOperations")
@EnableMyConfigurationProperties(DataSourceProperties::class)
@EnableTransactionManagement
class DataSourceConfig {

    @Bean
    @ConditionalMyOnClass("com.zaxxer.hikari.HikariDataSource")
    @ConditionalOnMissingBean
    fun hikariDataSource(properties: DataSourceProperties): DataSource {
        return HikariDataSource().apply {
            driverClassName = properties.driverClassName
            jdbcUrl = properties.url
            username = properties.username
            password = properties.password
        }
    }

    @Bean
    @ConditionalOnMissingBean
    fun dataSource(properties: DataSourceProperties): DataSource {
        val dataSource = SimpleDriverDataSource()

        dataSource.setDriverClass(Class.forName(properties.driverClassName) as Class<out Driver>)
        dataSource.url = properties.url
        dataSource.username = properties.username
        dataSource.password = properties.password

        return dataSource
    }

    @Bean
    @ConditionalOnSingleCandidate(DataSource::class)
    @ConditionalOnMissingBean
    fun jdbcTemplate(dataSource: DataSource): JdbcTemplate {
        return JdbcTemplate(dataSource)
    }

    @Bean
    @ConditionalOnSingleCandidate(DataSource::class)
    @ConditionalOnMissingBean
    fun jdbcTransactionManager(dataSource: DataSource): JdbcTransactionManager {
        return JdbcTransactionManager(dataSource)
    }

}
