package com.example.tobyspringboot

import jakarta.annotation.PostConstruct
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.condition.ConditionEvaluationReport
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.jdbc.core.JdbcTemplate

@SpringBootApplication
class HelloBootApplication(
    private val jdbcTemplate: JdbcTemplate,
) {
    @PostConstruct
    fun init() {
        jdbcTemplate.execute("create table if not exists hello_boot(name varchar(50) primary key, count int)")
    }

    @Bean
    fun applicationRunner(report: ConditionEvaluationReport): ApplicationRunner {
        return ApplicationRunner {
            println(
                report.conditionAndOutcomesBySource.entries
                    .filter { it.value.isFullMatch }
                    .filter { it.key.indexOf("Jmx") < 0 }
                    .map {
                        println(it.key)
                        it.value.forEach { co ->
                            println("\t ${co.outcome}")
                        }
                        println()
                    }.count(),
            )
        }
    }

}

fun main(args: Array<String>) {
    runApplication<HelloBootApplication>(*args)
}
