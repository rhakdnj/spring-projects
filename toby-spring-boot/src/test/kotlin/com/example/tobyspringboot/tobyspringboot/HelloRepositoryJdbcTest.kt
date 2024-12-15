package com.example.tobyspringboot.tobyspringboot

import com.example.tobyspringboot.HelloBootApplication
import com.example.tobyspringboot.HelloRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.test.context.ContextConfiguration
import org.springframework.transaction.annotation.Transactional

@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ContextConfiguration(classes = [HelloBootApplication::class])
class HelloRepositoryJdbcTest(
    @Autowired private val helloRepository: HelloRepository,
    @Autowired private val jdbcTemplate: JdbcTemplate,
) {

    @Test
    fun findNull() {
        Assertions.assertThat(helloRepository.findOneByName("jaime")).isNull()
    }

    @Test
    fun increaseCount() {
        Assertions.assertThat(helloRepository.countOf("jaime")).isEqualTo(0)

        helloRepository.increaseCount("jaime")
        Assertions.assertThat(helloRepository.countOf("jaime")).isEqualTo(1)

        helloRepository.increaseCount("jaime")
        Assertions.assertThat(helloRepository.countOf("jaime")).isEqualTo(2)
    }

}
