package com.example.tobyspringboot.tobyspringboot

import com.example.tobyspringboot.HelloBootApplication
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest
import org.springframework.test.context.ContextConfiguration
import javax.sql.DataSource

@JdbcTest
@ContextConfiguration(
    classes = [HelloBootApplication::class],
) // 여러 개의 SpringBootApplication 이 있을 때 ContextConfiguration 지정
class DataSourceTest(
    @Autowired private val dataSource: DataSource,
) {

    @Test
    fun `데이터 베이스와의 connection을 검증한다`() {
        val connection = dataSource.connection
        connection.close()
    }

}
