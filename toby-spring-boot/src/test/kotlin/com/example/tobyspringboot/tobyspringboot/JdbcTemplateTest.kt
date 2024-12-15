package com.example.tobyspringboot.tobyspringboot

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate

@HelloBootTest
class JdbcTemplateTest(
    @Autowired private val jdbcTemplate: JdbcTemplate,
) {

    @BeforeEach
    fun setUp() {
        jdbcTemplate.execute("create table if not exists hello_boot(name varchar(50) primary key, count int)")
    }

    //    @Rollback(false)
    @Test
    fun `데이터를 넣고 정상적으로 조회가 되는 지 검증한다1`() {
        jdbcTemplate.update("insert into hello_boot values(?, ?)", "jamie", 1)
        jdbcTemplate.update("insert into hello_boot values(?, ?)", "jamie-", 1)

        val count =
            jdbcTemplate.queryForObject(
                "select count(*) from hello_boot",
                Long::class.java,
            )

        Assertions.assertThat(count).isEqualTo(2)
    }

    @Test
    fun `데이터를 넣고 정상적으로 조회가 되는 지 검증한다2`() {
        jdbcTemplate.update("insert into hello_boot values(?, ?)", "jamie", 1)
        jdbcTemplate.update("insert into hello_boot values(?, ?)", "jamie-", 1)

        val count =
            jdbcTemplate.queryForObject(
                "select count(*) from hello_boot",
                Long::class.java,
            )

        Assertions.assertThat(count).isEqualTo(2)
    }

}
