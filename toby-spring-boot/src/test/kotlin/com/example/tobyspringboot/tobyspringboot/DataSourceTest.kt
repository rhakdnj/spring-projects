package com.example.tobyspringboot.tobyspringboot

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import javax.sql.DataSource

@HelloBootTest
class DataSourceTest(
    @Autowired private val dataSource: DataSource,
) {

    @Test
    fun `데이터 베이스와의 connection을 검증한다`() {
        val connection = dataSource.connection
        connection.close()
    }

}
