package com.example.tobyspringboot

import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class HelloRepositoryJdbc(
    private val jdbcTemplate: JdbcTemplate,
) : HelloRepository {
    override fun findOneByName(name: String): Hello? {
        return try {
            jdbcTemplate.queryForObject(
                "select * from hello_boot where name = '$name'",
            ) { rs, _ ->
                Hello(
                    name = rs.getString("name"),
                    count = rs.getInt("count"),
                )
            }
        } catch (e: EmptyResultDataAccessException) {
            null
        }
    }

    override fun increaseCount(name: String) {
        val hello = findOneByName(name)

        if (hello == null) {
            jdbcTemplate.update(
                "insert into hello_boot(name, count) values('$name', 1)",
            )
        } else {
            jdbcTemplate.update(
                "update hello_boot set count = count + 1 where name = '$name'",
            )
        }
    }
}
