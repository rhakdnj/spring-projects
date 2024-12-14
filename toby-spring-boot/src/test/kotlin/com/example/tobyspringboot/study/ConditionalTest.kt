package com.example.tobyspringboot.study

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.runner.ApplicationContextRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Condition
import org.springframework.context.annotation.ConditionContext
import org.springframework.context.annotation.Conditional
import org.springframework.context.annotation.Configuration
import org.springframework.core.type.AnnotatedTypeMetadata

class ConditionalTest {

    @Test
    fun conditional() {
        ApplicationContextRunner()
            .withUserConfiguration(Config1::class.java)
            .run {
                Assertions.assertThat(it).hasSingleBean(MyBean::class.java)
                Assertions.assertThat(it).hasSingleBean(Config1::class.java)
            }

        ApplicationContextRunner()
            .withUserConfiguration(Config2::class.java)
            .run {
                Assertions.assertThat(it).doesNotHaveBean(MyBean::class.java)
                Assertions.assertThat(it).doesNotHaveBean(Config2::class.java)
            }
    }

    @Configuration
    @BooleanConditional(true)
    class Config1 {

        @Bean
        fun myBean(): MyBean {
            return MyBean()
        }

    }

    @Configuration
    @BooleanConditional(false)
    class Config2 {

        @Bean
        fun myBean(): MyBean {
            return MyBean()
        }

    }

    class MyBean

    @Retention(AnnotationRetention.RUNTIME)
    @Target(AnnotationTarget.CLASS)
    @Conditional(BooleanCondition::class)
    annotation class BooleanConditional(val value: Boolean)

    class BooleanCondition : Condition {
        override fun matches(
            context: ConditionContext,
            metadata: AnnotatedTypeMetadata,
        ): Boolean {
            val annotationAttributes = metadata.getAnnotationAttributes(BooleanConditional::class.java.name)
            return annotationAttributes?.get("value") as Boolean
        }
    }

}
