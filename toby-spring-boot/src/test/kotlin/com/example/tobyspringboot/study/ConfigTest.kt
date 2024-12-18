package com.example.tobyspringboot.study

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

class ConfigTest {
    @Test
    fun `proxyBeanMethods=true 일 때 Proxy Object를 사용힙니다`() {
        val applicationContext = AnnotationConfigApplicationContext(MyConfig::class.java)

        val bean1 = applicationContext.getBean(Bean1::class.java)
        val bean2 = applicationContext.getBean(Bean2::class.java)

        Assertions.assertThat(bean1.common).isSameAs(bean2.common)
    }

    @Test
    @Disabled
    fun `proxyBeanMethods=true 일 때 Proxy Object를 사용 경우를 흉내냅니다`() {
        val proxy = MyConfigProxy()

        val bean1 = proxy.bean1()
        val bean2 = proxy.bean2()

        Assertions.assertThat(bean1.common).isSameAs(bean2.common)
    }

    class MyConfigProxy : MyConfig() {
        var common: Common? = null

        override fun common(): Common {
            if (this.common == null) {
                this.common = super.common()
            }
            return this.common!!
        }
    }

//    @Configuration(proxyBeanMethods = false)
    @Configuration
    class MyConfig {
        @Bean
        fun common(): Common = Common()

        @Bean
        fun bean1(): Bean1 = Bean1(common()) // proxyBeanMethods=false 일 때 bean 생성 메서드 호출 할 때 proxy 사용 하지 않음
//        fun bean1(common: Common): Bean1 = Bean1(common) // proxyBeanMethods 영향을 받지 않음 동일 common object 사용

        @Bean
        fun bean2(): Bean2 = Bean2(common())
    }

    // Bean1 <- common
    class Bean1(
        val common: Common,
    )

    // Bean2 <- common
    class Bean2(
        val common: Common,
    )

    class Common
}
