package com.example.tobyspringboot.tobyspringboot

import com.example.tobyspringboot.HelloRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate

@HelloBootTest
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
